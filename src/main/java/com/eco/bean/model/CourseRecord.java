package com.eco.bean.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/*
 * date:   2018年4月19日 下午8:30:43
 * author: Shixiaodong
 */
public class CourseRecord implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Integer courseRecordId;
	
	private Date startTime;
	
	private Date endTime;
	
	private Date closeTime;
	
	private Integer signCount;
	
	private Course course;
	
	private Set<Engclass> engclassSet = new HashSet<Engclass>();
	

	public Integer getCourseRecordId() {
		return courseRecordId;
	}

	public void setCourseRecordId(Integer courseRecordId) {
		this.courseRecordId = courseRecordId;
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

	public Integer getSignCount() {
		return signCount;
	}

	public void setSignCount(Integer signCount) {
		this.signCount = signCount;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<Engclass> getEngclassSet() {
		return engclassSet;
	}

	public void setEngclassSet(Set<Engclass> engclassSet) {
		this.engclassSet = engclassSet;
	}
	
	
	
}
