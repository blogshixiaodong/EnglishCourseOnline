package com.eco.dao;

import java.util.Date;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.PageContainer;

public interface CourseRecordDao extends PageDao<CourseRecord> {
	
	/** 
	* 创建课程记录 
	* @param record
	* @return boolean
	*/ 
	Integer insert(CourseRecord record);
	
	/** 
	* 获取真正等待报名的课程记录 
	* @return List<CourseDetail>
	*/ 
	PageContainer<CourseRecord> selectNowCoureseRecord();
	
	/** 
	* 报名成功，修改报名人数字段
	* @param crId
	* @return boolean
	*/ 
	void updateCourseRecordSignCount(Integer courseRecordId,Integer count);
	
	
	/** 
	* @Description: 查看 date 是否超出某班级的结课时间
	* @param classId
	* @param date
	* @return boolean
	*/ 
	Boolean isOverEndTime(Integer classId,Date date);
	
	/** 
	* @Description: 根据班级记录号  查询该课程记录
	* @param courseRecordId
	* @return CourseRecord
	*/ 
	CourseRecord selectCourseRecordByCourseRecordId(Integer engclassId); 

	
	
	
}
