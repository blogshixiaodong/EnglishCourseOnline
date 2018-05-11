package com.eco.dao;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.TimeSheet;

/*
 * date:   2018年4月20日 下午11:07:27
 * author: Shixiaodong
 */
public interface TimeSheetDao {
	
	/**
	 * 根据班级编号，日期查询学生的考勤信息
	 * @param engclassId
	 * @param date
	 * @return
	 */
	List<TimeSheet> selectTimeSheetByEnglassIdAndDate(Integer engclassId, Date date);

	/**
	 * 批量插入学生考勤信息
	 * @param timeSheetList
	 */
	void insertUserTimeSheet(List<TimeSheet> timeSheetList);

}
