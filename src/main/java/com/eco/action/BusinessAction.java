package com.eco.action;

import java.util.List;
import java.util.Map;

import com.eco.bean.model.Course;
import com.eco.bean.model.Teacher;
import com.eco.server.CourseServer;
import com.eco.server.TeacherServer;
import com.eco.server.impl.CourseServerImpl;
import com.eco.server.impl.TeacherServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * date:   2018年5月5日 下午16:41:15
 * author: Shixiaodong
 */
public class BusinessAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private CourseServer courseServer = new CourseServerImpl();
	
	private TeacherServer teacherServer = new TeacherServerImpl();
	
	private String jsonResult = "";
	
	public String findAllCourseList() {
		List<Course> corseList = courseServer.queryAllCourse();
		jsonResult = JSONArray.fromObject(corseList).toString();
		return Action.SUCCESS;
	}
	
	public String findCourseByCourseId() {
		Course destCourse = courseServer.queryCourseByCourseId(getCourseId());
		jsonResult = JSONObject.fromObject(destCourse).toString();
		
		return Action.SUCCESS;
	}
	
	public String findAllTeacherList() {
		List<Teacher> teacherList = teacherServer.queryAllTeacher();
		jsonResult = JSONArray.fromObject(teacherList).toString();
		return Action.SUCCESS;
	}
	
	
	public String findTeacherByTeacherId() {
		Teacher teacher = teacherServer.queryTeacher(getTeacherId());
		jsonResult = JSONObject.fromObject(teacher).toString();
		return Action.SUCCESS;
	}
	
	//创建班级，课程记录
	public String createEngclass() {
		
		return Action.SUCCESS;
	}
	
	
	//parameter内的参数
	private Integer getCourseId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("courseId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	
	private Integer getTeacherId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("teacherId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	

	
	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	
}
