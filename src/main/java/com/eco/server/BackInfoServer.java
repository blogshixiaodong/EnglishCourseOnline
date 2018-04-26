package com.eco.server;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;

/*
 * date:   2018年4月24日 上午11:23:58
 * author: Shixiaodong
 */
public interface BackInfoServer {
		
	public abstract List<BackInfoDetail> getBackInfoByTeacherIdAndClassId(Integer teacherId, Integer engclassId);
	

	
	/** 
	* @Description: 根据用户id 和班级id查询反馈信息 
	* @param userId
	* @param engclassId
	* @return List<BackInfoDetail>
	*/ 
	public abstract List<BackInfoDetail> getBackInfoByUserIdAndClassId(Integer userId, Integer engclassId);
	
	
	/** 
	* @Description: 添加用户反馈信息 
	* @param engclassId
	* @param userId
	* @param backInfo
	* @return int
	*/ 
	public abstract int createUserBackInfo(Integer engclassId,Integer userId,String backInfo);
	
	
	
	public abstract List<BackInfoDetail> getAllUserBackInfobyClassId(Integer engclassId);
	
	
	
	public abstract int insertTeacherBackInfo(Integer teacherId, Integer engclassId, Integer[] userIdList, String backInfo);
	
	
	
	

}	
