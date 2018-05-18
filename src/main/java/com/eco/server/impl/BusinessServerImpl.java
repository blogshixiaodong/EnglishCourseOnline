package com.eco.server.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.bean.model.User;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.BusinessServer;

public class BusinessServerImpl implements BusinessServer {
	
	private CourseDao courseDao = new CourseDaoImpl();
	
	private CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
	
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public PageContainer<Course> queryNowCourseList(PageContainer<Course> pageContainer) {
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectNowCourseList();
	}

	@Override
	public PageContainer<Course> queryAllCourseList(PageContainer<Course> pageContainer) {
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectAllCourseList();
	}

	@Override
	public void saveCourse(Course course) {
		courseDao.insertCourse(course);
	}

	@Override
	public List<Course> queryNowCourseIdAndNameList() {
		return courseDao.selectNowCourseIdAndNameList();
	}
	
	@Override
	public List<Teacher> queryAllTeacherIdAndNameList() {
		return teacherDao.selectAllTeacherIdAndNameList();
	}

	@Override
	public Course queryCourseByCourseId(Integer courseId) {
		return courseDao.selectCourseByCourseId(courseId);
	}

	@Override
	public Teacher queryTeacherByTeacherId(Integer teacherId) {
		return teacherDao.selectTeacherByTeacherId(teacherId);
	}
	
	@Override
	public void saveEngclass(Engclass engclass) {
		//先保存课程记录
		Integer courseRecordId = courseRecordDao.insert(engclass.getCourseRecord());
		engclass.getCourseRecord().setCourseRecordId(courseRecordId);
		engclassDao.insertEngclass(engclass);
	}

	@Override
	public List<Engclass> queryNowEngclassIdAndNameList(Integer courseId) {
		return engclassDao.selectNowEngclassIdAndNameByCourseId(courseId);
	}

	@Override
	public Engclass queryEngclassByEngclassId(Integer engclassId) {
		return engclassDao.selectEngclassByEngclassId(engclassId);
	}

	@Override
	public String mergeEngclass(Engclass engclass, Integer oldEngclassId1, Integer oldEngclassId2) {
		CourseRecord courseRecord = courseRecordDao.selectCourseRecordByCourseRecordId(oldEngclassId1);
		//elgclass表中插入一条数据
		engclass.setCourseRecord(courseRecord);
		engclassDao.insertEngclass(engclass);
		//旧班级  userCount = -1
		engclassDao.updateEngclassUserCount(oldEngclassId1);
		engclassDao.updateEngclassUserCount(oldEngclassId2);
		//1. 旧班级学生 转到新班级
		List<User> userList = userDao.selectUserIdAndUsernameByEngclassId(oldEngclassId1);
		Set<User> resultSet = new HashSet<User>(userList); 
		userList = userDao.selectUserIdAndUsernameByEngclassId(oldEngclassId2);
		resultSet.addAll(userList);
		engclass.getUserSet().addAll(resultSet);
		engclassDao.updateEngclass(engclass);
		return null;
	}
	
	
}
