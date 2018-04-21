package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.CourseRecord;
import com.eco.dao.CourseRecordDao;

public class CourseRecordDaoImpl extends AbstractBaseDao<CourseRecord> implements CourseRecordDao {

	@Override
	public boolean createCourseRecord(CourseRecord record) {
		String sql = "INSERT INTO course_record(courseid,starttime,endtime,closetime,signcount) VALUES(?,?,?,?,?)";
		int num = this.insert(sql,record.getCourseId(),record.getStartTime(),record.getEndTime(),record.getCloseTime(),record.getSignCount());
		return num ==1;
	}
	
	
	/*
	 *获取正在等待报名的课程记录
	 */
	@Override
	public List<CourseDetail> queryNowCoureseRecord(Integer courseid) {
		String sql = "SELECT t1.*,t2.coursename,t2.info,TYPES,price,imgurl FROM Course_record t1 LEFT JOIN course t2 ON t1.courseid = t2.courseid " + 
					 "LEFT JOIN engclass t3 ON t1.courserecordid = t3.courserecordid " + 
					 "WHERE closetime < NOW()";
		return this.queryForListEx(sql, CourseDetail.class);
	}
	
	
	
	
}
