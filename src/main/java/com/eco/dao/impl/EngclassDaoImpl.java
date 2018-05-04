package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.dao.EngclassDao;

import freemarker.core.ReturnInstruction.Return;

/*
 * date:   2018年4月20日 下午10:32:20
 * author: Shixiaodong
 */
public class EngclassDaoImpl extends AbstractBaseDao<Engclass> implements EngclassDao {
	
	@Override
	public void insert(Engclass engclass) {
		String sql = "INSERT INTO engclass(teacherid,courserecordid,classname,usercount,classroom) VALUES(?,?,?,?,?)";
		this.update(sql, engclass.getTeacherId(),engclass.getCourseRecordId(),engclass.getClassName(),
					engclass.getUserCount(),engclass.getClassRoom() );
	}
	
	@Override
	public List<EngclassDetail> selectEngclassListByTeacherId(Integer teacherId) {
		String sql = "SELECT e.classid, classname, usercount, classroom, t.teacherid, t.teachername, c.courseid, coursename, c.imgurl, cr.courserecordid " +
					 "FROM course c LEFT JOIN  course_record cr ON c.courseid = cr.courseid LEFT JOIN engclass e ON cr.courserecordid = e.courserecordid LEFT JOIN teacher t ON e.teacherid = t.teacherid " +
					 "WHERE t.teacherid = ?";
		return this.queryForListEx(sql, EngclassDetail.class, teacherId);
	}
	
	@Override
	public List<EngclassDetail> selectUserAllEngclassListByUserId(Integer userid){
		String sql = "SELECT t2.*,courseName,teacherName,t5.courseid, t5.imgurl FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid\r\n" + 
					 "LEFT JOIN teacher t3 ON t2.teacherid = t3.teacherid LEFT JOIN  course_record t4 ON t2.courserecordid = t4.courserecordid " + 
					 "LEFT JOIN course t5 ON t5.courseid = t4.courseid WHERE t1.userid = ?";
		return this.queryForListEx(sql, EngclassDetail.class, userid);
	}
	
	@Override

	public List<EngclassDetail> selectUserNowEngclassListByUserId(Integer userId) {
		String sql = "SELECT t2.*,courseName,teacherName,t5.courseid, t5.imgurl FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid\r\n" + 
				 	 "LEFT JOIN teacher t3 ON t2.teacherid = t3.teacherid LEFT JOIN  course_record t4 ON t2.courserecordid = t4.courserecordid " + 
				 	 "LEFT JOIN course t5 ON t5.courseid = t4.courseid WHERE t1.userid = ? AND t4.endtime > NOW()";
		return this.queryForListEx(sql, EngclassDetail.class, userId);
	}
	
	@Override
	public int countAllEngclassDetailByUserId(Integer userId) {
		String sql = "SELECT COUNT(*) FROM user_class t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid " + 
				 	 "LEFT JOIN teacher t3 ON t2.teacherid = t3.teacherid LEFT JOIN  course_record t4 ON t2.courserecordid = t4.courserecordid " + 
				 	 "LEFT JOIN course t5 ON t5.courseid = t4.courseid WHERE t1.userid = ?";
		return Integer.parseInt(this.queryForValue(sql, userId).toString());
	}
	
	
	
	
	


	public Engclass selectEngclassByTeacherIdAndEngclassId(Integer teacherId, Integer classId) {

		String sql = "SELECT * FROM engclass WHERE classid = ?";
		return this.queryForObject(sql, classId);
	}

	@Override
	public List<Engclass> selectEngclassListByTeacherIdAndEngclassName(Integer teacherId, String className) {
		String sql = "SELECT * FROM engclass WHERE classname = ?";
		
		return this.queryForList(sql, className);
	}

	@Override
	public EngclassDetail selectEngclassDetailByEngclassId(Integer classId) {
		String sql = "SELECT e.classid, classname, usercount, classroom, t.teacherid, t.teachername, c.courseid, coursename, c.imgurl, cr.courserecordid " +
					 "FROM course c LEFT JOIN  course_record cr ON c.courseid = cr.courseid LEFT JOIN engclass e ON cr.courserecordid = e.courserecordid LEFT JOIN teacher t ON e.teacherid = t.teacherid " +
					 "WHERE e.classid = ?;";
		return this.queryForObjectEx(sql, EngclassDetail.class, classId);
	}

	@Override
	public int countAllUserByEngclassId(Integer engclassId) {
		String sql = "SELECT COUNT(*) FROM course c LEFT JOIN  course_record cr ON c.courseid = cr.courseid LEFT JOIN engclass e ON cr.courserecordid = e.courserecordid " +
				 	 "LEFT JOIN teacher t ON e.teacherid = t.teacherid WHERE e.classid = ?";
		return Integer.parseInt(this.queryForValue(sql, engclassId).toString());
	}

	@Override
	public int countAllEngclassDetailByTeacher(Integer teacherId) {
		String sql = "SELECT COUNT(*) FROM course c LEFT JOIN  course_record cr ON c.courseid = cr.courseid LEFT JOIN engclass e ON cr.courserecordid = e.courserecordid "
				+ "LEFT JOIN teacher t ON e.teacherid = t.teacherid WHERE t.teacherid = ?";
		return Integer.parseInt(this.queryForValue(sql, teacherId).toString());
	}
	
	
	@Override
	public Integer selectTeacherIdByEngclassId(Integer classId) {
		String sql = "SELECT teacherid FROM engclass WHERE classid = ?";
		return (Integer)this.queryForValue(sql, classId);
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
