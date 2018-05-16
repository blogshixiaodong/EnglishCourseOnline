package com.eco.server;

import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;

public interface BusinessServer {

	/**
	 * 查询所有进行中的课程
	 * @param pageContainer
	 * @return
	 */
	PageContainer<Course> queryNowCourseList(PageContainer<Course> pageContainer);
		
	/**
	 * 查询所有课程
	 * @param pageContainer
	 * @return
	 */
	PageContainer<Course> queryAllCourseList(PageContainer<Course> pageContainer);
	
	/**
	 * 添加课程基本信息
	 * @param course
	 */
	void saveCourse(Course course);
	
}
