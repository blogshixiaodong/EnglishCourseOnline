package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.dao.CourseDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.server.TeacherServer;

/*
 * date:   2018年4月21日 上午11:06:01
 * author: Shixiaodong
 */
public class TeacherServerImpl implements TeacherServer {

	private CourseDao courseDao = new CourseDaoImpl();
	
	
	@Override
	public List<CourseDetail> getNowCourseDetailList(Integer teacherId) {
		return courseDao.getNowCourseDetailList(teacherId);
	}

	@Override
	public List<CourseDetail> getHistoryCourseDetailList(Integer teacherId) {
		return courseDao.getHistoryCourseDetailList(teacherId);
	}

	@Override
	public List<CourseDetail> getAllCourseDetailList(Integer teacherId) {
		return courseDao.getAllCourseDetailList(teacherId);
	}
	
	
	
}
