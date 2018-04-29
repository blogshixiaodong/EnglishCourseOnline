package com.eco.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.TimeSheet;
import com.eco.server.BackInfoServer;
import com.eco.server.EngclassServer;
import com.eco.server.TeacherServer;
import com.eco.server.UserServer;
import com.eco.server.impl.BackInfoServerImpl;
import com.eco.server.impl.EngclassServerImpl;
import com.eco.server.impl.TeacherServerImpl;
import com.eco.server.impl.UserServerImpl;
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
	private BackInfoServer backInfoServer = new BackInfoServerImpl();
	private UserServer userServer = new UserServerImpl();
	
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
		
		
		//jsonResult = JSONArray.fromObject(engclassServer.getUserList(engclassId)).toString();
		jsonResult = JSONArray.fromObject(engclassServer.queryUserListByEngclassId(engclassId)).toString();
		return Action.SUCCESS;
	}
	
	
	public String teacherBackInfoHistory() {
		Integer teacherId = getLoginTeacherId();
		Integer engclassId = engclass.getClassId();
		if(teacherId == null || engclassId == null) {
			return Action.ERROR;
		}
		//jsonResult = JSONArray.fromObject(backInfoServer.getBackInfoByTeacherIdAndClassId(teacherId, engclassId)).toString();
		jsonResult = JSONArray.fromObject(backInfoServer.queryBackInfoByTeacherIdAndClassId(teacherId, engclassId)).toString();
		return Action.SUCCESS;
	}
	
	
	public String insertBackInfo() {
		Integer teacherId = getLoginTeacherId();
		String[] userIdList = (String[])ServletActionContext.getRequest().getParameterMap().get("userIdList[]");
		String backInfo = (String)ServletActionContext.getRequest().getParameter("backInfo");
		backInfoServer.insertTeacherBackInfo(teacherId, getEngclassId(), formatToIntger(userIdList), backInfo);
		this.setJsonResult("success");
		return Action.SUCCESS;
	}
	
	public String getUserTimeSheetDetail() {
		Integer engclassId = engclass.getClassId();
		String queryDate = ((String [])ServletActionContext.getRequest().getParameterMap().get("queryDate"))[0].toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			//jsonResult = JSONArray.fromObject(userServer.queryUserTimeSheetDetailByClassId(engclassId, sdf.parse(queryDate))).toString();
			jsonResult = JSONArray.fromObject(userServer.queryUserTimeSheetByEngclassId(engclassId, sdf.parse(queryDate))).toString();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
		
	}
	
	public String insertTimeSheet() {
		Integer teacherId = getLoginTeacherId();
		
		JSONArray array = JSONArray.fromObject(ServletActionContext.getRequest().getParameterMap().get("list"));
		List<TimeSheet> timeSheetList = null;
		if(array != null && array.size() > 0) {
			timeSheetList = (List<TimeSheet>)((List<TimeSheet>)array.toCollection(array, TimeSheet.class)).get(0);
		}
		for(int i = 0; i < timeSheetList.size(); i++) {
			//存在冲突
			//userServer.createTimeSheet(timeSheetList.get(i));
		}
		this.setJsonResult("success");
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
	
	private Integer[] formatToIntger(String[] stringArray) {
		Integer[] intgerArray = new Integer[stringArray.length];
		for(int i = 0; i < stringArray.length; i++) {
			intgerArray[i] = new Integer(stringArray[i]);
		}
		return intgerArray;
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
