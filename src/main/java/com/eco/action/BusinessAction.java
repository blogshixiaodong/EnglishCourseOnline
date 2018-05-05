package com.eco.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.model.Course;
import com.eco.bean.model.PageContainer;
import com.eco.server.BusinessServer;
import com.eco.server.impl.BusinessServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class BusinessAction extends ActionSupport{
	
	private Course course;
	
	private PageContainer pageContainer;
	
	private BusinessServer businessServer = new BusinessServerImpl();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	
	
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
	
	
	
	
	
}
