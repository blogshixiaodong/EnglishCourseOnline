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

	private PageContainer pageContainer;
	
	@Override
	public List<Course> selectTeacherNowCourseListByTeacherId(Integer teacherId) {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
					 " WHERE e.teacher.teacherId = ? AND NOW() between cr.startTime AND cr.endTime ORDER BY cr.startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public List<Course> selectTeacherHistoryCourseListByTeacherId(Integer teacherId) {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				 " WHERE e.teacher.teacherId = ? AND endTime < NOW() ORDER BY startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public List<Course> selectTeacherAllCourseListByTeacherId(Integer teacherId) {
		String hql = " SELECT distinct c FROM Course c LEFT JOIN CourseRecord cr ON c.courseId = cr.course.courseId LEFT JOIN Engclass e ON e.courseRecord.courseRecordId = cr.courseRecordId " +
				 " WHERE e.teacher.teacherId = ? ORDER BY startTime DESC ";
		return this.list(hql, pageContainer, teacherId);
	}

	@Override
	public List<Course> selectUserNowCourseListByUserId(Integer userId) {
		String hql = "SELECT distinct c FROM Course c LEFT JOIN FETCH c.courseRecordSet cr LEFT JOIN FETCH " +
				 	 "cr.engclassSet ec LEFT JOIN FETCH ec.userSet u WHERE u.userId=? AND NOW() BETWEEN cr.starttime AND cr.endtime";
		return this.list(hql, userId);
	}

	@Override
	public List<Course> selectUserHistoryCourseDetailListByUserId(Integer userId) {
		String hql = "SELECT distinct c FROM Course c LEFT JOIN FETCH c.courseRecordSet cr LEFT JOIN FETCH " +
					 "cr.engclassSet ec LEFT JOIN FETCH ec.userSet u WHERE u.userId=? AND NOW() > cr.endtime";
		return this.list(hql, userId);
	}

	@Override
	public List<Course> selectUserAllCourseDetailListByUserId(Integer userId) {
		String hql = "SELECT distinct c FROM Course c LEFT JOIN FETCH c.courseRecordSet cr LEFT JOIN FETCH cr.engclassSet ec LEFT JOIN FETCH ec.userSet u WHERE u.userId=?";
		return this.list(hql, userId);
	}
	
	public PageContainer getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;

	}

}
