package com.eco.bean.model;

import java.io.Serializable;
import java.util.Date;

/*
 * date:   2018年4月19日 下午8:42:00
 * author: Shixiaodong
 */
public class TeacherBackInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer teacherBackId;
	
	private Integer teacherId;
	
	private Integer userId;
	
	private Integer classId;
	
	private Date backTime;
	
	private String backInfo;

	public Integer getTeacherBackId() {
		return teacherBackId;
	}

	public void setTeacherBackId(Integer teacherBackId) {
		this.teacherBackId = teacherBackId;
	}

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

	

}
