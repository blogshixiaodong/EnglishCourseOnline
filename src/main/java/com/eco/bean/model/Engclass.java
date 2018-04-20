package com.eco.bean.model;

import java.io.Serializable;

/*
 * date:   2018年4月19日 下午8:36:33
 * author: Shixiaodong
 */
public class Engclass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer classId;
	
	private Integer teacherId;
	
	private Integer courseRecordId;
	
	private String className;
	
	private Integer userCount;
	
	private String classRoom;

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getCourseRecordId() {
		return courseRecordId;
	}

	public void setCourseRecordId(Integer courseRecordId) {
		this.courseRecordId = courseRecordId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	
	
	
}
