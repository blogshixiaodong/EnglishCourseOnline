package com.eco.server.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserAccount;
import com.eco.bean.model.UserBackInfo;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.TimeSheetDao;
import com.eco.dao.UserAccountDao;
import com.eco.dao.UserBackInfoDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.TimeSheetDaoImpl;
import com.eco.dao.impl.UserAccountDaoImpl;
import com.eco.dao.impl.UserBackInfoDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.UserServer;
import com.eco.util.DateFormat;

public class UserServerImpl implements UserServer{


	@Override
	public PageContainer<Course> queryUserNowCourseListByUserId(Integer userId, PageContainer<Course> pageContainer) {
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectUserNowCourseListByUserId(userId);
	}

	@Override
	public PageContainer<Course> queryUserAllCourseListByUserId(Integer userId, PageContainer<Course> pageContainer) {
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectUserAllCourseDetailListByUserId(userId);
	}

	@Override
	public PageContainer<Course> queryUserHistoryCourseListByUserId(Integer userId, PageContainer<Course> pageContainer) {
		CourseDao courseDao = new CourseDaoImpl();
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectUserHistoryCourseDetailListByUserId(userId);
	}

	@Override
	public PageContainer<Engclass> queryUserAllEngclassByUserId(Integer userId, PageContainer<Engclass> pageContainer) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectUserAllEngclassListByUserId(userId);
	}
	
	@Override
	public  PageContainer<Engclass> queryUserNowEngclassByUserId(Integer userId, PageContainer<Engclass> pageContainer) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectUserNowEngclassListByUserId(userId);
	}
	
	@Override
	public PageContainer<Engclass> queryUserHistoryEngclassListByUserId(Integer userid, PageContainer<Engclass> pageContainer) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectUserHistoryEngclassListByUserId(userid);
	}
	
	@Override
	public List<Engclass> queryEngclassByUserId(Integer userId) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		List<Engclass> engclassList = engclassDao.selectEngclassByUserId(userId);
		return engclassList;
	}
	
	@Override
	public PageContainer<TeacherBackInfo> queryTeacherBackInfoByEngclassIdAndUserId(Integer engclassId,Integer userId, PageContainer<TeacherBackInfo> pageContainer) {
		TeacherBackInfoDao teacherBackInfoDao = new TeacherBackInfoDaoImpl();
		teacherBackInfoDao.setPageContainer(pageContainer);
		return teacherBackInfoDao.selectTeacherBackInfoByEngclassId(userId, engclassId);
	}
	
	@Override
	public PageContainer<UserBackInfo> queryUserBackInfoByEngclassIdAndUserId(Integer engclassId, Integer userId,PageContainer<UserBackInfo> pageContainer) {
		UserBackInfoDao userBackInfoDao = new UserBackInfoDaoImpl();
		userBackInfoDao.setPageContainer(pageContainer);
		return userBackInfoDao.selectUserBackInfoByUserIdAndEngclassId(userId, engclassId);
	}
	
	@Override
	public PageContainer<TimeSheet> queryTimeSheetByUserId(Integer userId,Integer engclassId,String queryDate,PageContainer<TimeSheet> pageContainer){
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
	public String addTimeSheet(TimeSheet timeSheet,Integer userId) {
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		if( timeSheetDao.countCourseByUserIdAndEngclassIdAndDate(userId, timeSheet.getEngclass().getEngclassId(), timeSheet.getRecordTime()) == 1 ) {
			return timeSheet.getRecordTime()+"没有该课程";
		}else if(timeSheetDao.countTimeSheetByUserIdAndEngclassIdAndDate(userId, timeSheet.getEngclass().getEngclassId(), timeSheet.getRecordTime()) == 1) {
			return "不允许重复对当天请假";
		}else {
			User user = new User();
			user.setUserId(userId);
			timeSheet.setUser(user);
			timeSheetDao.insertTimeSheet(timeSheet);
			return "提交成功";
		}
	}
	
	@Override
	public PageContainer<User> queryUserListByEngclassId(Integer engclassId,PageContainer<User> pageContainer) {
		UserDao userDao = new UserDaoImpl();
		userDao.setPageContainer(pageContainer);
		return userDao.selectEngclassAllUserByEngclassId(engclassId);
	}

	@Override
	public PageContainer<TimeSheet> queryUserTimeSheetByEngclassId(Integer engclassId, Date date, PageContainer pageContainer){
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		timeSheetDao.setPageContainer(pageContainer);
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
	public void addUserBackInfo(UserBackInfo userBackInfo,Integer userId) {
		UserBackInfoDao userBackInfoDao = new UserBackInfoDaoImpl();
		User user = new User();
		user.setUserId(userId);
		userBackInfo.setUser(user);
		userBackInfo.setBackTime(new Date());
		userBackInfoDao.insertUserBackInfo(userBackInfo);
	}

	@Override
	public PageContainer<CourseRecord> queryAllEnroll(PageContainer<CourseRecord> pageContainer) {
		CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
		courseRecordDao.setPageContainer(pageContainer);
		return courseRecordDao.selectNowCoureseRecord();
	}

	@Override
	public void addUserEngclass(Integer userId, Integer courseRecordId) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectUserByUserId(userId);
		Engclass engclass = engclassDao.selectEngclassByCourseRecord(courseRecordId);
		engclass.getUserSet().add(user);
		engclassDao.insertUser(engclass);
	}

	@Override
	public PageContainer<UserBackInfo> queryUserBackInfoByEngclassId(Integer engclassId, PageContainer<UserBackInfo> pageContainer) {
		UserBackInfoDao userBackInfoDao = new UserBackInfoDaoImpl();
		userBackInfoDao.setPageContainer(pageContainer);
		return userBackInfoDao.selectUserBackInfoByEngclassId(engclassId);
	}

	@Override
	public List<Engclass> queryTimeTable(String queryDate, Integer userId) {
		Date startDate = DateFormat.stringToDate(queryDate);
		EngclassDao engclassDao = new EngclassDaoImpl();
		List<Engclass> engclasseList = engclassDao.selectEngclassByDate(startDate, userId);
		return engclasseList;
	}


}

