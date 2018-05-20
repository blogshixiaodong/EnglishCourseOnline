package com.eco.dao.impl;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.dao.EngclassDao;

/*
 * date:   2018年4月20日 下午10:32:20
 * author: Shixiaodong
 */
public class EngclassDaoImpl extends AbstractBaseDao<Engclass> implements EngclassDao {

	private PageContainer<Engclass> pageContainer;

	@Override
	public PageContainer<Engclass> selectTeacherNowEngclassListByTeacherId(Integer teacherId) {
		String hql = " SELECT e FROM Engclass e LEFT JOIN CourseRecord cr ON e.courseRecord.courseReocrdId = cr.courseRecordId " +
					 " WHERE e.teacher.teacherId = ? AND NOW() between cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public PageContainer<Engclass> selectTeacherHistoryEngclassListByTeacherId(Integer teacherId) {
		String hql = " SELECT e FROM Engclass e LEFT JOIN CourseRecord cr ON e.courseRecord.courseReocrdId = cr.courseRecordId " +
				     " WHERE e.teacher.teacherId = ? AND endTime < NOW() ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public PageContainer<Engclass> selectTeacherAllEngclassListByTeacherId(Integer teacherId) {
		String hql = " SELECT e FROM Engclass e LEFT JOIN CourseRecord cr ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				     " WHERE e.teacher.teacherId = ? ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}
	
	@Override
	public List<Engclass> selectAllEngclassIdAndNameList() {
		String hql = " SELECT new Engclass(engclassId, engclassName) FROM Engclass e";
		return this.list(hql);
	}
	
	@Override
	public List<Engclass> selectEngclassIdAndEngclassNameByTeacherId(Integer teacherId) {
		String hql = " SELECT new Engclass(engclassId, engclassName) FROM Engclass e WHERE e.teacher.teacherId = ?";
		return this.list(hql, teacherId);
	}

	@Override
	public Engclass selectEngclassByEngclassId(Integer teacherId, Integer engclassId) {
		String hql = " SELECT e FROM Engclass e WHERE e.teacher.teacherId = ? AND e.engclassId = ? ";
		return this.get(hql, teacherId, engclassId);
	}
	
	@Override
	public List<Engclass> selectEngclassListByEngclassName(Integer teacherId, String engclassName) {
		String hql = " SELECT e FROM Engclass e WHERE e.teacher.teacherId = ? AND e.engclassName like ? ";
		return this.list(hql, teacherId, engclassName);
	}

	@Override
	public PageContainer<Engclass> selectUserNowEngclassListByUserId(Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN e.courseRecord cr WHERE u.userId = ? AND NOW() BETWEEN cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer,  userId) ;
	}

	@Override
	public PageContainer<Engclass> selectUserHistoryEngclassListByUserId(Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN e.courseRecord cr WHERE u.userId = ? AND NOW() > cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer,  userId) ;
	}

	@Override
	public PageContainer<Engclass> selectUserAllEngclassListByUserId(Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN e.courseRecord cr WHERE u.userId = ? ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer,  userId) ;
	}
	
	@Override
	public List<Engclass> selectEngclassByUserId(Integer userId) {
		String hql = "SELECT new Engclass(e.engclassId,e.engclassName) FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN e.courseRecord cr WHERE u.userId = ? ORDER BY cr.startTime DESC ";
		return list(hql, userId);
	}
	
	@Override
	public void insertUser(Engclass engclass) {
		this.save(engclass);
	}

	@Override																		
	public List<Engclass> selectUserEngclassByDate(Date beginDate, Integer userId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.userSet u LEFT JOIN FETCH e.courseRecord cr WHERE u.userId = ? AND STR_TO_DATE(?,'%Y-%m-%d') BETWEEN STR_TO_DATE(cr.startTime,'%Y-%m-%d') AND  STR_TO_DATE(cr.endTime,'%Y-%m-%d') ";
		return this.list(hql, userId,beginDate) ;
	}
	
	@Override
	public Engclass selectEngclassByCourseRecord(Integer courseRecordId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.courseRecord cr WHERE cr.courseRecordId = ?";
		return (Engclass)this.get(hql,courseRecordId);
	}
	
	@Override
	public Engclass selectEngclassByEngclassId(Integer engclassId) {
		return this.get(engclassId);
	}

	@Override
	public PageContainer<Engclass> getPageContainer() {
		return pageContainer;
	}

	@Override
	public void setPageContainer(PageContainer<Engclass> pageContainer) {
		this.pageContainer = pageContainer;
	}

	@Override
	public List<Engclass> selectTeacherEngclassByDate(Date beginDate,Integer teacherId) {
		String hql = "SELECT e FROM Engclass e LEFT JOIN e.teacher t LEFT JOIN e.courseRecord cr WHERE t.teacherId = ? AND STR_TO_DATE(?,'%Y-%m-%d') BETWEEN STR_TO_DATE(cr.startTime,'%Y-%m-%d') AND  STR_TO_DATE(cr.endTime,'%Y-%m-%d') ";
		return this.list(hql,teacherId,beginDate);
	}

	@Override
	public void insertEngclass(Engclass engclass) {
		this.save(engclass);
	}

	@Override
	public List<Engclass> selectNowEngclassIdAndNameByCourseId(Integer courseId) {
		String hql = "SELECT new Engclass(e.engclassId,e.engclassName) FROM Engclass e LEFT JOIN  e.courseRecord cr LEFT JOIN cr.course c WHERE c.courseId = ? AND e.userCount <> -1";
		return list(hql, courseId);
	}

	

	@Override
	public void updateEngclass(Engclass engclass) {
		this.update(engclass);
	}

	@Override
	public void updateEngclassUserCount(Integer engclassId, Integer userCount) {
		String hql = "UPDATE Engclass e SET e.userCount = e.userCount + ? WHERE e.engclassId = ?";
		this.executeHQLUpdate(hql,engclassId,engclassId);
	}

	@Override
	public void updateEngclassUserCount(Integer engclassId) {
		String hql = "UPDATE Engclass e SET e.userCount = -1 WHERE e.engclassId = ?";
		this.executeHQLUpdate(hql, engclassId);
	}

	
}
