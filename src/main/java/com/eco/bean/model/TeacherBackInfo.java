package com.eco.bean.model;

import java.io.Serializable;
import java.util.Date;

/*
 * date:   2018年4月19日 下午8:42:00
 * author: Shixiaodong
 */
public class TeacherBackInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer teacherBackInfoId;
	
	private Date backTime;
	
	private String backInfo;
	
	private User user;
	
	private Engclass engclass;
	
	private Teacher teacher;

	public Integer getTeacherBackInfoId() {
		return teacherBackInfoId;
	}

	public void setTeacherBackInfoId(Integer teacherBackInfoId) {
		this.teacherBackInfoId = teacherBackInfoId;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Engclass getEngclass() {
		return engclass;
	}

	public void setEngclass(Engclass engclass) {
		this.engclass = engclass;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
}
