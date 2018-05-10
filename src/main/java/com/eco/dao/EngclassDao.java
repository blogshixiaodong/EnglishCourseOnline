package com.eco.dao;

import java.util.List;

import com.eco.bean.model.Engclass;


/*
 * date:   2018年4月20日 下午10:31:04
 * author: Shixiaodong
 */
/**
 * @author 15129
 *
 */
public interface EngclassDao {

	/**
	 * 根据教师id获取教师正在进行授课的班级
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectTeacherNowEngclassListByTeacherId(Integer teacherId);

	/**
	 * 根据教师id获取教师已完成授课的班级
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectTeacherHistoryEngclassListByTeacherId(Integer teacherId);

	/**
	 * 根据教师id获取教师所有授课的班级
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectTeacherAllEngclassListByTeacherId(Integer teacherId);
	
}
