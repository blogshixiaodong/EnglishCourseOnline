package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.User;
import com.eco.dao.EngclassDao;
import com.eco.dao.UserDao;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.UserDaoImpl;
import com.eco.server.EngclassServer;

/*
 * date:   2018年4月24日 上午10:17:12
 * author: Shixiaodong
 */
public class EngclassServerImpl implements EngclassServer {

	private UserDao userDao = new UserDaoImpl();
	
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
	@Override
	public List<User> queryUserListByEngclassId(Integer engclassId){
		return userDao.selectUserByEngclassId(engclassId);
	}

	@Override
	public List<Engclass> queryEnglclassListByCourseId(Integer courseId) {
		return engclassDao.selectEngclassListByCourseId(courseId);
	}

	@Override
	public EngclassDetail queryEngclassDetailByEngclasId(Integer engclassId) {
		return engclassDao.selectEngclassDetailByEngclassId(engclassId);
	}

	
}
