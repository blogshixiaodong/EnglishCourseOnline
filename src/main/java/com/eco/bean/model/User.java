package com.eco.bean.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer userId;
	
	private String username;
	
	private String idCard;
	
	private String sex;
	
	private String age;
	
	private String phone;
	
	private String address;

	private String imgUrl;
	
	private Set<Engclass> engclassSet = new HashSet<Engclass>() ;
	
	private Set<TimeSheet> timeSheetSet = new HashSet<TimeSheet>();
	
	private UserAccount userAccount;

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

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<Engclass> getEngclassSet() {
		return engclassSet;
	}

	public void setEngclassSet(Set<Engclass> engclassSet) {
		this.engclassSet = engclassSet;
	}

	public Set<TimeSheet> getTimeSheetSet() {
		return timeSheetSet;
	}

	public void setTimeSheetSet(Set<TimeSheet> timeSheetSet) {
		this.timeSheetSet = timeSheetSet;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
}
