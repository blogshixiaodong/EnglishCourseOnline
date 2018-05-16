package com.eco.dao.impl;

import java.util.Date;

import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseRecordDao;

public class CourseRecordDaoImpl extends AbstractBaseDao<CourseRecord> implements CourseRecordDao {
	
	private PageContainer<CourseRecord> pageContainer;
	
	@Override
	public Integer insert(CourseRecord record) {
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

	@Override
	public PageContainer<CourseRecord> selectNowCoureseRecord() {
		Integer userId = 40000;
		String hql = " SELECT cr FROM CourseRecord cr LEFT JOIN cr.engclassSet e LEFT JOIN e.userSet us WHERE us.userId <> ? AND NOW() between cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer,userId);
	}

	@Override
	public PageContainer<CourseRecord> getPageContainer() {
		return pageContainer;
	}

	@Override
	public void setPageContainer(PageContainer<CourseRecord> pageContainer) {
		this.pageContainer = pageContainer;
	}
	
}
