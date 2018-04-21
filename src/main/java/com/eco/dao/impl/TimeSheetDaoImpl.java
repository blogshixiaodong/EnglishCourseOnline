package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.TimeSheet;
import com.eco.dao.TimeSheetDao;

/*
 * date:   2018年4月20日 下午11:14:45
 * author: Shixiaodong
 */
public class TimeSheetDaoImpl extends AbstractBaseDao<TimeSheet> implements TimeSheetDao {

	@Override
	public List<TimeSheetDetail> getTimeSheetDetail(Integer engclass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TimeSheetDetail> getTimeSheetByUser(Integer userid, Integer classid) {
		String sql = "SELECT t5.username,t2.userid,t2.classid,t2.recordtime,t2.sheetinfo,t4.teachername,t4.teacherid,t3.classname,t3.classroom "+
					"FROM user_class t1 LEFT JOIN time_sheet t2 ON t1.`classid` = t2.`classid` AND t1.userid = t2.userid " + 
					"LEFT JOIN  engclass t3 ON t1.classid = t3.classid LEFT JOIN  Teacher t4 ON t3.teacherid = t4.teacherid " + 
					"LEFT JOIN USER t5 ON t5.userid = t1.userid WHERE t1.`classid` = ? AND t1.`userid`= ?";
		
		List<TimeSheetDetail> timeSheetList = queryForListEx(sql, TimeSheetDetail.class, userid,classid);
		
		return timeSheetList;
	}

	@Override
	public boolean createTimeSheet(TimeSheet timeSheet) {
		String sql = "INSERT INTO time_sheet(userid,classid,recordtime,sheetinfo) VALUES(?,?,?,?)";
		int record = insert(sql,timeSheet.getUserId(),timeSheet.getClassId(),timeSheet.getRecordTime(),timeSheet.getSheetInfo());
		return record == 1;
	}
	
	

}
