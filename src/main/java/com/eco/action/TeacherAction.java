package com.eco.action;

import java.util.List;
import java.util.Map;

import com.eco.bean.dto.CourseDetail;
import com.eco.server.TeacherServer;
import com.eco.server.impl.TeacherServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/*
 * date:   2018年4月19日 上午9:43:15
 * author: Shixiaodong
 */
public class TeacherAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private TeacherServer teacherServer = new TeacherServerImpl();
	
	
	
	
	
	public String showNowCourse() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		
		List<CourseDetail> courseDetailList = teacherServer.getNowCourseDetailList(teacherId);
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
		session.put("courseDetailList", courseDetailList);
		return Action.SUCCESS;
	}
	
	public String showHistoryCourse() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<CourseDetail> courseDetailList = teacherServer.getHistoryCourseDetailList(teacherId);
		Map<String, Object> session = (Map<String, Object>) ActionContext.getContext().getSession();
		session.put("courseDetailList", courseDetailList);
		return Action.SUCCESS;
	}
	
	
	public Integer getLoginTeacherId() {
		Map<String, Object> map = ActionContext.getContext().getSession();
		Object id = map.get("teacherId");
		if(id == null || "".equals(id)) {
			return new Integer(50000);
		}
		//未登录测试
		return new Integer(id.toString());
	}
	
	

}
