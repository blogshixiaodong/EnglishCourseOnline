package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.CourseRecord;
import com.eco.dao.CourseRecordDao;

public class CourseRecordDaoImpl extends AbstractBaseDao<CourseRecord> implements CourseRecordDao {

	@Override
	public boolean insert(CourseRecord record) {
		String sql = "INSERT INTO course_record(courseid,starttime,endtime,closetime,signcount) VALUES(?,?,?,?,?)";
		int num = this.update(sql,record.getCourseId(),record.getStartTime(),record.getEndTime(),record.getCloseTime(),record.getSignCount());
		return num == 1;
	}
	
	@Override
	public List<CourseDetail> selectNowCoureseRecordByCourseId(Integer courseid) {
		String sql = "SELECT t1.*,t2.coursename,t2.info,TYPES,price,imgurl FROM Course_record t1 LEFT JOIN course t2 ON t1.courseid = t2.courseid " + 
					 "LEFT JOIN engclass t3 ON t1.courserecordid = t3.courserecordid " + 
					 "WHERE closetime < NOW()";
		return this.queryForListEx(sql, CourseDetail.class);
	}

	@Override
	public boolean updateCourseRecordSignCount(Integer crid) {
		String sql = "UPDATE course_record SET signcount = signcount - 1 WHERE courserecordid = ? ";
		return this.update(sql,crid) == 1;
	}
	
}
