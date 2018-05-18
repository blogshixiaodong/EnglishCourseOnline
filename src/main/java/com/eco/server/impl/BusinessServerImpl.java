package com.eco.server.impl;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherDaoImpl;
import com.eco.server.BusinessServer;

public class BusinessServerImpl implements BusinessServer {
	
	private CourseDao courseDao = new CourseDaoImpl();
	
	private CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
	
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
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
	public List<Engclass> queryAllEngclassIdAndNameList() {
		return engclassDao.selectAllEngclassIdAndNameList();
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
	public Engclass queryEngclassByEngclasId(Integer engclassId) {
		return engclassDao.selectEngclassByEngclassId(engclassId);
	}

	@Override
	public void saveEngclass(Engclass engclass) {
		//先保存课程记录
		Integer courseRecordId = courseRecordDao.insert(engclass.getCourseRecord());
		engclass.getCourseRecord().setCourseRecordId(courseRecordId);
		engclassDao.insertEngclass(engclass);
	}
	
	@Override
	public void saveSplitEngclass(Engclass engclass) {
		engclassDao.insertEngclass(engclass);
	}
	
	
}
