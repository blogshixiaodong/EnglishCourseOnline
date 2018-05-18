package com.eco.server;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.bean.model.TeacherAccount;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;

/*
 * date:   2018年4月21日 上午11:05:51
 * author: Shixiaodong
 */

/**
 * @author 15129
 *
 */
public interface TeacherServer {
	
	/**
	 * 根据教师id获取教师正在进行的课程列表,支持分页
	 * @param teacherId
	 * @param pageContainer
	 * @return
	 */
	PageContainer<Course> queryNowCourseListByTeacherId(Integer teacherId,PageContainer<Course> pageContainer);
	
	/**
	 * 根据教师id获取教师已完成的课程列表信息,支持分页
	 * @param teacherId
	 * @param pageContainer
	 * @return
	 */
	PageContainer<Course> queryHistoryCourseListByTeacherId(Integer teacherId,PageContainer<Course> pageContainer);
	
	/**
	 * 根据教师id获取教师所有的课程列表信息,支持分页
	 * @param teacherId
	 * @param pageContainer
	 * @return
	 */
	PageContainer<Course> queryAllCourseListByTeacherId(Integer teacherId, PageContainer<Course> pageContainer);
	
	/**
	 * 根据教师id获取教师正在上课的的班级信息,支持分页
	 * @param teacherId
	 * @return
	 */
	PageContainer<Engclass> queryAllEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainer);

	/**
	 * engclassId存在则返回唯一一条记录，engclassId为空根据engclassName模糊查询
	 * @param engclassId
	 * @param engclassName
	 * @return
	 */
	List<Engclass> searchEngclassByEngclassIdAndEngclassName(Integer teacherId, Integer engclassId, String engclassName);
	
	/**
	 * 根据教师编号查询班级编号
	 * @param engclassId
	 * @return
	 */
	List<Engclass> queryEngclassIdAndEngclassNameByTeacherId(Integer teacherId);
	
	/**
	 * 保存用户考勤记录列表
	 * @param timeSheetList
	 */
	void saveUserTimeSheet(List<TimeSheet> timeSheetList);
	
	/**
	 * 根据教师编号，班级编号，查询教师反馈信息，支持分页
	 * @param teacherId
	 * @param engclassId
	 * @param pageContainer
	 * @return
	 */
	PageContainer<TeacherBackInfo> queryTeacherBackInfoByTeacherIdAndEngclassId(Integer teacherId, Integer engclassId, PageContainer<TeacherBackInfo> pageContainer);
	
	/**
	 * 根据班级编号查询用户id/name
	 * @param engclassId
	 * @return
	 */
	List<User> queryUserIdAndUsernameByEngclassId(Integer engclassId);
	
	/**
	 * 保存教师反馈信息列表
	 * @param teacherBackInfoList
	 */
	void saveTeacherBackInfo(List<TeacherBackInfo> teacherBackInfoList);
	
	/**
	 * 教师登陆校验
	 * @param teacherAccount
	 * @return
	 */
	Boolean loginCheck(TeacherAccount teacherAccount);
	
	/**
	 * 根据账号编号查询教师
	 * @param accountId
	 * @return
	 */
	public Teacher queryTeacherrByAccountId(Integer accountId);
	
	/** 
	* @Description: 获取教师课表 
	* @param teacherId
	* @return List<Engclass>
	*/ 
	public List<Engclass> queryTimeTable(String queryTime ,Integer teacherId);
	
}
