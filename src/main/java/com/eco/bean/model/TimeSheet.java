package com.eco.bean.model;

import java.io.Serializable;
import java.util.Date;

/*
 * date:   2018年4月19日 下午8:50:49
 * author: Shixiaodong
 */
public class TimeSheet implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer timeSheetId;
	
	private Integer userId;
	
	private Integer classId;
	
	private Date recordTime;
	
	private String sheetInfo;

	public Integer getTimeSheetId() {
		return timeSheetId;
	}

	public void setTimeSheetId(Integer timeSheetId) {
		this.timeSheetId = timeSheetId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Date getRecordTime() {
		return recordTime;
	}

	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	public String getSheetInfo() {
		return sheetInfo;
	}

	public void setSheetInfo(String sheetInfo) {
		this.sheetInfo = sheetInfo;
	}
	
	
	
}
