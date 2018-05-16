package com.eco.dao;

import java.util.Date;
import java.util.List;

import org.apache.struts2.components.Select;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.User;


/*
 * date:   2018年4月20日 下午10:31:04
 * author: Shixiaodong
 */

public interface EngclassDao extends PageDao<Engclass> {

	/**
	 * 根据教师id获取教师正在进行授课的班级
	 * @param teacherId
	 * @return
	 */
	PageContainer<Engclass> selectTeacherNowEngclassListByTeacherId(Integer teacherId);

	/**
	 * 根据教师id获取教师已完成授课的班级
	 * @param teacherId
	 * @return
	 */
	PageContainer<Engclass> selectTeacherHistoryEngclassListByTeacherId(Integer teacherId);

	/**
	 * 根据教师id获取教师所有授课的班级
	 * @param teacherId
	 * @return
	 */
	PageContainer<Engclass> selectTeacherAllEngclassListByTeacherId(Integer teacherId);
	
	/**
	 * 根据教师编号查询班级编号名称
	 * @param teacherId
	 * @return
	 */
	List<Engclass> selectEngclassIdAndEngclassNameByTeacherId(Integer teacherId);
	
	/**
	 * 根据班级编号查询
	 * @param engclassId
	 * @return
	 */
	Engclass selectEngclassByEngclassId(Integer teacherId, Integer engclassId);
	
	/**
	 * 根据班级名称查询
	 * @param engclassName
	 * @return
	 */
	List<Engclass> selectEngclassListByEngclassName(Integer teacherId, String engclassName);
	
	/** 
	* @Description: 根据用户id获取用户正在进行的课程 
	* @param userid
	* @return List<Engclass>
	*/ 
	PageContainer<Engclass> selectUserNowEngclassListByUserId(Integer userid);
	
	
	/** 
	* @Description: 根据用户id获取用户历史进行的课程 
	* @param userid
	* @return List<Engclass>
	*/ 
	PageContainer<Engclass> selectUserHistoryEngclassListByUserId(Integer userid);
	
	
	/** 
	* @Description: 根据用户id获取用户所有课程 
	* @param userid
	* @return List<Engclass>
	*/ 
	PageContainer<Engclass> selectUserAllEngclassListByUserId(Integer userid);
	
	
	/** 
	* @Description: 根据班级id 在该班级(userengclass表)插入一条学生记录
	* @param user void
	*/ 
	void insertUser(Engclass engclass);
	
	
	/** 
	* @Description: 根据用户id 查询该用户的当前班级
	* @param userId
	* @return Engclass
	*/ 
	List<Engclass> selectEngclassByUserId(Integer userId);
	
	
	/** 
	* @Description: 用户查看课表
	* @param beginDate
	* @param endDate
	* @return List<Engclass>
	*/ 
	List<Engclass> selectEngclassByDate(Date beginDate,Integer userId);
	
	
	/** 
	* @Description: 根据 courseReocrdId  获得对应的一个班级对象
	* @param courseRecordId
	* @return Engclass
	*/ 
	Engclass selectEngclassByCourseRecord(Integer courseRecordId);
	
	

	
}
