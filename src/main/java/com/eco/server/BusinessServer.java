package com.eco.server;

import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;

public interface BusinessServer {

	PageContainer<Course> queryNowCourseList(PageContainer<Course> pageContainer);
	
	PageContainer<Course> queryAllCourseList(PageContainer<Course> pageContainer);
	
	void saveCourse(Course course);
	
}
