package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.dao.EngclassDao;

/*
 * date:   2018年4月20日 下午10:32:20
 * author: Shixiaodong
 */
public class EngclassDaoImpl extends AbstractBaseDao<Engclass> implements EngclassDao {

	@Override
	public List<EngclassDetail> getEngclassList(Integer teacherId) {
		String sql = "SELECT e.classid, classname, usercount, classroom, t.teacherid, t.teachername, c.courseid, coursename, cr.courserecordid " +
					 "FROM course c LEFT JOIN  course_record cr ON c.courseid = cr.courseid LEFT JOIN engclass e ON cr.courserecordid = e.courserecordid LEFT JOIN teacher t ON e.teacherid = t.teacherid " +
					 "WHERE t.teacherid = ?;";
		return this.queryForListEx(sql, EngclassDetail.class, teacherId);
	}

	
	
	
	

}
