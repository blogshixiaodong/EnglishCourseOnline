package com.eco.dao;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.UserBackInfo;


/**
 * @author lenovo
 *
 */

public interface UserBackInfoDao extends PageDao<UserBackInfo> {

	/**
	 * 根据班级编号查询学生反馈信息
	 * @param engclassId
	 * @return
	 */
	PageContainer<UserBackInfo> selectUserBackInfoByEngclassId(Integer engclassId);
	
	/** 
	* @Description: 查询用户反馈信息 
	* @param userId
	* @param engclassId
	* @return List<UserBackInfo>
	*/ 
	PageContainer<UserBackInfo> selectUserBackInfoByUserIdAndEngclassId(Integer userId, Integer engclassId);
	
	/** 
	* @Description: 添加用户反馈信息
	* @param userBackInfo void
	*/ 
	void insertUserBackInfo(UserBackInfo userBackInfo);
	
}
