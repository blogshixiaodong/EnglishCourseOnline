package com.eco.dao;


import com.eco.bean.model.UserAccount;

public interface UserAccountDao {
	
	/**
	 * 根据id查询账号记录数
	 * @param 账号id
	 * @return
	 */
	Integer countAccount(Integer id);
	
	/**
	 * 根据id查询账号记录
	 * @param 账号id
	 * @return
	 */
	UserAccount selectAccount(Integer id);
	
}
