package com.eco.server;

import java.util.List;
import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;

public interface BusinessServer {

	
	/** 
	* @Description: 添加课程 
	* @param course
	* @return int
	*/ 
	public abstract boolean addCourse(Course course);
	
	
	
	/** 
	* @Description: 查询所有课程
	* @param pageContainer
	* @return List<CourseDetail>
	*/ 
	public abstract List<Course> queryqueryAllCourseList(PageContainer pageContainer);
	
	
	
	/** 
	* @Description: 开设班级 
	* @param engclass
	* @param courseRecord
	* @return boolean
	*/ 
	public abstract boolean setUpEngclass(Engclass engclass,CourseRecord courseRecord);
	
	
}
