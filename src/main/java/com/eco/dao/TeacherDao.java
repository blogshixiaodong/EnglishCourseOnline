package com.eco.dao;

import java.util.List;

import com.eco.bean.model.Teacher;

/*
 * date:   2018年4月19日 上午9:45:03
 * author: Shixiaodong
 */
public interface TeacherDao {
	
	/**
	 * 查询所有教师的id/name列表
	 * @return
	 */
	List<Teacher> selectAllTeacherIdAndNameList();
	
	/**
	 * 根据教师编号查询教师信息
	 * @param teacherId
	 * @return
	 */
	Teacher selectTeacherByTeacherId(Integer teacherId);

}
