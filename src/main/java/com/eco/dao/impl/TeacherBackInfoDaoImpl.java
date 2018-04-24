package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.UserClass;
import com.eco.dao.TeacherBackInfoDao;

public class TeacherBackInfoDaoImpl extends AbstractBaseDao<TeacherBackInfo> implements TeacherBackInfoDao {

	@Override
	public List<BackInfoDetail> queryBackInfoByUserClass(Integer classid,Integer userid) {
		String sql = "SELECT t1.teacherbackid, t1.teacherid,t1.userid,t1.classid,backtime,backinfo,t3.username,t4.teachername,t2.classname\r\n" + 
					 "FROM teacher_back_info t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid\r\n" + 
					 "LEFT JOIN USER t3 ON t1.userid = t3.userid LEFT JOIN teacher t4 ON t4.teacherid = t1.teacherid\r\n" + 
					 "WHERE t1.userid = ? AND t1.classid = ?";
		List<BackInfoDetail> backInfoDetailList = queryForListEx(sql, BackInfoDetail.class, userid,classid);
		return backInfoDetailList;
	}

	@Override
	public List<BackInfoDetail> getBackInfoByTeacherIdAndClassId(Integer teacherId, Integer engclassId) {
		String sql = "SELECT tbi.teacherbackid, t.teacherid, u.userid, e.classid, classname, backtime, backinfo, username, teachername " + 
					 "FROM teacher t LEFT JOIN teacher_back_info tbi ON t.teacherid = tbi.teacherid " +
					 "LEFT JOIN engclass e ON tbi.classid = e.classid LEFT JOIN user u ON tbi.userid = u.userid " + 
					 "WHERE t.teacherid = ? AND e.classid = ?;";
		return this.queryForListEx(sql, BackInfoDetail.class, teacherId, engclassId);
	}

	@Override
	public Boolean insertBackInfo(TeacherBackInfo teacherBackInfo) {
		String sql = "INSERT INTO teacher_back_info(teacherId, userid, classid, backtime, backinfo) VALUES(?, ?, ?, ?, ?);";
		return 1 == this.update(sql, teacherBackInfo.getTeacherId(), teacherBackInfo.getUserId(), teacherBackInfo.getClassId(), teacherBackInfo.getBackTime(), teacherBackInfo.getBackInfo());
	}
	
	


}
