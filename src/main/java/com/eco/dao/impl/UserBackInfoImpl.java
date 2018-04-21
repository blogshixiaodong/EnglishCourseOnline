package com.eco.dao.impl;

import java.util.List;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.model.UserBackInfo;
import com.eco.bean.model.UserClass;
import com.eco.dao.UserBackInfoDao;

/**
 * @author lenovo
 *
 */
public class UserBackInfoImpl extends AbstractBaseDao<UserBackInfo> implements UserBackInfoDao {

	@Override
	public List<BackInfoDetail> queryBackInfoByUserClass(UserClass userClass) {
		String sql = "SELECT t1.teacherid,t1.userid,t1.classid,backtime,backinfo,t3.username,t4.teachername,t2.classname " + 
					 "FROM user_back_info t1 LEFT JOIN engclass t2 ON t1.classid = t2.classid " + 
					 "LEFT JOIN USER t3 ON t1.userid = t3.userid LEFT JOIN teacher t4 ON t4.teacherid = t1.teacherid " + 
					 "WHERE t1.userid = ? AND t1.classid = ?";
		List<BackInfoDetail> backInfoDetailList = queryForListEx(sql, BackInfoDetail.class, userClass.getUserId(),userClass.getClassId());
		return backInfoDetailList;
	}
	
	
	@Override
	public boolean createUserBackInfo(UserBackInfo backInfo) {
		String sql = "INSERT INTO user_back_info(teacherid,userid,classid,backtime,backinfo) VALUES(?,?,?,?,?)";
		int record = insert(sql, backInfo.getTeacherId(),backInfo.getUserId(),backInfo.getClassId(),backInfo.getBackTime(),backInfo.getBackInfo());
		return record == 1;
	}
	
	
	

}
