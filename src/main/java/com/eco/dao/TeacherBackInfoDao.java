package com.eco.dao;

import java.util.List;

import com.eco.bean.model.TeacherBackInfo;

public interface TeacherBackInfoDao {
	
	/**
	 * 根据班级id和用户id查询反馈详细信息
	 * @param classid
	 * @param userid
	 * @return
	 */
	public List<TeacherBackInfo> selectBackInfoDetailByEngclassIdAndUserId(Integer engclassId,Integer userId);
	
	/**
	 * 根据班级id和教师id查询反馈详细信息
	 * @param teacherId
	 * @param engclassId
	 * @return
	 */
	public abstract List<TeacherBackInfo> selectBackInfoDetailByEngclassIdAndTeacherId(Integer teacherId, Integer engclassId);
	
	/**
	 * 插入一条反馈信息到教师反馈信息表
	 * @param teacherBackInfo
	 * @return
	 */
	public abstract Boolean insert(TeacherBackInfo teacherBackInfo);
	
}
