package com.eco.server.impl;

import java.util.ArrayList;
import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.server.TeacherServer;

/*
 * date:   2018年4月21日 上午11:06:01
 * author: Shixiaodong
 */
public class TeacherServerImpl implements TeacherServer {

	private CourseDao courseDao = new CourseDaoImpl();
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
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
	public List<Engclass> selectEngclassIdAndEngclassNameByTeacherId(Integer teacherId) {
		return engclassDao.selectEngclassIdAndEngclassNameByTeacherId(teacherId);
	}
	
}
