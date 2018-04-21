package com.eco.bean.dto;

import java.util.Date;

public class BackInfoDetail {
	
	
	private Integer teacherId;
	
	private Integer userId;
	
	private Integer classId;
	
	private Date backTime;
	
	private String backInfo;
	
	private String userName;
	
	private String teacherName;
	
	private String className;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
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

	public Date getBackTime() {
		return backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public String getBackInfo() {
		return backInfo;
	}

	public void setBackInfo(String backInfo) {
		this.backInfo = backInfo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
	
}
