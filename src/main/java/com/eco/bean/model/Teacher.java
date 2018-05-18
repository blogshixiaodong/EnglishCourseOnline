package com.eco.bean.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
 * date:   2018年4月19日 上午9:37:43
 * author: Shixiaodong
 */
public class Teacher implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer teacherId;
	
	private String teacherName;
	
	private String idCard;
	
	private String sex;
	
	private Integer age;
	
	private String phone;
	
	private String address;
	
	private String imgUrl;
	
	private TeacherAccount teacherAccount;
	
	private Set<Engclass> engclassSet = new HashSet<Engclass>();
	
	public Teacher() { }
	
	public Teacher(Integer teacherId, String teacherName) {
		this.teacherId = teacherId;
		this.teacherName = teacherName;
	}
	
	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
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

	public TeacherAccount getTeacherAccount() {
		return teacherAccount;
	}

	public void setTeacherAccount(TeacherAccount teacherAccount) {
		this.teacherAccount = teacherAccount;
	}
	
	
}
