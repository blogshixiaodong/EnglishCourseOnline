package com.eco.bean.model;

import java.io.Serializable;
import java.util.Date;

/*
 * date:   2018年4月19日 下午8:39:38
 * author: Shixiaodong
 */
public class UserBackInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userBackInfoId;
	
	private Date backTime;
	
	private String backInfo;
	
	private Engclass engclass;
	
	private User user;
	
	private Teacher teacher;

	public Integer getUserBackInfoId() {
		return userBackInfoId;
	}

	public void setUserBackInfoId(Integer userBackInfoId) {
		this.userBackInfoId = userBackInfoId;
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

	public Engclass getEngclass() {
		return engclass;
	}

	public void setEngclass(Engclass engclass) {
		this.engclass = engclass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	

}
