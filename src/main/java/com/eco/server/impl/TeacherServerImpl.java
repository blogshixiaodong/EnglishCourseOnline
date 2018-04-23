package com.eco.server.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.dao.CourseDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.server.TeacherServer;

/*
 * date:   2018年4月21日 上午11:06:01
 * author: Shixiaodong
 */
public class TeacherServerImpl implements TeacherServer {

	private CourseDao courseDao = new CourseDaoImpl();
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
	@Override
	public List<CourseDetail> getNowCourseDetailList(Integer teacherId) {
		return courseDao.getNowCourseDetailList(teacherId);
	}

	@Override
	public List<CourseDetail> getHistoryCourseDetailList(Integer teacherId) {
		return courseDao.getHistoryCourseDetailList(teacherId);
	}

	@Override
	public List<CourseDetail> getAllCourseDetailList(Integer teacherId) {
		return courseDao.getAllCourseDetailList(teacherId);
	}
	
	public List<EngclassDetail> getEngclassList(Integer teacherId) {
		return engclassDao.getEngclassList(teacherId);
	}

	@Override
	public Engclass getEngclassByClassIdAndName(Integer classId, String className) {
		if(classId == null) {
			if(className == null || "".equals(className)) {
				return null;
			} else {
				List<Engclass> engclassList = engclassDao.getEngclassListByName(className);
				if(engclassList.size() != 0) {
					return engclassList.get(0);
				} else {
					return null;
				}
			}
		} else {
			return engclassDao.getEngclassByClassId(classId);
		}
	}
	
}
