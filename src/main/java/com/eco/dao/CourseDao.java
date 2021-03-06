package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;

/**
 * @date:   2018年4月20日 下午10:21:21
 * @author lenovo
 *
 */
public interface CourseDao extends PageDao {
	
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
	 * 根据教师id获取教师所有的课程记录数
	 * @param teacherId
	 * @return
	 */
	public int countAllCourseDetailByTeacherId(Integer teacherId);
	
	
	/** 
	* @Description: 根据教师id获取教师正在进行的课程记录数
	* @param teacherId
	* @return int
	*/ 
	public int countNowCourseDetailByTeacherId(Integer teacherId);
	
	
	
	/** 
	* @Description: 根据用户id获取用户所有的课程记录数 
	* @param teacherId
	* @return int
	*/ 
	public int countAllCourseDetailByUserId(Integer userId);
	
	
	/** 
	* @Description: 根据用户id获取用户历史的课程记录数 
	* @param teacherId
	* @return int
	*/ 
	public int countHistoryCourseDetailByTeacherId(Integer teacherId);
	
	
	
	/** 
	* @Description: 根据用户id获取用户当前正在进行的课程记录 
	* @param userId
	* @return int
	*/ 
	public int countNowCourseDetailByUserId(Integer userId);
	
	/** 
	* @Description: 根据用户id获取用户历史正在进行的课程记录  
	* @param userId
	* @return int
	*/ 
	public int countHistoryCourseDetailByUserId(Integer userId);
	
	
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
	

	/**
	 * 查询所有课程基本信息
	 * @return
	 */
	public abstract List<Course> selectAllCourse();
	
	
	/**
	 * 根据课程编号查询课程信息
	 * @param courseId
	 * @return
	 */
	public abstract Course selectCourseByCourseId(Integer courseId);

	
	/** 
	* @Description:添加课程
	* @param course
	* @return int
	*/ 
	public abstract int insertCourse(Course course);
	
	
	/** 
	* @Description: 查询所有课程记录 
	* @return List<Course>
	*/ 
	public abstract List<Course> selectAllCourseList();
	
	
	/** 
	* @Description: 所有课程数 
	* @return int
	*/ 
	public abstract int countAllCourse();
	
	
	/**
	 * 用户可以报名的课程记录，未到截止时间
	 * @return
	 */
	public abstract List<CourseDetail> selectEnrollCourseList();
	

}
