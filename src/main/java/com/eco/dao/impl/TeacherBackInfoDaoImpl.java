package com.eco.dao.impl;

import java.util.List;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.dao.TeacherBackInfoDao;

public class TeacherBackInfoDaoImpl extends AbstractBaseDao<TeacherBackInfo> implements TeacherBackInfoDao {

	@Override
	public List<TeacherBackInfo> selectTeacherBackInfoByEngclassId(Integer userId,Integer engclassId) {
		String hql = "SELECT tbi FROM User u LEFT JOIN u.engclassSet ec LEFT JOIN ec.teacherBackInfoSet tbi WHERE u.userId = ? AND ec.engclassId = ?";
		return this.list(hql, userId,engclassId);
	}

	

}
