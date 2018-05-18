package com.eco.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.model.TeacherAccount;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.server.BusinessServer;
import com.eco.server.impl.BusinessServerImpl;
import com.eco.util.JsonUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

/*
 * date:   2018年5月5日 下午16:41:15
 * author: Shixiaodong
 */
public class BusinessAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private BusinessServer businessServer = new BusinessServerImpl();
	
	private Course course;
	
	private Teacher teacher;
	
	private PageContainer pageContainer;
	
	private CourseRecord courseRecord;
	
	private Engclass engclass;
	
	private Integer oldEngclassId1;
	private Integer oldEngclassId2;
	private Integer userNum1;
	private Integer userNum2;
	

	private HttpServletRequest request = ServletActionContext.getRequest();
	
	
	private String jsonResult = "";
	
	public String findNowCourse() {
		PageContainer<Course> corseList = businessServer.queryNowCourseList(pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course", "engclassSet");
		jsonResult = JSONObject.fromObject(corseList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findAllCourse() {
		PageContainer<Course> corseList = businessServer.queryAllCourseList(pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course", "engclassSet");
		jsonResult = JSONObject.fromObject(corseList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String createCourse() {
		//判断商家账号
		if(course != null) {
			businessServer.saveCourse(course);
			return Action.SUCCESS;
		}
		return Action.ERROR;
	}
	
	public String findNowCourseIdAndNameList() {
		List<Course> courseList = businessServer.queryNowCourseIdAndNameList();
		jsonResult = JSONArray.fromObject(courseList).toString();
		return Action.SUCCESS;
	}
	
	public String findAllTeacherIdAndNameList() {
		List<Teacher> courseList = businessServer.queryAllTeacherIdAndNameList();
		jsonResult = JSONArray.fromObject(courseList).toString();
		return Action.SUCCESS;
	}
	
	public String findAllEngclassIdAndNameList() {
		List<Engclass> engclassList = businessServer.queryAllEngclassIdAndNameList();
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	public String findCourseByCourseId() {
		Course destCourse = businessServer.queryCourseByCourseId(course.getCourseId());
		JsonConfig jsonConfig = JsonUtils.JsonExclude("courseRecordSet");
		jsonResult = JSONObject.fromObject(destCourse, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findTeacherByTeacherId() {
		Teacher destTeacher = businessServer.queryTeacherByTeacherId(teacher.getTeacherId());
		JsonConfig jsonConfig = JsonUtils.JsonExclude("teacherAccount", "engclassSet");
		jsonResult = JSONObject.fromObject(destTeacher, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findEngclassByEngclassId() {
		Engclass destEngclass = businessServer.queryEngclassByEngclasId(engclass.getEngclassId());
		JsonConfig jsonConfig = JsonUtils.JsonExclude("courseRecordSet", "engclassSet", "teacherAccount", "teacherAccount", "userSet", "teacherBackInfoSet", "userBackInfoSet", "timeSheetSet");
		jsonResult = JSONObject.fromObject(destEngclass, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	//创建班级，课程记录
	public String createEngclass() {
		courseRecord.setCourse(course);
		engclass.setCourseRecord(courseRecord);
		engclass.setTeacher(teacher);
		businessServer.saveEngclass(engclass);
		return Action.SUCCESS;
	}
	
	public String mergeEngclass() {
		
//		EngclassServer engclassServer = new EngclassServerImpl();
//		
//		int courseRecordId = engclassServer.queryCourseRecordIdByEngclassId(oldEngclassId1);
//		
//		//engclass.setCourseRecordId(courseRecordId);
//		engclass.setUserCount(userNum1 + userNum2);
//		int engclassId = new Long(engclassServer.create(engclass)).intValue();
//		
//		//教师无法修改
//		UserServer userver = new UserServerImpl();
//		userver.mergeEngclass(oldEngclassId1, oldEngclassId2, engclassId);
		
		return SUCCESS;
	}
	
	
	public String splitEngclass() {
		Object engclssList = ServletActionContext.getRequest().getParameterMap().get("engclassList");
		JSONArray array = JSONArray.fromObject(engclssList);
		List<Engclass> engclassList = null;
		if(array != null && array.size() > 0) {
			engclassList = (List<Engclass>)((List<Engclass>)array.toCollection(array, Engclass.class)).get(0);
		}
		
		businessServer.saveSplitEngclass(engclassList.get(0));
		businessServer.saveEngclass(engclassList.get(1));
		return Action.SUCCESS;
	}
	
	
	//数据库两个主码修改 user_class
	//teacher 中有一个页面有bug
	public String findAllCourseList() {

//		List<Course> courseList =businessServer.queryqueryAllCourseList(pageContainer) ;
//		request.setAttribute("courseList",courseList);
//		request.setAttribute("pageContainer", pageContainer);
//		
		return SUCCESS;
	}

	public String findEngclassListByCourseId() {
//		List<Engclass> engclassList = engclassServer.queryEnglclassListByCourseId(getCourseId());
//		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	public String businessLogin() {
		return Action.SUCCESS;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public PageContainer getPageContainer() {
		return pageContainer;
	}
	
	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;
	}
	
	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public CourseRecord getCourseRecord() {
		return courseRecord;
	}

	public void setCourseRecord(CourseRecord courseRecord) {
		this.courseRecord = courseRecord;
	}

	public Engclass getEngclass() {
		return engclass;
	}

	public void setEngclass(Engclass engclass) {
		this.engclass = engclass;
	}

	public Integer getOldEngclassId1() {
		return oldEngclassId1;
	}

	public void setOldEngclassId1(Integer oldEngclassId1) {
		this.oldEngclassId1 = oldEngclassId1;
	}

	public Integer getOldEngclassId2() {
		return oldEngclassId2;
	}

	public void setOldEngclassId2(Integer oldEngclassId2) {
		this.oldEngclassId2 = oldEngclassId2;
	}

	public Integer getUserNum1() {
		return userNum1;
	}

	public void setUserNum1(Integer userNum1) {
		this.userNum1 = userNum1;
	}

	public Integer getUserNum2() {
		return userNum2;
	}

	public void setUserNum2(Integer userNum2) {
		this.userNum2 = userNum2;
	}

}