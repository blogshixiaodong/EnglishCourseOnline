package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseDao;
import com.eco.dao.CourseRecordDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.CourseRecordDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
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

	@Override
	public boolean setUpEngclass(Engclass engclass, CourseRecord courseRecord) {
		
		CourseRecordDao courseRecordDao = new CourseRecordDaoImpl();
		//int courseRecordId = courseRecordDao.insert(courseRecord);
		int courseRecordId = new Long(courseRecordDao.insert(courseRecord)).intValue();
		//int courseRecordId = Integer.parseInt(String.valueOf(courseRecordDao.insert(courseRecord)));
		if(courseRecord == null) {
			return false;
		}
		
		engclass.setCourseRecordId(courseRecordId);
		engclass.setUserCount(courseRecord.getSignCount());
		
		EngclassDao engclassDao = new EngclassDaoImpl();
		engclassDao.insert(engclass);
		
		return true;
	}
	
	
}
