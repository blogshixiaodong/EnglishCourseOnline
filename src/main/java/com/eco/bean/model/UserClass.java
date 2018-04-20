package com.eco.bean.model;

import java.io.Serializable;

/*
 * date:   2018年4月19日 下午8:48:37
 * author: Shixiaodong
 */
public class UserClass implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private Integer classId;
	
	private Integer isAssigned;

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

	public Integer getIsAssigned() {
		return isAssigned;
	}

	public void setIsAssigned(Integer isAssigned) {
		this.isAssigned = isAssigned;
	}
	
	

}
