package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.CourseRecord;

public interface CourseRecordDao {
	
	/** 
	* 创建课程记录 
	* @param record
	* @return boolean
	*/ 
	public abstract boolean  insert(CourseRecord record);
	
	/** 
	* 获取真正等待报名的课程记录 
	* @param courseid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> selectNowCoureseRecordByCourseId(Integer courseid);
	
	/** 
	* 报名成功，修改报名人数字段
	* @param crId
	* @return boolean
	*/ 
	public abstract boolean updateCourseRecordSignCount(Integer crId);
	
}
