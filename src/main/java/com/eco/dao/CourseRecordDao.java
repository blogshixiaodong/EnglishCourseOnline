package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.CourseRecord;



public interface CourseRecordDao {
	
	/** 
	* @Description:创建课程记录 
	* @param record
	* @return boolean
	*/ 
	public abstract boolean  createCourseRecord(CourseRecord record);
	
	
	/** 
	* @Description: 获取真正等待报名的课程记录 
	* @param courseid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryNowCoureseRecord(Integer courseid);
	
	
	/** 
	* @Description:报名成功，修改报名人数字段
	* @param crId
	* @return boolean
	*/ 
	public abstract boolean updateSignCount(Integer crId);
	
}
