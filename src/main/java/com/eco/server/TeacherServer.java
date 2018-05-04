package com.eco.server;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;

/*
 * date:   2018年4月21日 上午11:05:51
 * author: Shixiaodong
 */
public interface TeacherServer {
	
	/**
	 * 根据教师id获取教师正在进行的课程列表
	 * @param teacherId
	 * @return
	 */
	public abstract List<CourseDetail> queryNowCourseDetailListByTeacherId(Integer teacherId,PageContainer pageContainer);
	
	/**
	 * 根据教师id获取教师已完成的课程列表信息
	 * @param teacherId
	 * @return
	 */
	public abstract List<CourseDetail> queryHistoryCourseDetailListByTeacherId(Integer teacherId,PageContainer pageContainer);
	
	/**
	 * 根据教师id获取教师所有的课程列表信息
	 * @param teacherId
	 * @return
	 */
	public abstract List<CourseDetail> queryAllCourseDetailListByTeacherId(Integer teacherId, PageContainer pageContainer);
	
	/**
	 * 根据教师id获取教师教过的班级详细信息
	 * @param teacherId
	 * @return
	 */
	public abstract List<EngclassDetail> queryEngclassListByTeacherId(Integer teacherId,PageContainer pageContainer);

	/**
	 * 根据教师id，班级id，班级名称 获取班级基本信息
	 * @param teacherId
	 * @param engclassId
	 * @param engclassName
	 * @return
	 */
	public List<Engclass> queryEngclassByCondition(Integer teacherId, Integer engclassId, String engclassName);
	
	/**
	 * 通过班级编号，获取班级详细信息
	 * @param engclassId
	 * @return
	 */
	public EngclassDetail queryEngclassDetailByEngclassId(Integer engclassId);
	
}
