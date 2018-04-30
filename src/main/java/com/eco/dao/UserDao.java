package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.User;

/*
 * date:   2018年4月20日 下午10:18:27
 * author: Shixiaodong, lenovo
 */
public interface UserDao {
	
	public abstract List<User> selectUserByEngclassId(Integer engclassId);
	
	/** 
	* @Description: 根据用户id获取用户信息 
	* @param userid
	* @return User
	*/ 
	public abstract User selectUserByUserId(int userId);
	
	
	/** 
	* @Description: 根据用户id获取课程信息  
	* @param userid
	* @return List<CourseDetail>
	*/ 
	List<CourseDetail> selectCoursebyUserId(int userId);
	
	
	
	/** 
	* @Description: 用户是否存在
	* @param userid
	* @return boolean
	*/ 
	boolean isExistUser(int userid) ;
	
	
	/** 
	* @Description: 根据班级查询所有学生
	* @param classid
	* @return List<User>
	*/ 
	List<User> selectUserListByClassId(int classId);
	
	
}
