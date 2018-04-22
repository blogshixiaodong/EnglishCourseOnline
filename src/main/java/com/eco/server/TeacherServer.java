package com.eco.server;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;

/*
 * date:   2018年4月21日 上午11:05:51
 * author: Shixiaodong
 */
public interface TeacherServer {
	
	public abstract List<CourseDetail> getNowCourseDetailList(Integer teacherId);
	
	public abstract List<CourseDetail> getHistoryCourseDetailList(Integer teacherId);
	
	public abstract List<CourseDetail> getAllCourseDetailList(Integer teacherId);
	
	public abstract List<EngclassDetail> getEngclassList(Integer teacherId);

}
