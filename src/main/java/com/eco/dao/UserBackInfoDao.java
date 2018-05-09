package com.eco.dao;

import java.util.List;

import com.eco.bean.model.UserBackInfo;


/**
 * @author lenovo
 *
 */
public interface UserBackInfoDao {
	
	
	
	
	/** 
	* @Description: 根据用户班级对象，查询反馈信息 
	* @param userClass
	* @return List<BackInfoDetail>
	*/ 
	List<UserBackInfo> selectBackInfoByUserIdAndEngclassId(Integer userId, Integer engclassId);
	
	boolean createUserBackInfo(UserBackInfo backInfo);
	
	

	public abstract List<UserBackInfo> selectBackInfoByEngclassId(Integer engclassId);
	
	
	/** 
	* @Description: 根据用户id 和班级id 查询反馈信息
	* @param userId
	* @param engclassId
	* @return List<BackInfoDetail>
	*/ 
	public abstract List<UserBackInfo> selectBackInfoByUserIdAndClassId(Integer userId,Integer engclassId);
	
	
	/** 
	* @Description: 根据classid 查询该班级用户的所有反馈记录 
	* @param engclassId
	* @return List<BackInfoDetail>
	*/ 
//	public abstract List<BackInfoDetail> selectAllBackInfoByEngclassId(Integer engclassId);
	
	
}
