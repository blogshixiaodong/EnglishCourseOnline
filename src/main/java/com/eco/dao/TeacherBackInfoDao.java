package com.eco.dao;

import java.util.List;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TeacherBackInfo;

public interface TeacherBackInfoDao extends PageDao {

	/**
	 * 根据教师编号和班级编号查询教师反馈信息
	 * @param teacherId
	 * @param engclassId
	 * @return
	 */
	PageContainer<TeacherBackInfo> selectTeacherBackInfoByTeacherIdAndEngclassId(Integer teacherId, Integer engclassId);
	
	/**
	 * 批量插入教师反馈信息
	 * @param teacherBackInfoList
	 */
	void insertTeacherBackInfo(List<TeacherBackInfo> teacherBackInfoList);
	
	/** 
	* @Description: 用户查询教师反馈信息 
	* @param engclassId
	* @return List<TeacherBackInfo>
	*/ 
	PageContainer<TeacherBackInfo> selectTeacherBackInfoByEngclassId(Integer userId,Integer engclassId);

}
