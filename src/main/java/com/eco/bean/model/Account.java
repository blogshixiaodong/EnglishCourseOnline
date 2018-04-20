package com.eco.bean.model;

import java.io.Serializable;

/*
 * date:   2018年4月19日 下午8:44:02
 * author: Shixiaodong
 */
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	private String password;
	
	private Integer roleId;
	
	private String role;

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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
