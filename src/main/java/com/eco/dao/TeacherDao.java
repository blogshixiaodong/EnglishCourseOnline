package com.eco.dao;

import com.eco.bean.model.Account;
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
	public abstract int insert(Teacher teacher);
	
	/**
	 * 根据id查询账号记录数
	 * @param 账号id
	 * @return
	 */
	public abstract int countAccount(Integer id);
	
	/**
	 * 根据id查询账号记录
	 * @param 账号id
	 * @return
	 */
	public abstract Account selectAccount(Integer id);
	
}
