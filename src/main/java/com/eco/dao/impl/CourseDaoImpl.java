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
		String sql = "SELECT courseid, coursename, info, types, price, imgurl, courserecordid, starttime, endtime, closetime, signcount " + 
				 "FROM course c, course_record cr, engclass e" + 
				 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid AND NOW between starttime AND endtime";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	/*
	 * 获取历史课程记录
	 * */
	@Override
	public List<CourseDetail> getHistoryCourseDetailList(Integer teacherId) {
		String sql = "SELECT courseid, coursename, info, types, price, imgurl, courserecordid, starttime, endtime, closetime, signcount " + 
				 	 "FROM course c, course_record cr, engclass e" + 
				 	 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid AND endtime < NOW()";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	/*
	 * 获取所有课程记录
	 * */
	@Override
	public List<CourseDetail> getAllCourseDetailList(Integer teacherId) {
		String sql = "SELECT courseid, coursename, info, types, price, imgurl, courserecordid, starttime, endtime, closetime, signcount " + 
					 "FROM course c, course_record cr, engclass e" + 
					 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid ADN cr.courseid = c.courseid";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	@Override
	public List<CourseDetail> getUserNowCourseDetailList(Integer userid) {
		String sql  = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
					  "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = 40000 AND NOW() BETWEEN starttime AND endtime";
		return this.queryForListEx(sql, CourseDetail.class, userid);
	}

	@Override
	public List<CourseDetail> getUserHistoryCourseDetailList(Integer userid) {
		String sql = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
				  	 "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = 40000";
		return this.queryForListEx(sql, CourseDetail.class, userid);
	}

	@Override
	public List<CourseDetail> getUserAllCourseDetailList(Integer userid) {
		String sql = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
				  "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = 40000 AND endtime < NUW()";
		return this.queryForListEx(sql,CourseDetail.class,userid);
	}
	
	
	
	
}
