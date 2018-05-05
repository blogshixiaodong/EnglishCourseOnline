package com.eco.dao;

import java.util.List;

import com.eco.bean.model.Teacher;

/*
 * date:   2018年4月19日 上午9:45:03
 * author: Shixiaodong
 */
public interface TeacherDao {
	
	/**
	 * 添加教师记录
	 * @param teacher
	 * @return
	 */
	public abstract Long insert(Teacher teacher);
	
	/**
	 * 根据id查询教师信息
	 * @param 账号id
	 * @return
	 */
	public abstract Teacher selectTeacher(Integer id);
	
	
	public abstract List<Teacher> selectAllTeaher();
	
}
