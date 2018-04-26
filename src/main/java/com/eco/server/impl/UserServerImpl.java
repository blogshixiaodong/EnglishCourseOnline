package com.eco.server.impl;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;

import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserClass;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.TimeSheetDao;
import com.eco.dao.UserClassDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.TimeSheetDaoImpl;
import com.eco.dao.impl.UserClassDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.UserServer;

public class UserServerImpl implements UserServer{

	@Override
	public boolean enrolmentClass(UserClass uc, Integer crId) {
		//UserDao userDao = new UserDaoImpl();
		UserClassDao ucDao = new UserClassDaoImpl();
		CourseRecordDao rcDao = new CourseRecordDaoImpl();
		
		//1.添加一条用户班级表记录
		ucDao.createUserClass(uc);
		
		//2.修改课程记录表中报名人数
		rcDao.updateSignCount(crId);
		
		return true;
	}

	@Override
	public List<CourseDetail> queryNowCourseDetail(Integer userid) {
		
		CourseDao cdDao = new CourseDaoImpl();
		
		return cdDao.getUserNowCourseDetailList(userid);

	}

	@Override
	public List<CourseDetail> queryAllCourseDetail(Integer userid) {
		CourseDao cdDao = new CourseDaoImpl();
		
		return cdDao.getUserAllCourseDetailList(userid);
	}

	@Override
	public List<CourseDetail> queryHistoryCourseDetail(Integer userid) {
		CourseDao cdDao = new CourseDaoImpl();
		
		return cdDao.getUserHistoryCourseDetailList(userid);
	}

	@Override
	public List<EngclassDetail> queryAllEngclassDetail(Integer userid) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		
		return engclassDao.queryUserAllEngclassList(userid);
	}
	
	

	@Override
	public List<BackInfoDetail> queryTeacherBackInfo(Integer classid, Integer userid) {
		
		TeacherBackInfoDao tbiDao = new TeacherBackInfoDaoImpl();
		return tbiDao.queryBackInfoByUserClass(classid, userid);

	}

	@Override
	public List<TimeSheetDetail> queryTimeSheetDetailByUser(Integer userId, Integer engclassId,String queryDate) {
		List<TimeSheetDetail> timeSheetDetailList = null;
		TimeSheetDao tsDao = new TimeSheetDaoImpl();
		if("".equals(queryDate)) {
			//按classid查出该用户在该班级的所有考勤记录
			timeSheetDetailList = tsDao.getTimeSheetByUser(userId, engclassId);
		}else {
			
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date formateDate = stringFormateToDate(queryDate);
			/*try {
				formateDate = sdf.parse(queryDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}*/
			
			timeSheetDetailList = tsDao.getTimeSheetByUserAndTime(userId, engclassId, formateDate);
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
	public String createTimeSheet(Integer userId,Integer classId,String queryDate,String leaveInfo) {
		TimeSheetDao tsDao = new TimeSheetDaoImpl();
		CourseRecordDao crDao = new CourseRecordDaoImpl();
		
		Date formateDate = stringFormateToDate(queryDate);
		
		if((tsDao.queryUserTimeSheetByClassIdAndTime(classId, formateDate)).size() != 0 ) {
			return "不允许重复对当天请假";
		}else if(crDao.isOverEndTime(classId,formateDate)) {
			return "超出课程结课时间";
		}
		else {
			TimeSheet timeSheet = new TimeSheet();
			
			timeSheet.setUserId(userId);
			timeSheet.setClassId(classId);
			timeSheet.setRecordTime(formateDate);
			timeSheet.setSheetInfo("0:"+leaveInfo);
			
			tsDao.createTimeSheet(timeSheet);
			return "提交成功";
		}
	}

	@Override
	public List<User> queryUserListByClassid(Integer classid) {
		UserDao userDao = new UserDaoImpl();
		return userDao.queryAllUserByClassid(classid);
	}

	@Override
	public List<TimeSheetDetail> queryUserTimeSheetDetailByClassId(Integer classId, Date date) {
		TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
		List<TimeSheetDetail> timeSheetDetailList = timeSheetDao.queryUserTimeSheetByClassIdAndTime(classId, date);
		
		return timeSheetDetailList;
	}

	

	

	
	
	
	
	
	
	
	
	
	
}
