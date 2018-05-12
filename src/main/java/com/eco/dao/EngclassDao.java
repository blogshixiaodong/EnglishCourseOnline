package com.eco.dao;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.User;


/*
 * date:   2018年4月20日 下午10:31:04
 * author: Shixiaodong
 */
/**
 * @author 15129
 *
 */
public interface EngclassDao extends PageDao {

	/**
	 * 根据教师id获取教师正在进行授课的班级
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectTeacherNowEngclassListByTeacherId(Integer teacherId);

	/**
	 * 根据教师id获取教师已完成授课的班级
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectTeacherHistoryEngclassListByTeacherId(Integer teacherId);

	/**
	 * 根据教师id获取教师所有授课的班级
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectTeacherAllEngclassListByTeacherId(Integer teacherId);
	
	
	/** 
	* @Description: 根据用户id获取用户正在进行的课程 
	* @param userid
	* @return List<Engclass>
	*/ 
	List<Engclass> selectUserNowEngclassListByUserId(Integer userid);
	
	
	/** 
	* @Description: 根据用户id获取用户历史进行的课程 
	* @param userid
	* @return List<Engclass>
	*/ 
	List<Engclass> selectUserHistoryEngclassListByUserId(Integer userid);
	
	
	/** 
	* @Description: 根据用户id获取用户所有课程 
	* @param userid
	* @return List<Engclass>
	*/ 
	List<Engclass> selectUserAllEngclassListByUserId(Integer userid);
	
	
	/** 
	* @Description: 添加用户 
	* @param user void
	*/ 
	void insertUser(User user);
	
	
	/** 
	* @Description: 用户查看课表
	* @param beginDate
	* @param endDate
	* @return List<Engclass>
	*/ 
	List<Engclass> selectEngclassByDate(Date beginDate,Integer userId);
	
	
}
