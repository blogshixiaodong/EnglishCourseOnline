package com.eco.server;

import java.util.List;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;

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
	
	/**
	 * 查询所有课程的id/name列表
	 * @return
	 */
	List<Course> queryNowCourseIdAndNameList();
	
	/**
	 * 查询所有教师的id/name列表
	 * @return
	 */
	List<Teacher> queryAllTeacherIdAndNameList();
	
	/**
	 * 根据课程编号查询课程信息
	 * @param courseId
	 * @return
	 */
	Course queryCourseByCourseId(Integer courseId);
	
	/**
	 * 根据教师编号查询教师信息
	 * @param teacherId
	 * @return
	 */
	Teacher queryTeacherByTeacherId(Integer teacherId);
	
	/**
	 * 保存班级信息
	 * @param engclass
	 */
	void saveEngclass(Engclass engclass);
	
}
