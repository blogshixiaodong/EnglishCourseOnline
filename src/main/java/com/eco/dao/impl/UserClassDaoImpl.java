package com.eco.dao.impl;

import com.eco.bean.model.UserClass;
import com.eco.dao.UserClassDao;

public class UserClassDaoImpl extends AbstractBaseDao<UserClass> implements UserClassDao{

	@Override
	public boolean createUserClass(UserClass uc) {
		String sql = "INSERT INTO user_class VALUES(?,?,?)";
		int num = this.update(sql, uc.getUserId(),uc.getClassId(),uc.getIsAssigned());
		return num == 1;
	}

}
