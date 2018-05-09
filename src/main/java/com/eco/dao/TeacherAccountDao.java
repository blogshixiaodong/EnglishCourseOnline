package com.eco.dao;

import com.eco.bean.model.TeacherAccount;

public interface TeacherAccountDao {
	
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
	public abstract TeacherAccount selectAccount(Integer id);
	
}
