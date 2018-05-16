package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.dao.TeacherBackInfoDao;

public class TeacherBackInfoDaoImpl extends AbstractBaseDao<TeacherBackInfo> implements TeacherBackInfoDao {
	
	private PageContainer<TeacherBackInfo> pageContainer;
	
	@Override
	public PageContainer<TeacherBackInfo> selectTeacherBackInfoByTeacherIdAndEngclassId(Integer teacherId, Integer engclassId) {
		String hql = " SELECT tbi FROM TeacherBackInfo tbi WHERE tbi.teacher.teacherId = ? AND tbi.engclass.engclassId = ?";
		return this.list(hql,pageContainer, teacherId, engclassId);
	}

	@Override
	public PageContainer<TeacherBackInfo> selectTeacherBackInfoByEngclassId(Integer userId,Integer engclassId) {
		String hql = "SELECT tbi FROM User u LEFT JOIN u.engclassSet ec LEFT JOIN ec.teacherBackInfoSet tbi WHERE u.userId = ? AND ec.engclassId = ?";
		return this.list(hql,pageContainer, userId,engclassId);
	}

	@Override
	public void insertTeacherBackInfo(List<TeacherBackInfo> teacherBackInfoList) {
		this.save(teacherBackInfoList);
	}

	@Override
	public PageContainer<TeacherBackInfo> getPageContainer() {
		return pageContainer;
	}

	@Override
	public void setPageContainer(PageContainer<TeacherBackInfo> pageContainer) {
		this.pageContainer = pageContainer;
	}
}
