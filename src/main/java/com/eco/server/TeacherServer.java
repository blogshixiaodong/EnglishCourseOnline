package com.eco.server;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;

/*
 * date:   2018年4月21日 上午11:05:51
 * author: Shixiaodong
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
	List<Engclass> selectEngclassIdAndEngclassNameByTeacherId(Integer teacherId);
	
	
}
