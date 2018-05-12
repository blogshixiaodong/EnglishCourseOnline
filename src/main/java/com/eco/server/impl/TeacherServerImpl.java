package com.eco.server.impl;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
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
	public PageContainer<Course> queryNowCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer) {
		courseDao.setPageContainer(pageContainer);
		return courseDao.selectTeacherNowCourseListByTeacherId(teacherId);
	}

	@Override
	public PageContainer<Course> queryHistoryCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageContainer<Course> queryAllCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Engclass> queryNowEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Engclass> queryHistoryEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Engclass> queryAllEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainer) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
