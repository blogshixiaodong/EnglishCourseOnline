package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;

/**
 * @date:   2018年4月20日 下午10:21:21
 * @author lenovo
 *
 */
public interface CourseDao {
	
	/**
	 * 根据教师id获取教师正在进行的课程详细信息列表
	 * @param teacherId
	 * @return
	 */
	public abstract List<CourseDetail> selectTeacherNowCourseDetailListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师id获取教师已完成的课程详细信息列表
	 * @param teacherId
	 * @return
	 */
	public abstract List<CourseDetail> selectTeacherIdHistoryCourseDetailListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师id获取教师所有的课程详细信息列表
	 * @param teacherId
	 * @return
	 */
	public abstract List<CourseDetail> selectAllCourseDetailListByTeacherId(Integer teacherId);
	
	/** 
	* 根据用户id获取用户正在进行的课程记录
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> selectUserNowCourseDetailListByUserId(Integer userid);
	
	/** 
	* 根据用户id获取用户已完成的课程记录 
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> selectUserHistoryCourseDetailListByUserId(Integer userid);
	
	/** 
	* 根据用户id获取用户所有课程记录 
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> selectUserAllCourseDetailListByUserId(Integer userid);

}
