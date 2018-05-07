package com.eco.bean.model;

import java.io.Serializable;

/*
 * date:   2018年4月19日 下午8:44:02
 * author: Shixiaodong
 */
public class UserAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String password;
	
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
