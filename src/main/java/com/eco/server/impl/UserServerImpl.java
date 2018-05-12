package com.eco.server.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserAccount;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.TimeSheetDao;
import com.eco.dao.UserAccountDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.TimeSheetDaoImpl;
import com.eco.dao.impl.UserAccountDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.UserServer;

public class UserServerImpl implements UserServer{


	@Override
	public PageContainer<Course> queryUserNowCourseListByUserId(Integer userId, PageContainer pageContainer) {
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectUserNowCourseListByUserId(userId);
	}

	@Override
	public PageContainer<Course> queryUserAllCourseListByUserId(Integer userId, PageContainer pageContainer) {
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectUserAllCourseDetailListByUserId(userId);
	}

	@Override
	public PageContainer<Course> queryUserHistoryCourseListByUserId(Integer userId, PageContainer pageContainer) {
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectUserHistoryCourseDetailListByUserId(userId);
	}

	@Override
	public PageContainer<Engclass> queryUserAllEngclassByUserId(Integer userId, PageContainer pageContainer) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectUserAllEngclassListByUserId(userId);
	}
	
	@Override
	public  PageContainer<Engclass> queryUserNowEngclassByUserId(Integer userId, PageContainer pageContainer) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectUserNowEngclassListByUserId(userId);
	}
	
	@Override
	public PageContainer<Engclass> queryUserHistoryEngclassListByUserId(Integer userid, PageContainer pageContainer) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectUserHistoryEngclassListByUserId(userid);
	}
	
	@Override
	public PageContainer<TeacherBackInfo> queryTeacherBackInfoByEngclassIdAndUserId(Integer engclassId,Integer userId, PageContainer pageContainer) {
		TeacherBackInfoDao teacherBackInfoDao = new TeacherBackInfoDaoImpl();
		return teacherBackInfoDao.selectTeacherBackInfoByEngclassId(userId, engclassId);
	}

	@Override
	public PageContainer<TimeSheet> queryTimeSheetByUserId(Integer userId,Integer engclassId,String queryDate,PageContainer pageContainer){
		PageContainer<TimeSheet> timeSheetList = null;
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		timeSheetDao.setPageContainer(pageContainer);
		if("".equals(queryDate)) {
			//按classid查出该用户在该班级的所有考勤记录
			timeSheetList = timeSheetDao.selectTimeSheetByUserIdAndEngclassId(userId, engclassId);
		}else {
			Date formateDate = stringFormateToDate(queryDate);
			timeSheetList = timeSheetDao.selectTimeSheetByUserIdAndEngclassIdAndDate(userId, engclassId, formateDate);
		}			
		return timeSheetList;
	}
	
	protected Date stringFormateToDate(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addTimeSheet(TimeSheet timeSheet) {
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
		/*if((timeSheetDao.selectTimeSheetListByEnclassIdAndDate(timeSheet.getClassId(), timeSheet.getRecordTime())).size() != 0 ) {
			
			return "不允许重复对当天请假";
		}else if(courseRecordDao.isOverEndTime(timeSheet.getClassId(),timeSheet.getRecordTime())) {
			return "超出课程结课时间";
		}
		else {
			
			timeSheetDao.insert(timeSheet);
			return "提交成功";
		}*/
		return "";
	}
	
	
	@Override
	public PageContainer<User> queryUserListByClassid(Integer engclassId,PageContainer pageContainer) {
		UserDao userDao = new UserDaoImpl();
		userDao.setPageContainer(pageContainer);
		return userDao.selectEngclassAllUserByEngclassId(engclassId);
	}

	@Override
	public PageContainer<TimeSheet> queryUserTimeSheetByEngclassId(Integer engclassId,Date date){
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		return timeSheetDao.selectTimeSheetByEnglassIdAndDate(engclassId, date);
		
	}

	@Override
	public Boolean loginCheck(UserAccount userAccount) {
		UserAccountDao userAccountDao = new UserAccountDaoImpl();
		if(userAccountDao.countAccount(userAccount.getId()) != 1) {
			return false;
		}
		if(!userAccountDao.selectAccount(userAccount.getId()).getPassword().equals(userAccount.getPassword())) {
			return false;
		}
		return true;
	}

	@Override
	public User queryUserByAccountId(Integer accountId) {
		UserAccountDao userAccountDao = new UserAccountDaoImpl();
		User user = userAccountDao.selectAccount(accountId).getUser();
		return user;
	}

	@Override
	public boolean mergeEngclass(Integer oldEngclassId1, Integer oldEngclassId2, Integer engclassId) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		//engclassDao.updateUserEngclassId(oldEngclassId1, engclassId);
		//engclassDao.updateUserEngclassId(oldEngclassId2, engclassId);
		return true;
	}

	
}

