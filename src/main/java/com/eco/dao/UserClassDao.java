package com.eco.dao;

import com.eco.bean.model.UserClass;

public interface UserClassDao {
	
	
	/** 
	* @Description: 创建 用户班级 记录 
	* @param uc
	* @return boolean
	*/ 
	public abstract int insert(UserClass userClass);
	
}
