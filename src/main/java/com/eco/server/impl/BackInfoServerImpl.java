package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.UserBackInfoDao;
import com.eco.dao.impl.TeacherBackInfoDaoImpl;
import com.eco.dao.impl.UserBackInfoDaoImpl;
import com.eco.server.BackInfoServer;

/*
 * date:   2018年4月24日 上午11:24:07
 * author: Shixiaodong
 */
public class BackInfoServerImpl implements BackInfoServer {
	
	private TeacherBackInfoDao teacherBackInfoDao = new TeacherBackInfoDaoImpl();
	private UserBackInfoDao userBackInfoDao = new UserBackInfoDaoImpl();
	
	
	public List<BackInfoDetail> getBackInfoByTeacherIdAndClassId(Integer teacherId, Integer engclassId) {
		return teacherBackInfoDao.getBackInfoByTeacherIdAndClassId(teacherId, engclassId);
	}


	@Override
	public List<BackInfoDetail> getBackInfoByUserIdAndClassId(Integer userId, Integer engclassId) {
		return userBackInfoDao.getBackInfoByUserIdAndClassId(userId, engclassId);
	}
}
