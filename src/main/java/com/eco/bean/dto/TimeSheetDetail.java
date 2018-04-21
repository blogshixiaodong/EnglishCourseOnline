package com.eco.bean.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * date:   2018年4月20日 上午9:17:37
 * author: Shixiaodong
 */
public class TimeSheetDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String username;
	
	private Integer classId;
	
	private Integer className;
	
	private Integer teacherId;
	
	private String teacherName;
	
	private String classRoom;
	
	private Date recordTime;
	
	private String sheetInfo;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getClassName() {
		return className;
	}

	public void setClassName(Integer className) {
		this.className = className;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
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
