package com.eco.dao;

import java.util.Date;
import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.CourseRecord;

public interface CourseRecordDao {
	
	/** 
	* 创建课程记录 
	* @param record
	* @return boolean
	*/ 
	public abstract long insert(CourseRecord record);
	
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
	
	
	/** 
	* @Description: 查看 date 是否超出某班级的结课时间
	* @param classId
	* @param date
	* @return boolean
	*/ 
	public abstract boolean isOverEndTime(Integer classId,Date date);

	
	
	
}
