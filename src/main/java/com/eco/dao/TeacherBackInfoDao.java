package com.eco.dao;

import java.util.List;

import com.eco.bean.model.TeacherBackInfo;

public interface TeacherBackInfoDao {
	
	/** 
	* @Description: 用户查询教师反馈信息 
	* @param engclassId
	* @return List<TeacherBackInfo>
	*/ 
	List<TeacherBackInfo> selectTeacherBackInfoByEngclassId(Integer userId,Integer engclassId);
	
}
