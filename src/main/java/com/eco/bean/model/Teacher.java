package com.eco.bean.model;

import java.io.Serializable;

/*
 * date:   2018年4月19日 上午9:37:43
 * author: Shixiaodong
 */
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer teacherId;
	
	private String idCard;
	
	private String teacherName;
	
	private String sex;
	
	private int age;
	
	private String phone;
	
	private String address;
	
	private String imgUrl;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	
	
	
	
	 
	
}
