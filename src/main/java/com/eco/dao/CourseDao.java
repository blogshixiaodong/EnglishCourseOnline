package com.eco.dao;

import java.util.List;

import com.eco.bean.model.Course;

/**
 * @date:   2018年4月20日 下午10:21:21
 * @author lenovo
 *
 */
public interface CourseDao {
	
	/**
	 * 根据教师id获取教师正在进行的课程
	 * @param teacherId
	 * @return
	 */
	List<Course> selectTeacherNowCourseListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师id获取教师已完成的课程
	 * @param teacherId
	 * @return
	 */
	List<Course> selectTeacherHistoryCourseListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师id获取教师所有的课程
	 * @param teacherId
	 * @return
	 */
	List<Course> selectTeacherAllCourseListByTeacherId(Integer teacherId);

}
