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

	@Override
	public List<CourseDetail> selectTeacherNowCourseDetailListByTeacherId(Integer teacherId) {
		String sql = "SELECT c.courseid, coursename, info, types, price, imgurl, cr.courserecordid, starttime, endtime, closetime, signcount " + 
				 "FROM course c, course_record cr, engclass e " + 
				 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid AND NOW() between starttime AND endtime ORDER BY starttime DESC;";
		
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	@Override
	public List<CourseDetail> selectTeacherIdHistoryCourseDetailListByTeacherId(Integer teacherId) {
		String sql = "SELECT c.courseid, coursename, info, types, price, imgurl, cr.courserecordid, starttime, endtime, closetime, signcount " + 
				 	 "FROM course c, course_record cr, engclass e " + 
				 	 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid AND endtime < NOW() ORDER BY starttime DESC;";
		
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}

	@Override
	public List<CourseDetail> selectAllCourseDetailListByTeacherId(Integer teacherId) {
		String sql = "SELECT c.courseid, coursename, info, types, price, imgurl, cr.courserecordid, starttime, endtime, closetime, signcount " + 
					 "FROM course c, course_record cr, engclass e " + 
					 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid ORDER BY starttime DESC;";
		return this.queryForListEx(sql, CourseDetail.class, teacherId);
	}
	
	@Override
	public int countAllCourseDetailByTeacherId(Integer teacherId) {
		String sql = "SELECT count(*) FROM course c, course_record cr, engclass e " + 
					 "WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid AND cr.courseid = c.courseid;";
		return Integer.parseInt(this.queryForValue(sql, teacherId).toString());
	}
	
	@Override
	public int countNowCourseDetailByTeacherId(Integer teacherId) {
		String sql = "SELECT COUNT(*) FROM course c, course_record cr, engclass e WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid "
				+ "AND cr.courseid = c.courseid AND NOW() between starttime AND endtime ORDER BY starttime DESC";
		
		return Integer.parseInt(this.queryForValue(sql, teacherId).toString());
	}
	
	
	@Override
	public int countHistoryCourseDetailByTeacherId(Integer teacherId) {
		String sql = "SELECT COUNT(*) FROM course c, course_record cr, engclass e WHERE e.teacherid = ? AND e.courserecordid = cr.courserecordid "
				+ "AND cr.courseid = c.courseid AND endtime < NOW() ORDER BY starttime DESC";
	
		return Integer.parseInt(this.queryForValue(sql, teacherId).toString());
	}
	
	
	
	@Override
	public int countAllCourseDetailByUserId(Integer userId) {
		String sql = "SELECT COUNT(*) FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
					 "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = ?";
		
		return Integer.parseInt(this.queryForValue(sql, userId).toString());
	}
	
	@Override
	public int countNowCourseDetailByUserId(Integer userId) {
		String sql = "SELECT COUNT(*) FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
				 	 "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = ? AND NOW() BETWEEN starttime AND endtime";
	
	return Integer.parseInt(this.queryForValue(sql, userId).toString());
	}
	
	
	@Override
	public int countHistoryCourseDetailByUserId(Integer userId) {
		String sql = "SELECT COUNT(*) FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
			  	 	 "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = ? AND endtime < NOW()";
		return Integer.parseInt(this.queryForValue(sql, userId).toString());
	}
	
	
	@Override
	public List<CourseDetail> selectUserNowCourseDetailListByUserId(Integer userid) {
		String sql  = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
					  "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = ? AND NOW() BETWEEN starttime AND endtime";
		return this.queryForListEx(sql, CourseDetail.class, userid);
	}

	@Override
	public List<CourseDetail> selectUserHistoryCourseDetailListByUserId(Integer userid) {
		String sql = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
				  	 "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = ? AND endtime < NOW()";
		return this.queryForListEx(sql, CourseDetail.class, userid);
	}

	@Override
	public List<CourseDetail> selectUserAllCourseDetailListByUserId(Integer userid) {
		String sql = "SELECT t4.*,starttime,t3.courserecordid, endtime, closetime, signcount FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid LEFT JOIN course_record t3 " + 
				  "ON t2.courserecordid = t3.courserecordid LEFT JOIN course t4 ON t3.courseid = t4.courseid WHERE t1.userid = ? ";
		return this.queryForListEx(sql,CourseDetail.class,userid);
	}
	
	@Override
	protected String beforeQueryForList(String sql) {
		if(isPaging == false || pageContainer == null) {
			return sql;
		}
		String limitSql = sql.replace(";", "");
		limitSql = limitSql + " limit " + ((pageContainer.getCurrentPageNo() - 1) * pageContainer.getPageSize()) + "," + pageContainer.getPageSize() + ";";
		return limitSql;
	}
	
	@Override
	protected String beforeQueryForListEx(String sql) {
		if(!isPaging && pageContainer != null) {
			return sql;
		}
		String limitSql = sql.replace(";", "");
		limitSql = sql + " limit " + ((pageContainer.getCurrentPageNo() - 1) * pageContainer.getPageSize()) + " , " + pageContainer.getPageSize();
		return limitSql;
	}

	

	

	

	
	
}
