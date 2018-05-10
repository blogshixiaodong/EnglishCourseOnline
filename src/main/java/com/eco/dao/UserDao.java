package com.eco.dao;

import java.util.List;

import com.eco.bean.model.User;

/*
 * date:   2018年4月20日 下午10:18:27
 * author: Shixiaodong, lenovo
 */
public interface UserDao {
	
	/** 
	* @Description: 根据班级查询所有学生
	* @param classid
	* @return List<User>
	*/ 
	List<User> selectEngclassAllUserByEngclassId(Integer engclassId);
	

	
	
}
