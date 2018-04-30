package com.eco.dao.impl;

import java.util.Date;
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
	public List<TimeSheetDetail> selectTimeSheetListByEnclassIdAndDate(Integer engclassId, Date date) {
		String sql = "SELECT u.userid, username, e.classid, classname, t.teacherid, teachername, classroom, recordtime, sheetinfo " + 
					 "FROM user u LEFT JOIN user_class uc ON u.userid = uc.userid LEFT JOIN time_sheet ts ON uc.classid = ts.classid " +
					 "LEFT JOIN engclass e ON ts.classid = e.classid LEFT JOIN teacher t ON e.teacherid = t.teacherid " +
					 "WHERE e.classid = ? AND recordtime = ?;";
		return this.queryForListEx(sql, TimeSheetDetail.class, engclassId, date);
	}

	@Override
	public List<TimeSheetDetail> selectTimeSheetByUserIdAndEngclassId(Integer userId,Integer engclassId) {
		String sql = "SELECT t5.username,t2.userid,t2.classid,t2.recordtime,t2.sheetinfo,t4.teachername,t4.teacherid,t3.classname,t3.classroom "+
					"FROM user_class t1 LEFT JOIN time_sheet t2 ON t1.classid = t2.classid AND t1.userid = t2.userid " + 
					"LEFT JOIN  engclass t3 ON t1.classid = t3.classid LEFT JOIN  Teacher t4 ON t3.teacherid = t4.teacherid " + 
					"LEFT JOIN USER t5 ON t5.userid = t1.userid WHERE t1.userid= ? AND t1.classid = ?";
		
		List<TimeSheetDetail> timeSheetList = queryForListEx(sql, TimeSheetDetail.class, userId,engclassId);
		
		return timeSheetList;
	}

	@Override
	public int insert(TimeSheet timeSheet) {
		String sql = "INSERT INTO time_sheet(userid,classid,recordtime,sheetinfo) VALUES(?,?,?,?)";
		int record = update(sql,timeSheet.getUserId(),timeSheet.getClassId(),timeSheet.getRecordTime(),timeSheet.getSheetInfo());
		return record;
	}

	@Override
	public List<TimeSheetDetail> selectTimeSheetByClassIdAndTime(Integer engclassId,Date date) {
		String sql = "SELECT t5.username,t2.userid,t2.classid,t2.recordtime,t2.sheetinfo,t4.teachername,t4.teacherid,t3.classname,t3.classroom " + 
				     "FROM user_class t1 LEFT JOIN time_sheet t2 ON t1.classid = t2.classid AND t1.userid = t2.userid " + 
				     "LEFT JOIN  engclass t3 ON t1.classid = t3.classid LEFT JOIN  Teacher t4 ON t3.teacherid = t4.teacherid " + 
				     "LEFT JOIN USER t5 ON t5.userid = t1.userid " + 
				     "WHERE t1.classid = ? AND STR_TO_DATE(recordtime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d')";
	
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());

		return queryForListEx(sql, TimeSheetDetail.class, engclassId,sqlDate);
	}

	@Override
	public List<TimeSheetDetail> selectTimeSheetByUserIdAndEngclassIdAndTime(Integer userId, Integer engclassId, Date queryDate) {
		String sql = "SELECT t5.username,t2.userid,t2.classid,t2.recordtime,t2.sheetinfo,t4.teachername,t4.teacherid,t3.classname,t3.classroom "+
					 "FROM user_class t1 LEFT JOIN time_sheet t2 ON t1.classid = t2.classid AND t1.userid = t2.userid " + 
					 "LEFT JOIN  engclass t3 ON t1.classid = t3.classid LEFT JOIN  Teacher t4 ON t3.teacherid = t4.teacherid " + 
					 "LEFT JOIN USER t5 ON t5.userid = t1.userid WHERE t1.userid= ? AND t1.classid = ? AND STR_TO_DATE(recordtime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d')";
		
		java.sql.Date sqlDate = new java.sql.Date(queryDate.getTime());
		return queryForListEx(sql, TimeSheetDetail.class, userId,engclassId,sqlDate);
	}
	
	

}
