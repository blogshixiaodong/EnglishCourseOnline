package com.eco.server.impl;

import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.server.BusinessServer;

public class BusinessServerImpl implements BusinessServer {
	
	private CourseDao courseDao = new CourseDaoImpl();
	
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
	
	
	
}
