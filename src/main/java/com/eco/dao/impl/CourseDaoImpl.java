package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;
import com.eco.dao.CourseDao;

/*
 * date:   2018年4月20日 下午10:21:57
 * author: Shixiaodong
 */
public class CourseDaoImpl extends AbstractBaseDao<Course> implements CourseDao {

	/*
	 * 获取正在进行的课程记录
	 * */
	@Override
	public List<CourseDetail> getNowCourseDetailList(Integer teacherId) {
		String sql = "SELECT c.courseid, coursename, info, types, price, imgurl, cr.courserecordid, starttime, endtime, closetime, signcount " + 
				 "FROM course c, course_record cr, engclass e " + 
				 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid AND NOW() between starttime AND endtime ORDER BY starttime DESC;";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	/*
	 * 获取历史课程记录
	 * */
	@Override
	public List<CourseDetail> getHistoryCourseDetailList(Integer teacherId) {
		String sql = "SELECT c.courseid, coursename, info, types, price, imgurl, cr.courserecordid, starttime, endtime, closetime, signcount " + 
				 	 "FROM course c, course_record cr, engclass e " + 
				 	 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid AND endtime < NOW() ORDER BY starttime DESC;";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	/*
	 * 获取所有课程记录
	 * */
	@Override
	public List<CourseDetail> getAllCourseDetailList(Integer teacherId) {
		String sql = "SELECT c.courseid, coursename, info, types, price, imgurl, cr.courserecordid, starttime, endtime, closetime, signcount " + 
					 "FROM course c, course_record cr, engclass e " + 
					 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid ADN cr.courseid = c.courseid ORDER BY starttime DESC;";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

}
