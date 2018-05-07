package com.eco.bean.model;

import java.io.Serializable;
import java.util.Set;

/*
 * date:   2018年4月19日 下午8:52:52
 * author: Shixiaodong
 */
public class Course implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer courseId;
	
	private String courseName;
	
	private String info;
	
	private String types;
	
	private Float price;
	
	private String imgUrl;

	private Set<CourseRecord> courseRecordSet;

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Set<CourseRecord> getCourseRecordSet() {
		return courseRecordSet;
	}

	public void setCourseRecordSet(Set<CourseRecord> courseRecordSet) {
		this.courseRecordSet = courseRecordSet;
	}
	
}
