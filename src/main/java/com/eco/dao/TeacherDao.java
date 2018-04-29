package com.eco.dao;

import com.eco.bean.model.Teacher;

/*
 * date:   2018年4月19日 上午9:45:03
 * author: Shixiaodong
 */
public interface TeacherDao extends BaseDao<Teacher> {
	
	/**
	 * 添加教师记录
	 * @param teacher
	 * @return
	 */
	public abstract int insert(Teacher teacher);
	
}
