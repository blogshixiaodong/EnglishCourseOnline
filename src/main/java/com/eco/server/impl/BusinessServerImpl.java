package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.server.BusinessServer;

public class BusinessServerImpl implements BusinessServer {

	@Override
	public boolean addCourse(Course course) {
		
		CourseDao courseDao = new CourseDaoImpl();
		if( courseDao.insertCourse(course) == 1) {
			return true;
		}
		
		return false;
	}

	@Override
	public List<Course> queryqueryAllCourseList(PageContainer pageContainer) {
CourseDao courseDao = new CourseDaoImpl();
		
		pageContainer.setPageSize(5);
		pageContainer.setRecordCount(courseDao.countAllCourse());
		courseDao.beginPaging(pageContainer);
		
		return courseDao.selectAllCourseList();
	}
	
	
}
