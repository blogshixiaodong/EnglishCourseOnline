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
	List<Engclass> queryNowEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainer);

	/**
	 * 根据教师id获取教师上过已结课的班级信息,支持分页
	 * @param teacherId
	 * @param pageContainer
	 * @return
	 */
	List<Engclass> queryHistoryEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainere);
	
	/**
	 * 根据教师id获取教师上过所有的班级信息,支持分页
	 * @param engclassId
	 * @param pageContainer
	 * @return
	 */
	List<Engclass> queryAllEngclassListByTeacherId(Integer teacherId, PageContainer<Engclass> pageContainer);
	
}
