package com.eco.dao.impl;

import com.eco.bean.User;
import com.eco.dao.IUserDao;

public class UserDao extends AbstractBaseDao<User> implements IUserDao {

	@Override
	public User queryUserById(int userid) {
		String sql = "SELECT * FROM user WHERE userid = ?";
		
		return null;
	}

	
	
	
	
}
