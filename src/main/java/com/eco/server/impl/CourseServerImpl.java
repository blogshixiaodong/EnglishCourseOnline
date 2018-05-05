package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;
import com.eco.dao.CourseDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.server.CourseServer;

/*
 * date:   2018年5月5日 下午4:46:26
 * author: Shixiaodong
 */
public class CourseServerImpl implements CourseServer {

	private CourseDao courseDao = new CourseDaoImpl();
	
	@Override
	public List<Course> queryAllCourse() {
		return courseDao.selectAllCourse();
	}

	@Override
	public Course queryCourseByCourseId(Integer courseId) {
		return courseDao.selectCourseByCourseId(courseId);
	}

	@Override
	public List<CourseDetail> queryEnrollCourseList() {
		return courseDao.selectEnrollCourseList();
	}
	
}
