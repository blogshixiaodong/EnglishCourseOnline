package com.eco.dao;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.User;

/**
 * @date:   2018年4月20日 下午10:21:21
 * @author lenovo
 *
 */
public interface CourseDao {
	
	/** 
	* @Description: 用户 查询进程中课程
	* @param userid
	* @return List<User>
	*/ 
	List<Course> selectUserNowCourseListByUserId(Integer userId);
	
	
	/** 
	* @Description:用户查看历史课程
	* @param userid
	* @return List<Course>
	*/ 
	List<Course> selectUserHistoryCourseDetailListByUserId(Integer userId);
	
	
	/** 
	* @Description: 用户查询所有课程
	* @param userid
	* @return List<Course>
	*/ 
	List<Course> selectUserAllCourseDetailListByUserId(Integer userId);
	
	
	
	

}
