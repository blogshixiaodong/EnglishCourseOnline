package com.eco.server.impl;

import java.util.Date;
import java.util.List;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.UserBackInfo;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherBackInfoDao;
import com.eco.dao.UserBackInfoDao;
import com.eco.dao.impl.EngclassDaoImpl;
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
	
	
  @Override
	public List<BackInfoDetail> queryBackInfoByTeacherIdAndClassId(Integer teacherId, Integer engclassId) {
		return teacherBackInfoDao.selectBackInfoDetailByEngclassIdAndTeacherId(teacherId, engclassId);
	}
	

	@Override
	public List<BackInfoDetail> queryBackInfoByUserIdAndClassId(Integer userId, Integer engclassId) {
		//return userBackInfoDao.getBackInfoByUserIdAndClassId(userId, engclassId);
		return userBackInfoDao.selectBackInfoByUserIdAndClassId(userId, engclassId);
	}

	public int insertTeacherBackInfo(Integer teacherId, Integer engclassId, Integer[] userIdList, String backInfo) {
		TeacherBackInfo teacherBackInfo = new TeacherBackInfo();
		teacherBackInfo.setTeacherId(teacherId);
		teacherBackInfo.setBackTime(new Date());
		teacherBackInfo.setClassId(engclassId);
		teacherBackInfo.setBackInfo(backInfo);
		if(userIdList.length == 1 && userIdList[0] == -1) {
			//全体对象
			teacherBackInfo.setUserId(null);
			return teacherBackInfoDao.insert(teacherBackInfo) ? 1 : 0;
		} else {
			int updateCount = 0;
			for(int i = 0; i < userIdList.length; i++) {
				teacherBackInfo.setUserId(userIdList[i]);
				boolean status = teacherBackInfoDao.insert(teacherBackInfo);
				if(status) {
					updateCount++;
				}
			}
			return updateCount;
		}
	}

	@Override
	public List<BackInfoDetail> queryUserBackInfobyClassId(Integer engclassId) {
		//return userBackInfoDao.queryAllUserBackInfoByEngclass(engclassId);
		return userBackInfoDao.selectBackInfoByEngclassId(engclassId);
	}

	@Override
	public int addUserBackInfo( Integer classId, Integer userId, String backInfo) {
		EngclassDao engclassDao = new EngclassDaoImpl();
		
		Integer teacherId = engclassDao.selectTeacherIdByEngclassId(classId);

		UserBackInfo userBackInfo = new UserBackInfo();
		userBackInfo.setTeacherId(teacherId);
		userBackInfo.setUserId(userId);
		userBackInfo.setClassId(classId);
		userBackInfo.setBackTime(new Date());
		userBackInfo.setBackInfo(backInfo);
		
		UserBackInfoDao userBackInfoDao = new UserBackInfoDaoImpl();
		if(userBackInfoDao.createUserBackInfo(userBackInfo)) {
			return 1;
		}
		return 0;
	}
}
