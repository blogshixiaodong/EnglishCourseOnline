package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.UserClass;
import com.eco.dao.TeacherBackInfoDao;

public class TeacherBackInfoDaoImpl extends AbstractBaseDao<TeacherBackInfo> implements TeacherBackInfoDao {

	@Override
	public List<BackInfoDetail> queryBackInfoByUserClass(Integer classid,Integer userid) {
		String sql = "SELECT t1.teacherid,t1.userid,t1.classid,backtime,backinfo,t3.username,t4.teachername,t2.classname\r\n" + 
					 "FROM teacher_back_info t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid\r\n" + 
					 "LEFT JOIN USER t3 ON t1.userid = t3.userid LEFT JOIN teacher t4 ON t4.teacherid = t1.teacherid\r\n" + 
					 "WHERE t1.userid = ? AND t1.classid = ?";
		List<BackInfoDetail> backInfoDetailList = queryForListEx(sql, BackInfoDetail.class, userid,classid);
		return backInfoDetailList;
	}

}
