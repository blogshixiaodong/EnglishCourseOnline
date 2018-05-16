package com.eco.bean.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/*
 * date:   2018年4月19日 下午8:36:33
 * author: Shixiaodong
 */
public class Engclass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer engclassId;
	
	private String engclassName;

	private Integer userCount;
	
	private String classRoom;
	
	private Integer day;
	
	private Integer attendTime;

	private CourseRecord courseRecord;
	
	private Teacher teacher;
	
	private Set<User> userSet = new HashSet<User>();
	
	private Set<TeacherBackInfo> teacherBackInfoSet = new HashSet<TeacherBackInfo>() ;
	
	private Set<UserBackInfo> userBackInfoSet = new HashSet<UserBackInfo>() ;
	
	private Set<TimeSheet> timeSheetSet = new HashSet<TimeSheet>() ;

	public Engclass() {}
	
	public Engclass(Integer engclassId, String engclassName) {

		this.engclassId = engclassId;
		this.engclassName = engclassName;
	}
	
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

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getAttendTime() {
		return attendTime;
	}

	public void setAttendTime(Integer attendTime) {
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

	public Set<User> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Set<TeacherBackInfo> getTeacherBackInfoSet() {
		return teacherBackInfoSet;
	}

	public void setTeacherBackInfoSet(Set<TeacherBackInfo> teacherBackInfoSet) {
		this.teacherBackInfoSet = teacherBackInfoSet;
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
