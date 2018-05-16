package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseDao;

/*
 * date:   2018年4月20日 下午10:21:57
 * author: Shixiaodong
 */
public class CourseDaoImpl extends AbstractBaseDao<Course> implements CourseDao {

	private PageContainer<Course> pageContainer;
	
	@Override
	public PageContainer<Course> selectTeacherNowCourseListByTeacherId(Integer teacherId) {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
					 " WHERE e.teacher.teacherId = ? AND NOW() between cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public PageContainer<Course> selectTeacherHistoryCourseListByTeacherId(Integer teacherId) {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				 " WHERE e.teacher.teacherId = ? AND endTime < NOW() ORDER BY startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public PageContainer<Course> selectTeacherAllCourseListByTeacherId(Integer teacherId) {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				 " WHERE e.teacher.teacherId = ? ORDER BY startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public PageContainer<Course> selectUserNowCourseListByUserId(Integer userId) {
		String hql = "SELECT distinct c FROM Course c LEFT JOIN c.courseRecordSet cr LEFT JOIN " +
				 	 "cr.engclassSet ec LEFT JOIN ec.userSet u WHERE u.userId=? AND NOW() BETWEEN cr.startTime AND cr.endTime";
		return this.list(hql, pageContainer,userId);													
	}

	@Override
	public PageContainer<Course> selectUserHistoryCourseDetailListByUserId(Integer userId) {
		String hql = "SELECT distinct c FROM Course c LEFT JOIN c.courseRecordSet cr LEFT JOIN " +
					 "cr.engclassSet ec LEFT JOIN ec.userSet u WHERE u.userId=? AND NOW() > cr.endTime";
		return this.list(hql, pageContainer,userId);
	}

	@Override
	public PageContainer<Course> selectUserAllCourseDetailListByUserId(Integer userId) {
		String hql = "SELECT distinct c FROM Course c LEFT JOIN c.courseRecordSet cr LEFT JOIN cr.engclassSet ec LEFT JOIN ec.userSet u WHERE u.userId=?";
		return this.list(hql,pageContainer, userId);
	}

	
	
	@Override
	public PageContainer<Course> selectNowCourseList() {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
					 " WHERE NOW() between cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer);
	}

	@Override
	public PageContainer<Course> selectAllCourseList() {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				 	 " ORDER BY startTime DESC ";
		return this.list(hql, pageContainer);
	}
	
	@Override
	public void insertCourse(Course course) {
		this.save(course);
	}

	@Override
	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;
		
	}

	@Override
	public PageContainer getPageContainer() {
		return pageContainer;
	}
}
