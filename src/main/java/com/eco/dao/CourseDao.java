package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;

/*
 * date:   2018年4月20日 下午10:21:21
 * author: Shixiaodong
 */
public interface CourseDao extends BaseDao<Course> {
	//课程相关
	public abstract List<CourseDetail> getNowCourseDetailList(Integer teacherId);
	
	public abstract List<CourseDetail> getHistoryCourseDetailList(Integer teacherId);
	
	public abstract List<CourseDetail> getAllCourseDetailList(Integer teacherId);
}
