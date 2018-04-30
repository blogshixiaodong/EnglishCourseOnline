package com.eco.dao;

import com.eco.bean.model.Engclass;

public interface AccountDao {
	
	
	/** 
	* @Description: 登录时判断账号密码是否正确
	* @param id
	* @return boolean
	*/ 
	public abstract boolean checkLoginAccount(Integer id,String password);
	
}
