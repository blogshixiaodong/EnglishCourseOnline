package com.eco.server.impl;

import java.util.ArrayList;
import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.bean.model.TeacherAccount;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.dao.CourseDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherAccountDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.TimeSheetDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherAccountDaoImpl;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.TimeSheetDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.TeacherServer;

/*
 * date:   2018年4月21日 上午11:06:01
 * author: Shixiaodong
 */
public class TeacherServerImpl implements TeacherServer {

	private TeacherAccountDao teacherAccountDao = new TeacherAccountDaoImpl();
	
	private UserDao userDao = new UserDaoImpl();
	
	private CourseDao courseDao = new CourseDaoImpl();
	
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
	private TimeSheetDao timeSheetDao = new TimeSheetDaoImpl();
	
	private TeacherBackInfoDao teacherBackInfoDao = new TeacherBackInfoDaoImpl();
	
	@Override
	public PageContainer<Course> queryNowCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer) {
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectTeacherNowCourseListByTeacherId(teacherId);
	}

	@Override
	public PageContainer<Course> queryHistoryCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer) {
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectTeacherHistoryCourseListByTeacherId(teacherId);
	}

	@Override
	public PageContainer<Course> queryAllCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer) {
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectTeacherAllCourseListByTeacherId(teacherId);
	}

	@Override
	public PageContainer<Engclass> queryAllEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainer) {
		engclassDao.setPageContainer(pageContainer);
		return engclassDao.selectTeacherAllEngclassListByTeacherId(teacherId);
	}
	
	@Override
	public List<Engclass> searchEngclassByEngclassIdAndEngclassName(Integer teacherId, Integer engclassId, String engclassName) {
		if(engclassId != null) {
			List<Engclass> engclassList = new ArrayList<>();
			engclassList.add(engclassDao.selectEngclassByEngclassId(teacherId, engclassId));
			return engclassList;
		}
		return engclassDao.selectEngclassListByEngclassName(teacherId, engclassName);
	}

	@Override
	public List<Engclass> queryEngclassIdAndEngclassNameByTeacherId(Integer teacherId) {
		return engclassDao.selectEngclassIdAndEngclassNameByTeacherId(teacherId);
	}

	@Override
	public void saveUserTimeSheet(List<TimeSheet> timeSheetList) {
		timeSheetDao.insertUserTimeSheet(timeSheetList);
	}

	@Override
	public PageContainer<TeacherBackInfo> queryTeacherBackInfoByTeacherIdAndEngclassId(Integer teacherId, Integer engclassId, PageContainer<TeacherBackInfo> pageContainer) {
		teacherBackInfoDao.setPageContainer(pageContainer);
		return teacherBackInfoDao.selectTeacherBackInfoByTeacherIdAndEngclassId(teacherId, engclassId);
	}

	@Override
	public List<User> queryUserIdAndUsernameByEngclassId(Integer engclassId) {
		return userDao.selectUserIdAndUsernameByEngclassId(engclassId);
	}

	@Override
	public void saveTeacherBackInfo(List<TeacherBackInfo> teacherBackInfoList) {
		teacherBackInfoDao.insertTeacherBackInfo(teacherBackInfoList);
	}

	@Override
	public Boolean loginCheck(TeacherAccount teacherAccount) {
		int count = teacherAccountDao.countAccount(teacherAccount.getId());
		if(count != 1) {
			return false;
		}
		TeacherAccount teacherAccountEx = teacherAccountDao.selectAccount(teacherAccount.getId());
		if(teacherAccountEx.getPassword().equals(teacherAccount.getPassword())) {
			return true;
		}
		return false;
	}

	@Override
	public Teacher queryTeacherrByAccountId(Integer accountId) {
		return teacherAccountDao.selectAccount(accountId).getTeacher();
	}
	
	
	
}
