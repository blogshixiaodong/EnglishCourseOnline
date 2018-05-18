package com.eco.dao.impl;

import java.util.Date;

import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseRecordDao;

public class CourseRecordDaoImpl extends AbstractBaseDao<CourseRecord> implements CourseRecordDao {
	
	private PageContainer<CourseRecord> pageContainer;
	
	@Override
	public Integer insert(CourseRecord record) {
		return Integer.parseInt(this.save(record).toString());
	}

	@Override
	public void updateCourseRecordSignCount(Integer courseRecordId, Integer count) {
		String hql = "UPDATE CourseRecord cr SET cr.signCount += ?  WHERE cr.courseRecordId = ?";
		this.executeHQLUpdate(hql, count,courseRecordId);
	}

	@Override
	public Boolean isOverEndTime(Integer classId, Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageContainer<CourseRecord> selectNowCoureseRecord() {
		Integer userId = 40000;
		String hql = " SELECT DISTINCT(cr) FROM CourseRecord cr LEFT JOIN cr.engclassSet e LEFT JOIN e.userSet us WHERE us.userId <> ? AND NOW() < cr.closeTime AND cr.signCount <> 0 ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer,userId);
	}
	
	@Override
	public CourseRecord selectCourseRecordByCourseRecordId(Integer engclassId) {
		String hql = "SELECT DISTINCT(cr) FROM CourseRecord cr LEFT JOIN cr.engclassSet e WHERE e.engclassId = ?";
		return this.get(hql,engclassId);
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
