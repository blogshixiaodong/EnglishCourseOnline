package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.TeacherBackInfo;
import com.eco.dao.TeacherBackInfoDao;

public class TeacherBackInfoDaoImpl extends AbstractBaseDao<TeacherBackInfo> implements TeacherBackInfoDao {

	@Override
	public List<TeacherBackInfo> selectTeacherBackInfoByTeacherIdAndEngclassId(Integer teacherId, Integer engclassId) {
		String hql = " SELECT tbi FROM UserBackInfo tbi WHERE tbi.teacher.teacherId = ? AND tbi.engclass.engclassId = ?";
		return this.list(hql, teacherId, engclassId);
	}

	@Override
	public void insertTeacherBackInfo(List<TeacherBackInfo> teacherBackInfoList) {
		this.save(teacherBackInfoList);
	}
}
