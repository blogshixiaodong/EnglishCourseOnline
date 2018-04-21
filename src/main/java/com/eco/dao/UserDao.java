package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.User;
import com.eco.bean.model.UserBackInfo;

/**
 * @author lenovo
 *
 */
public interface UserDao {
	
	
	/** 
	* @Description: 根据用户id获取用户信息 
	* @param userid
	* @return User
	*/ 
	User queryUserById(int userid) ;
	
	
	/** 
	* @Description: 根据用户id获取课程信息  
	* @param userid
	* @return List<CourseDetail>
	*/ 
	List<CourseDetail> queryCourseInfoList(int userid);
	
	
	
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
	List<User> queryAllUserByClassid(int classid);
	
	
}
