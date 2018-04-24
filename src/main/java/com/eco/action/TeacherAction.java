package com.eco.action;

import java.util.List;
import java.util.Map;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.server.EngclassServer;
import com.eco.server.TeacherServer;
import com.eco.server.impl.EngclassServerImpl;
import com.eco.server.impl.TeacherServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

/*
 * date:   2018年4月19日 上午9:43:15
 * author: Shixiaodong
 */
public class TeacherAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private TeacherServer teacherServer = new TeacherServerImpl();
	private EngclassServer engclassServer = new EngclassServerImpl();

	private Engclass engclass;

	private String jsonResult = "";
	
	public String showNowCourses() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		
		List<CourseDetail> courseDetailList = teacherServer.getNowCourseDetailList(teacherId);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("courseDetailList", courseDetailList);
		return Action.SUCCESS;
	}
	
	public String showHistoryCourses() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<CourseDetail> courseDetailList = teacherServer.getHistoryCourseDetailList(teacherId);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("courseDetailList", courseDetailList);
		return Action.SUCCESS;
	}
	
	public String showAllCourses() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<CourseDetail> courseDetailList = teacherServer.getAllCourseDetailList(teacherId);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("courseDetailList", courseDetailList);
		return Action.SUCCESS;
	}
	
	public String showEngclasses() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<EngclassDetail> engclassDetailList = teacherServer.getEngclassList(teacherId);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("engclassDetailList", engclassDetailList);
		return Action.SUCCESS;
	}
	
	
	public String searchEngclasses() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<Engclass> engclassList = teacherServer.getEngclassByClassIdAndName(teacherId, engclass.getClassId(), engclass.getClassName());
		if(engclassList == null) {
			return Action.ERROR;
		}
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	public String engclassDetail() {
		Integer engclassId = getEngclassId();
		if(engclassId == null) {
			return Action.ERROR;
		}
		Map<String, Object> request = (Map<String, Object>)ActionContext.getContext().get("request");
		request.put("engclassDetail", teacherServer.getEngclassDetail(engclassId));
		return Action.SUCCESS;
	}
	
	public String searchUser() {
		Integer engclassId = engclass.getClassId();
		if(engclassId == null) {
			return Action.ERROR;
		}
		jsonResult = JSONArray.fromObject(engclassServer.getUserList(engclassId)).toString();
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
	
	//parameter内的参数
	public Integer getEngclassId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("engclassId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	

	public Engclass getEngclass() {
		return engclass;
	}

	public void setEngclass(Engclass engclass) {
		this.engclass = engclass;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}
	
	
}
