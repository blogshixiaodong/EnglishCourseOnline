package com.eco.bean.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/*
 * date:   2018年4月19日 下午8:36:33
 * author: Shixiaodong
 */
public class Engclass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer engclassId;
	
	private String engclassName;
	
	private Integer courseRecordId;
	
	private Integer teacherId;

	private Integer userCount;
	
	private String classRoom;
	
	private Date attendTime;

	private CourseRecord courseRecord;
	
	private Teacher teacher;
	
	private Set<TeacherBackInfo> teacherBackInfoSet;
	
	private Set<User> userSet;
	
	private Set<UserBackInfo> userBackInfoSet;
	
	private Set<TimeSheet> timeSheetSet;

	public Integer getEngclassId() {
		return engclassId;
	}

	public void setEngclassId(Integer engclassId) {
		this.engclassId = engclassId;
	}

	public String getEngclassName() {
		return engclassName;
	}

	public void setEngclassName(String engclassName) {
		this.engclassName = engclassName;
	}

	public Integer getCourseRecordId() {
		return courseRecordId;
	}

	public void setCourseRecordId(Integer courseRecordId) {
		this.courseRecordId = courseRecordId;
	}

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getUserCount() {
		return userCount;
	}

	public void setUserCount(Integer userCount) {
		this.userCount = userCount;
	}

	public String getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}

	public Date getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(Date attendTime) {
		this.attendTime = attendTime;
	}

	public CourseRecord getCourseRecord() {
		return courseRecord;
	}

	public void setCourseRecord(CourseRecord courseRecord) {
		this.courseRecord = courseRecord;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Set<TeacherBackInfo> getTeacherBackInfoSet() {
		return teacherBackInfoSet;
	}

	public void setTeacherBackInfoSet(Set<TeacherBackInfo> teacherBackInfoSet) {
		this.teacherBackInfoSet = teacherBackInfoSet;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Set<UserBackInfo> getUserBackInfoSet() {
		return userBackInfoSet;
	}

	public void setUserBackInfoSet(Set<UserBackInfo> userBackInfoSet) {
		this.userBackInfoSet = userBackInfoSet;
	}

	public Set<TimeSheet> getTimeSheetSet() {
		return timeSheetSet;
	}

	public void setTimeSheetSet(Set<TimeSheet> timeSheetSet) {
		this.timeSheetSet = timeSheetSet;
	}

}
