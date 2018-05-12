package com.eco.dao;

import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;

/**
 * @date:   2018年4月20日 下午10:21:21
 * @author lenovo
 *
 */
public interface CourseDao extends PageDao<Course> {
	
	/**
	 * 根据教师id获取教师正在进行的课程
	 * @param teacherId
	 * @return
	 */
	PageContainer<Course> selectTeacherNowCourseListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师id获取教师已完成的课程
	 * @param teacherId
	 * @return
	 */
	PageContainer<Course> selectTeacherHistoryCourseListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师id获取教师所有的课程
	 * @param teacherId
	 * @return
	 */
	PageContainer<Course> selectTeacherAllCourseListByTeacherId(Integer teacherId);

	/** 
	* @Description: 用户 查询进程中课程
	* @param userid
	* @return List<User>
	*/ 
	PageContainer<Course> selectUserNowCourseListByUserId(Integer userId);
	
	
	/** 
	* @Description:用户查看历史课程
	* @param userid
	* @return List<Course>
	*/ 
	PageContainer<Course> selectUserHistoryCourseDetailListByUserId(Integer userId);
	
	
	/** 
	* @Description: 用户查询所有课程
	* @param userid
	* @return List<Course>
	*/ 
	PageContainer<Course> selectUserAllCourseDetailListByUserId(Integer userId);

}
