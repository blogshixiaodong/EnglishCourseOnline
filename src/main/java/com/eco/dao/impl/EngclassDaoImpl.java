package com.eco.dao.impl;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.User;
import com.eco.dao.EngclassDao;

/*
 * date:   2018年4月20日 下午10:32:20
 * author: Shixiaodong
 */
public class EngclassDaoImpl extends AbstractBaseDao<Engclass> implements EngclassDao {

	private PageContainer pageContainer;

	@Override
	public List<Engclass> selectTeacherNowEngclassListByTeacherId(Integer teacherId) {
		String hql = " SELECT e FROM Engclass e LEFT JOIN CourseRecord cr ON e.courseRecord.courseReocrdId = cr.courseRecordId " +
					 " WHERE e.teacher.teacherId = ? AND NOW() between cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public List<Engclass> selectTeacherHistoryEngclassListByTeacherId(Integer teacherId) {
		String hql = " SELECT e FROM Engclass e LEFT JOIN CourseRecord cr ON e.courseRecord.courseReocrdId = cr.courseRecordId " +
				     " WHERE e.teacher.teacherId = ? AND endTime < NOW() ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public List<Engclass> selectTeacherAllEngclassListByTeacherId(Integer teacherId) {
		String hql = " SELECT e FROM Engclass e LEFT JOIN CourseRecord cr ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				     " WHERE e.teacher.teacherId = ? ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}
	
	@Override
	public List<Engclass> selectUserNowEngclassListByUserId(Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN FETCH e.userSet u LEFT JOIN FETCH e.courseRecord cr WHERE u.userId = ? AND NOW() BETWEEN cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, userId) ;
	}

	@Override
	public List<Engclass> selectUserHistoryEngclassListByUserId(Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN FETCH e.courseRecord cr WHERE u.userId = ? AND NOW() > cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, userId) ;
	}

	@Override
	public List<Engclass> selectUserAllEngclassListByUserId(Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN FETCH e.courseRecord cr WHERE u.userId = ? ORDER BY cr.startTime DESC ";
		return this.list(hql, userId) ;
	}
	
	@Override
	public void insertUser(User user) {
		this.saveOrUpdate(user);
	}

	@Override																		
	public List<Engclass> selectEngclassByDate(Date beginDate,Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN FETCH e.courseRecord cr WHERE u.userId = ? AND STR_TO_DATE(cr.endTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return this.list(hql, userId,beginDate) ;
	}
	
	public PageContainer getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;
	}

	

	
}
