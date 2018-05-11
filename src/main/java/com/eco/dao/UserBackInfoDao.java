package com.eco.dao;

import java.util.List;

import com.eco.bean.model.UserBackInfo;


/**
 * @author lenovo
 *
 */
public interface UserBackInfoDao {
	
	/** 
	* @Description: 查询用户反馈信息 
	* @param userId
	* @param engclassId
	* @return List<UserBackInfo>
	*/ 
	List<UserBackInfo> selectUserBackInfoByUserIdAndEngclassId(Integer userId, Integer engclassId);
	
	/** 
	* @Description: 添加用户反馈信息
	* @param userBackInfo void
	*/ 
	void insertUserBackInfo(UserBackInfo userBackInfo);
	
}
