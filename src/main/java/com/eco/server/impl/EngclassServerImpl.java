package com.eco.server.impl;

import java.util.List;

import com.eco.bean.model.User;
import com.eco.dao.UserDao;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.EngclassServer;

/*
 * date:   2018年4月24日 上午10:17:12
 * author: Shixiaodong
 */
public class EngclassServerImpl implements EngclassServer {

	private UserDao userDao = new UserDaoImpl();
	
	@Override
	public List<User> queryUserListByEngclassId(Integer engclassId){
		//return userDao.getUserListByEngclassId(classId);
		return userDao.selectUserByEngclassId(engclassId);
	}
	
	

}
