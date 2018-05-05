package com.eco.server.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.Account;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserClass;
import com.eco.dao.AccountDao;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.TimeSheetDao;
import com.eco.dao.UserClassDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.AccountDaoImpl;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.TimeSheetDaoImpl;
import com.eco.dao.impl.UserClassDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.UserServer;

public class UserServerImpl implements UserServer{


	//@Override
//	public boolean enrolmentClass(UserClass userClass, Integer crId) {
//		//UserDao userDao = new UserDaoImpl();
//		UserClassDao userClassDao = new UserClassDaoImpl();
//		CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
//		
//		//1.添加一条用户班级表记录
//		userClassDao.insert(userClass);
//		
//		//2.修改课程记录表中报名人数
//		//rcDao.updateSignCount(crId);
//		
//		return true;
//	}

	@Override
	public List<CourseDetail> queryUserNowCourseListByUserId(Integer userId,PageContainer pageContainer){
		
		CourseDao courseDao = new CourseDaoImpl();
		pageContainer.setPageSize(5);
		
		pageContainer.setRecordCount(courseDao.countNowCourseDetailByUserId(userId));
		courseDao.beginPaging(pageContainer);
		return courseDao.selectUserNowCourseDetailListByUserId(userId);

	}

	@Override
	public List<CourseDetail> queryUserAllCourseListByUserId(Integer userId, PageContainer pageContainer){
		CourseDao courseDao = new CourseDaoImpl();
		pageContainer.setPageSize(5);
		//courseDao.beginPaging(pageContainer);
		pageContainer.setRecordCount(courseDao.countAllCourseDetailByUserId(userId));
		courseDao.beginPaging(pageContainer);
		return courseDao.selectUserAllCourseDetailListByUserId(userId);
	}

	@Override
	public List<CourseDetail> queryUserHistoryCourseListByUserId(Integer userId,PageContainer pageContainer){
		CourseDao courseDao = new CourseDaoImpl();
		pageContainer.setPageSize(5);
		
		
		pageContainer.setRecordCount(courseDao.countHistoryCourseDetailByUserId(userId));
		courseDao.beginPaging(pageContainer);
		return courseDao.selectUserHistoryCourseDetailListByUserId(userId);
	}

	@Override
	public List<EngclassDetail> queryUserAllEngclassByUserId(Integer userId,PageContainer pageContainer){
		EngclassDao engclassDao = new EngclassDaoImpl();
		
		List<EngclassDetail> engclassDetailList = null;
		
		//如果pageContainer为null  则为不需要分页
		if(pageContainer != null) {
			pageContainer.setPageSize(5);
			
			pageContainer.setRecordCount(engclassDao.countAllEngclassDetailByUserId(userId));
			
			engclassDao.beginPaging(pageContainer);
			engclassDetailList = engclassDao.selectUserAllEngclassListByUserId(userId);
		}else {
			engclassDetailList = engclassDao.selectUserAllEngclassListByUserId(userId);
		}
		
		return engclassDetailList;
	}
	
	
	@Override
	public List<EngclassDetail> queryUserNowEngclassByUserId(Integer userId){
		EngclassDao engclassDao = new EngclassDaoImpl();
		return engclassDao.selectUserNowEngclassListByUserId(userId);
	}
	
	
	@Override
	public List<BackInfoDetail> queryTeacherBackInfoByEngclassIdAndUserId(Integer engclassId,Integer userId){
		TeacherBackInfoDao tbiDao = new TeacherBackInfoDaoImpl();
		return tbiDao.selectBackInfoDetailByEngclassIdAndUserId(engclassId, userId);
	}

	@Override
	public List<TimeSheetDetail> queryTimeSheetByUserId(Integer userId,Integer engclassId,String queryDate){
		List<TimeSheetDetail> timeSheetDetailList = null;
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		
		
		if("".equals(queryDate)) {
			
			//按classid查出该用户在该班级的所有考勤记录
			timeSheetDetailList = timeSheetDao.selectTimeSheetByUserIdAndEngclassId(userId, engclassId);
		
		}else {
			
			Date formateDate = stringFormateToDate(queryDate);
			timeSheetDetailList = timeSheetDao.selectTimeSheetByUserIdAndEngclassIdAndTime(userId, engclassId, formateDate);
		}			
		return timeSheetDetailList;
	}
	
	protected Date stringFormateToDate(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(stringDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String addTimeSheet(TimeSheet timeSheet) {
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
		
		//Date formateDate = stringFormateToDate(timeSheet.getRecordTime());
		
		if((timeSheetDao.selectTimeSheetListByEnclassIdAndDate(timeSheet.getClassId(), timeSheet.getRecordTime())).size() != 0 ) {
			
			return "不允许重复对当天请假";
		}else if(courseRecordDao.isOverEndTime(timeSheet.getClassId(),timeSheet.getRecordTime())) {
			return "超出课程结课时间";
		}
		else {
			
			timeSheetDao.insert(timeSheet);
			return "提交成功";
		}
	}
	
	
	@Override
	public List<User> queryUserListByClassid(Integer engclassId,PageContainer pageContainer) {
		UserDao userDao = new UserDaoImpl();
		EngclassDao engclassDao = new EngclassDaoImpl();
		
		if(pageContainer != null) {
			pageContainer.setPageSize(5);
			pageContainer.setRecordCount(engclassDao.countAllUserByEngclassId(engclassId));
			userDao.beginPaging(pageContainer);
		}
		
		return userDao.selectUserByEngclassId(engclassId);
	}

	@Override
	public List<TimeSheetDetail> queryUserTimeSheetByEngclassId(Integer engclassId,Date date){
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		List<TimeSheetDetail> timeSheetDetailList = timeSheetDao.selectTimeSheetByClassIdAndTime(engclassId, date);
		return timeSheetDetailList;
	}

	@Override
	public Boolean loginCheck(Account account) {
		AccountDao accountDao = new AccountDaoImpl();
		if(accountDao.countAccount(account.getId()) != 1) {
			return false;
		}
		Account dbAccount = accountDao.selectAccount(account.getId());
		if(!dbAccount.getPassword().equals(account.getPassword())) {
			return false;
		}
		
		account.setRoleId(dbAccount.getRoleId());
		account.setRole(dbAccount.getRole());
		
		return true;
	}

	@Override
	public User queryUserByAccountId(Integer accountId) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.selectUserByAccountId(accountId);
		
		
		return user;
	}
}

