package com.eco.dao.impl;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.dao.CourseRecordDao;

public class CourseRecordDaoImpl extends AbstractBaseDao<CourseRecord> implements CourseRecordDao {

	@Override
	public Integer insert(CourseRecord record) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> selectNowCoureseRecordByCourseId(Integer courseid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean updateCourseRecordSignCount(Integer crId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isOverEndTime(Integer classId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
