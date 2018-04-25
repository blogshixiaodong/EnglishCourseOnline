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

}	
