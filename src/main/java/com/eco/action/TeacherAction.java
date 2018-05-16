package com.eco.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.bean.model.TeacherAccount;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserBackInfo;
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
		List<Engclass> engclassList = teacherServer.queryEngclassIdAndEngclassNameByTeacherId(teacherId);
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	//用户id/name
	public String findEngclassAllUserIdNameList() {
		Integer engclassId = engclass.getEngclassId();
		List<User> userList = teacherServer.queryUserIdAndUsernameByEngclassId(engclassId);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("engclassSet", "timeSheetSet");
		jsonResult = JSONArray.fromObject(userList, jsonConfig).toString();
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
		JsonConfig jsonConfig = JsonUtils.JsonExclude("engclassSet", "timeSheetSet", "userAccount", "courseRecordSet", "teacher", "userSet", "teacherBackInfoSet", "userBackInfoSet");
		PageContainer<TimeSheet> timeSheetList = null;
		try {
			timeSheetList = userServer.queryUserTimeSheetByEngclassId(engclass.getEngclassId(), sdf.parse(queryDate), pageContainer);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		jsonResult = JSONObject.fromObject(timeSheetList, jsonConfig).toString();
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
		teacherServer.saveUserTimeSheet(timeSheetList);
		this.setJsonResult("success");
		return Action.SUCCESS;
	}
	
	public String findUserBackInfoHistory() {
		Integer teacherId = getLoginTeacherId();
		Integer engclassId = engclass.getEngclassId();
		if(teacherId == null || engclassId == null) {
			return "unlogin";
		}
		PageContainer<UserBackInfo> usrBackInfoList = userServer.queryUserBackInfoByEngclassId(engclassId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("engclass", "engclassSet", "timeSheetSet", "userAccount");
		jsonResult = JSONObject.fromObject(usrBackInfoList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	public String findTeacherBackInfoHistory() {
		Integer teacherId = getLoginTeacherId();
		Integer engclassId = engclass.getEngclassId();
		if(teacherId == null || engclassId == null) {
			return "unlogin";
		}
		PageContainer<TeacherBackInfo> teacherBackInfoList = teacherServer.queryTeacherBackInfoByTeacherIdAndEngclassId(teacherId, engclassId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("engclassSet", "timeSheetSet", "userAccount", "engclass", "teacher");
		jsonResult = JSONObject.fromObject(teacherBackInfoList, jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	
	public String createTeacherBackInfo() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return "unlogin";
		}
		Map<String, String[]> map = ServletActionContext.getRequest().getParameterMap();
		String engclassId = map.get("engclassId")[0];
		String backInfo = map.get("backInfo")[0];
		String[] userList = map.get("userIdList[]");
		List<TeacherBackInfo> teacherBackInfoList = new ArrayList<>();
		//全体反馈信息
		if(userList.length == 1 && userList[0].equals("-1")) {
			TeacherBackInfo teacherBackInfo = new TeacherBackInfo();
			teacherBackInfo.setBackInfo(backInfo);
			teacherBackInfo.setBackTime(new Date());
			Engclass engclassEx = new Engclass();
			engclassEx.setEngclassId(Integer.parseInt(engclassId));
			teacherBackInfo.setEngclass(engclassEx);
			teacherBackInfo.setUser(null);
			Teacher teacherEx = new Teacher();
			teacherEx.setTeacherId(getLoginTeacherId());
			teacherBackInfo.setTeacher(teacherEx);
			
			teacherBackInfoList.add(teacherBackInfo);
		} else {
			for(int i = 0; i < userList.length; i++) {
				TeacherBackInfo teacherBackInfo = new TeacherBackInfo();
				teacherBackInfo.setBackInfo(backInfo);
				teacherBackInfo.setBackTime(new Date());
				Engclass engclassEx = new Engclass();
				engclassEx.setEngclassId(Integer.parseInt(engclassId));
				teacherBackInfo.setEngclass(engclassEx);
				User userEx = new User();
				userEx.setUserId(Integer.parseInt(userList[i]));
				teacherBackInfo.setUser(userEx);
				Teacher teacherEx = new Teacher();
				teacherEx.setTeacherId(getLoginTeacherId());
				teacherBackInfo.setTeacher(teacherEx);
				
				teacherBackInfoList.add(teacherBackInfo);
			}
		}
		
		teacherServer.saveTeacherBackInfo(teacherBackInfoList);
		this.setJsonResult("success");
		return Action.SUCCESS;
	}
	
	
	public String teacherLogin() {
		if(!teacherServer.loginCheck(account)) {
			return "unlogin";
		}
		Map<String, Object> map = ActionContext.getContext().getSession();
		map.put("teacher", teacherServer.queryTeacherrByAccountId(account.getId()));
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

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

	public TeacherAccount getAccount() {
		return account;
	}

	public void setAccount(TeacherAccount account) {
		this.account = account;
	}
	
}
