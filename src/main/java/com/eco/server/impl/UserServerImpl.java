package com.eco.server.impl;

import static org.junit.Assert.assertNotNull;

import java.sql.Time;
import java.util.List;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserBackInfo;
import com.eco.bean.model.UserClass;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.TimeSheetDao;
import com.eco.dao.UserBackInfoDao;
import com.eco.dao.UserClassDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.TimeSheetDaoImpl;
import com.eco.dao.impl.UserBackInfoDaoImpl;
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
	public void createUserBackInfo(UserBackInfo backInfo) {
		UserBackInfoDao ubiDao = new UserBackInfoDaoImpl();
		
		ubiDao.createUserBackInfo(backInfo);
		
		
	}
	

	@Override
	public List<BackInfoDetail> queryTeacherBackInfo(Integer classid, Integer userid) {
		//String sql = "SELECT * FROM teacher_back_info WHERE classid = ? AND userid = ? ";
		//UserClass userClass = new UserClass();
		
		TeacherBackInfoDao tbiDao = new TeacherBackInfoDaoImpl();
		return tbiDao.queryBackInfoByUserClass(classid, userid);

	}

	@Override
	public List<TimeSheetDetail> queryTimeSheetDetailByUser(Integer userid, Integer engclassid,String engclassName) {
		List<TimeSheetDetail> timeSheetDetailList = null;
		TimeSheetDao tsDao = new TimeSheetDaoImpl();
		/*if(engclassid == null) {
			if(engclassName == null || "".equals(engclassName)) {
				return null;
			}else {
				//timeSheetDetailList = tsDao.getTimeSheetByUser(userid, );
			}
		}*/
			
		return tsDao.getTimeSheetByUser(userid, engclassid);
		
	}

	
	@Override
	public boolean createTimeSheet(TimeSheet timeSheet) {
		TimeSheetDao tsDao = new TimeSheetDaoImpl();
		tsDao.createTimeSheet(timeSheet);
		return true;
	}

	@Override
	public List<User> queryUserListByClassid(Integer classid) {
		UserDao userDao = new UserDaoImpl();
		return userDao.queryAllUserByClassid(classid);
	}

	

	
	
	
	
	
	
	
	
	
	
}
