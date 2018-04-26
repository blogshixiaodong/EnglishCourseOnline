package com.eco.dao;

import java.util.Date;
import java.util.List;

import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.TimeSheet;

/*
 * date:   2018年4月20日 下午11:07:27
 * author: Shixiaodong
 */
public interface TimeSheetDao extends BaseDao<TimeSheet> {
	
	public abstract List<TimeSheetDetail> getTimeSheetDetailByEnclass(Integer engclass, Date date);
	
	
	/** 
	* @Description: 通过用户id和班级id,返回用户所在班级的考勤记录 
	* @param userid
	* @param engclass
	* @return List<TimeSheetDao>
	*/ 
	public List<TimeSheetDetail> getTimeSheetByUser(Integer userid,Integer engclass);
	
	
	/** 
	* @Description: 根据classid和日期查询该班级的考勤记录 
	* @param classId
	* @param date
	* @return List<TimeSheetDetail>
	*/ 
	public List<TimeSheetDetail> queryUserTimeSheetByClassIdAndTime(Integer classId,Date date);
	
	
	
	/** 
	* @Description: 通过考勤对象创建考勤记录 
	* @param timeSheet
	* @return boolean
	*/ 
	public boolean createTimeSheet(TimeSheet timeSheet);
	
	
}
