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
	 * 查询所有班级的id/name列表
	 * @return
	 */
	List<Engclass> queryAllEngclassIdAndNameList();
	
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
	 * 根据班级编号查询班级信息
	 * @param engclassId
	 * @return
	 */
	Engclass queryEngclassByEngclasId(Integer engclassId);
	
	/**
	 * 保存班级信息
	 * @param engclass
	 */
	void saveEngclass(Engclass engclass);
	
	/**
	 * 保存分班后的班级，无需新建课程记录，直接引用原班级的课程记录即可
	 * @param engclass
	 */
	void saveSplitEngclass(Engclass engclass);
	
	/** 
	* @Description: 根据课程id查询正在进行的班级id/name列表
	* @return List<Engclass>
	*/ 
	List<Engclass> queryNowEngclassIdAndNameList(Integer courseId);
	
	/** 
	* @Description: 根据班级id查询该班级基本信息 
	* @param engclassId
	* @return Engclass
	*/ 
	Engclass queryEngclassByEngclassId(Integer engclassId);
	
	/** 
	* @Description: 合并班级 
	* @param engclass   新班级对象
 	* @param oldEngclassId1  旧班级id
	* @param oldEngclassId2
	* @return String
	*/ 
	String mergeEngclass(Engclass engclass,Integer oldEngclassId1,Integer oldEngclassId2);
	
}
