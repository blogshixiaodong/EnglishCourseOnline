package com.eco.server;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;

/*
 * date:   2018年5月5日 下午4:46:26
 * author: Shixiaodong
 */
public interface CourseServer {
	
	/**
	 * 查询所有课程基本信息
	 * @return
	 */
	public abstract List<Course> queryAllCourse();
	
	/**
	 * 根据课程编号课程信息
	 * @param courseId
	 * @return
	 */
	public abstract Course queryCourseByCourseId(Integer courseId);
	
	/**
	 * 查询可报名的课程
	 * @return
	 */
	public abstract List<CourseDetail> queryEnrollCourseList();
	
}
