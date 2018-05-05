package com.eco.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.server.BusinessServer;
import com.eco.server.CourseServer;
import com.eco.server.EngclassServer;
import com.eco.server.TeacherServer;
import com.eco.server.impl.BusinessServerImpl;
import com.eco.server.impl.CourseServerImpl;
import com.eco.server.impl.EngclassServerImpl;
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
	
	private EngclassServer engclassServer = new EngclassServerImpl();
	
	private Course course;
	
	private PageContainer pageContainer;
	
	private BusinessServer businessServer = new BusinessServerImpl();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	
	private String jsonResult = "";
	
	public String findAllCourse() {
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
	
	public String createCourse() {
		//判断商家账号
		
		if(businessServer.addCourse(course)) {
			return SUCCESS; 
		}
		return ERROR;
	}
	
	
	public String findAllCourseList() {
		List<Course> courseList =businessServer.queryqueryAllCourseList(pageContainer) ;
		request.setAttribute("courseList",courseList);
		request.setAttribute("pageContainer", pageContainer);
		
		return SUCCESS;
	}

	public String findEngclassListByCourseId() {
		List<Engclass> engclassList = engclassServer.queryEnglclassListByCourseId(getCourseId());
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	public String findEngclassByEngclassId() {
		EngclassDetail engclass = engclassServer.queryEngclassDetailByEngclasId(getEngclassId());
		jsonResult = JSONObject.fromObject(engclass).toString();
		return Action.SUCCESS;
	}
	
	
	
	//parameter内的参数
	private Integer getEngclassId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("engclassId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	
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
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

}