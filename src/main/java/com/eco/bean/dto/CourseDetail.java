package com.eco.bean.dto;

import java.io.Serializable;
import java.util.Date;

/*
 * date:   2018年4月19日 下午3:43:49
 * author: Shixiaodong
 */
public class CourseDetail implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer courseId;
	
	private String courseName;
	
	private String info;
	
	private String types;
	
	private Float price;

	private String imgUrl;
	
	private Integer courseRecordId;

	private Date startTime;
	
	private Date endTime;
	
	private Date closeTime;
	
	private Integer signCount;
	
	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
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

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public Integer getCourseRecordId() {
		return courseRecordId;
	}

	public void setCourseRecordId(Integer courseRecordId) {
		this.courseRecordId = courseRecordId;
	}

	public Integer getSignCount() {
		return signCount;
	}

	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	
	
	
}
