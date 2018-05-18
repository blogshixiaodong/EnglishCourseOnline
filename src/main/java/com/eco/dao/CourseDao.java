package com.eco.dao;

import java.util.List;

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
	
	/**
	 * 商家查询所有进行中的课程
	 * @return
	 */
	PageContainer<Course> selectNowCourseList();
	
	/**
	 * 商家查询所有的课程
	 * @return
	 */
	PageContainer<Course> selectAllCourseList();
	
	/**
	 * 保存课程基本信息
	 * @param course
	 */
	void insertCourse(Course course);
	
	/**
	 * 查询所有课程id/name列表
	 * @return
	 */
	List<Course> selectNowCourseIdAndNameList();
	
	/**
	 * 根据课程编号查询课程信息
	 * @param courseId
	 * @return
	 */
	Course selectCourseByCourseId(Integer courseId);
	
}
