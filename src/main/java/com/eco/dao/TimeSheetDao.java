package com.eco.dao;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;

/*
 * date:   2018年4月20日 下午11:07:27
 * author: Shixiaodong
 */
public interface TimeSheetDao extends PageDao<TimeSheet> {

	/**
	 * 根据班级编号，日期查询学生的考勤信息
	 * @param engclassId
	 * @param date
	 * @param pageContainer
	 * @return
	 */
	PageContainer<TimeSheet> selectTimeSheetByEnglassIdAndDate(Integer engclassId, Date date);

	/**
	 * 批量插入学生考勤信息
	 * @param timeSheetList
	 */
	void insertUserTimeSheet(List<TimeSheet> timeSheetList);
	
	/** 
	* @Description: 查询某个班级的所有考勤信息
	* @param userId
	* @param engclassId
	* @return List<TimeSheet>
	*/ 
	PageContainer<TimeSheet> selectTimeSheetByUserIdAndEngclassId(Integer userId, Integer engclassId);
	
	/** 
	* @Description: 查询某个班级某天的考勤信息
	* @param userId
	* @param engclassId
	* @param queryDate
	* @return List<TimeSheet>
	*/ 
	PageContainer<TimeSheet> selectTimeSheetByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate); 
	
	/** 
	* @Description: 判断用户在这个班级的这一天有没有课程，没有请假失败
	* @param userId
	* @param engclassId
	* @param queryDate
	* @return Integer
	*/ 
	Integer countCourseByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate);
	
	/** 
	* @Description: 是否存在重复请假问题 
	* @param userId
	* @param engclassId
	* @param queryDate
	* @return Integer
	*/ 
	Integer countTimeSheetByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate);

	/** 
	* @Description: 添加请假记录 
	* @param timeSheet void
	*/ 
	void insertTimeSheet(TimeSheet timeSheet);
}
