package com.eco.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.bean.model.TeacherAccount;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.server.BackInfoServer;
import com.eco.server.EngclassServer;
import com.eco.server.TeacherServer;
import com.eco.server.UserServer;
import com.eco.server.impl.BackInfoServerImpl;
import com.eco.server.impl.EngclassServerImpl;
import com.eco.server.impl.TeacherServerImpl;
import com.eco.server.impl.UserServerImpl;
import com.eco.util.JsonUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

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
	
	private PageContainer pageContainer;
	
	private Engclass engclass;
	
	private TeacherAccount account;
	
	private String queryDate;
	
	private String jsonResult = "";
	
	public String findTeacherNowCourseList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		PageContainer<Course> courseList = teacherServer.queryNowCourseListByTeacherId(teacherId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course", "engclassSet");
		jsonResult = JSONObject.fromObject(courseList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findTeacherHistoryCourseList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		PageContainer<Course> courseList = teacherServer.queryHistoryCourseListByTeacherId(teacherId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course", "engclassSet");
		jsonResult = JSONObject.fromObject(courseList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findTeacherAllCourselList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		PageContainer<Course> courseList = teacherServer.queryAllCourseListByTeacherId(teacherId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course", "engclassSet");
		jsonResult = JSONObject.fromObject(courseList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findTeacherAllEngclassList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		PageContainer<Engclass> courseList = teacherServer.queryAllEngclassListByTeacherId(teacherId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("userSet", "teacher", "engclassSet", "courseRecordSet", "teacherBackInfoSet", "userBackInfoSet", "timeSheetSet");
		jsonResult = JSONObject.fromObject(courseList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	//仅获取id/name列表
	public String findTeacherAllEngclassIdNameList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		List<Engclass> engclassList = teacherServer.selectEngclassIdAndEngclassNameByTeacherId(teacherId);
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	public String findTeacherEngclassListByCondition() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		List<Engclass> engclassList = teacherServer.searchEngclassByEngclassIdAndEngclassName(teacherId, engclass.getEngclassId(), engclass.getEngclassName());
		if(engclassList == null) {
			return Action.ERROR;
		}
		JsonConfig jsonConfig = JsonUtils.JsonExclude("courseRecord", "teacher", "userSet", "teacherBackInfoSet", "userBackInfoSet", "teacherBackInfoSet", "userBackInfoSet", "timeSheetSet");
		jsonResult = JSONArray.fromObject(engclassList, jsonConfig).toString();
		return Action.SUCCESS;
	}

	public String engclassDetail() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		Engclass engclassDetail = teacherServer.searchEngclassByEngclassIdAndEngclassName(teacherId, engclass.getEngclassId(), null).get(0);
		putContextRequestMap("engclassDetail", engclassDetail);
		return Action.SUCCESS;
	}

	public String findUserInEngclass() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		PageContainer<User> userList = userServer.queryUserListByEngclassId(engclass.getEngclassId(), pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("engclassSet", "timeSheetSet");
		jsonResult = JSONObject.fromObject(userList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findUserTimeSheetDetail() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			jsonResult = JSONArray.fromObject(userServer.queryUserTimeSheetByEngclassId(engclass.getEngclassId(), sdf.parse(queryDate))).toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}
	
	////////////////////////////////////////////////
	
	public String findTeacherBackInfoHistory() {
		Integer teacherId = getLoginTeacherId();
		Integer engclassId = engclass.getEngclassId();
		if(teacherId == null || engclassId == null) {
			return "unlogin";
		}
//		jsonResult = JSONArray.fromObject(backInfoServer.queryBackInfoByTeacherIdAndClassId(teacherId, engclassId)).toString();
		return Action.SUCCESS;
	}
	
	
	public String createTeacherBackInfo() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		String[] userIdList = (String[])ServletActionContext.getRequest().getParameterMap().get("userIdList[]");
		String backInfo = (String)ServletActionContext.getRequest().getParameter("backInfo");
//		backInfoServer.insertTeacherBackInfo(teacherId, getEngclassId(), formatToIntger(userIdList), backInfo);
		this.setJsonResult("success");
		return Action.SUCCESS;
	}
	
	
	
	public String createTimeSheet() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		JSONArray array = JSONArray.fromObject(ServletActionContext.getRequest().getParameterMap().get("list"));
		List<TimeSheet> timeSheetList = null;
		if(array != null && array.size() > 0) {
			timeSheetList = (List<TimeSheet>)((List<TimeSheet>)array.toCollection(array, TimeSheet.class)).get(0);
		}
		for(int i = 0; i < timeSheetList.size(); i++) {

			//userServer.createTimeSheet(timeSheetList.get(i));
//			userServer.addTimeSheet(timeSheetList.get(i));
		}
		this.setJsonResult("success");
		return Action.SUCCESS;
	}
	
	public String teacherLogin() {
//		if(!teacherServer.loginCheck(account)) {
//			return "unlogin";
//		}
		Map<String, Object> map = ActionContext.getContext().getSession();
//		map.put("teacher", teacherServer.queryTeacher(account.getTeacher().getTeacherId()));
		return Action.SUCCESS;
	}
	
	
	public String teacherLogout() {
		Map<String, Object> map = ActionContext.getContext().getSession();
		map.remove("teacher");
		return Action.SUCCESS;
	}
	
	
	private Integer getLoginTeacherId() {
		Map<String, Object> map = ActionContext.getContext().getSession();
		Object teacher = map.get("teacher");
		if(teacher == null || "".equals(teacher)) {
			return 50000;
		}
		//未登录测试
		return ((Teacher)teacher).getTeacherId();
	}
	
	//parameter内的参数
	private Integer getEngclassId() {
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
	
	private void putContextRequestMap(String key, Object value) {
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put(key, value);
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

	public PageContainer getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;
	}

	public TeacherAccount getAccount() {
		return account;
	}

	public void setAccount(TeacherAccount account) {
		this.account = account;
	}
	
}
