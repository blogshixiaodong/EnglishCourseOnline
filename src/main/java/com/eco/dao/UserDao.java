package com.eco.dao;

import java.util.List;

import com.eco.bean.model.User;

/*
 * date:   2018年4月20日 下午10:18:27
 * author: Shixiaodong, lenovo
 */
public interface UserDao extends PageDao {
	
	public abstract List<User> selectUserByEngclassId(Integer engclassId);
	
	/** 
	* @Description: 根据用户id获取用户信息 
	* @param userid
	* @return User
	*/ 
	User selectUserByUserId(int userId);
		
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
	
	
	/** 
	* @Description: 根据账号id 查询用户的个人信息 
	* @param AccountId
	* @return User
	*/ 
	User selectUserByAccountId(Integer AccountId);
	
	
	
}
