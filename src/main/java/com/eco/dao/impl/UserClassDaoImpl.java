package com.eco.dao.impl;

import com.eco.bean.model.UserClass;
import com.eco.dao.UserClassDao;

public class UserClassDaoImpl extends AbstractBaseDao<UserClass> implements UserClassDao{

	@Override
	public int insert(UserClass userClass){
		String sql = "INSERT INTO user_class VALUES(?,?,?)";
		int num = this.update(sql, userClass.getUserId(),userClass.getClassId(),userClass.getIsAssigned());
		return num;
	}

}
