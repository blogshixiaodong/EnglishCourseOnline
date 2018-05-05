package com.eco.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Account;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
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
	
	private PageContainer pageContainer;
	
	private Engclass engclass;
	
	private Account account;
	
	private String jsonResult = "";
	
	public String findTeacherNowCourseDetailList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		ActionContext.getContext();
		List<CourseDetail> courseDetailList = teacherServer.queryNowCourseDetailListByTeacherId(teacherId,pageContainer);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("courseDetailList", courseDetailList);
		request.put("pageContainer", pageContainer);
		return Action.SUCCESS;
	}
	
	public String findTeacherHistoryCourseDetailList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<CourseDetail> courseDetailList = teacherServer.queryHistoryCourseDetailListByTeacherId(teacherId,pageContainer);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("courseDetailList", courseDetailList);
		request.put("pageContainer", pageContainer);
		return Action.SUCCESS;
	}
	
	public String findTeacherAllCourseDetailList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		
		List<CourseDetail> courseDetailList = teacherServer.queryAllCourseDetailListByTeacherId(teacherId, pageContainer);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("courseDetailList", courseDetailList);
		request.put("pageContainer", pageContainer);
		return Action.SUCCESS;
	}
	
	public String findTeacherAllEngclassDetailList() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<EngclassDetail> engclassDetailList = teacherServer.queryEngclassListByTeacherId(teacherId,pageContainer);
		Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
		request.put("engclassDetailList", engclassDetailList);
		request.put("pageContainer", pageContainer);
		return Action.SUCCESS;
	}
	
	public String findTeacherEngclassListByCondition() {
		Integer teacherId = getLoginTeacherId();
		if(teacherId == null) {
			return Action.ERROR;
		}
		List<Engclass> engclassList = teacherServer.queryEngclassByCondition(teacherId, engclass.getClassId(), engclass.getClassName());
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
		request.put("engclassDetail", teacherServer.queryEngclassDetailByEngclassId(engclassId));
		return Action.SUCCESS;
	}
	
	public String findUserInEngclass() {
		Integer engclassId = engclass.getClassId();
		if(engclassId == null) {
			return Action.ERROR;
		}
		jsonResult = JSONArray.fromObject(engclassServer.queryUserListByEngclassId(engclassId)).toString();
		return Action.SUCCESS;
	}
	
	
	public String findTeacherBackInfoHistory() {
		Integer teacherId = getLoginTeacherId();
		Integer engclassId = engclass.getClassId();
		if(teacherId == null || engclassId == null) {
			return Action.ERROR;
		}
		jsonResult = JSONArray.fromObject(backInfoServer.queryBackInfoByTeacherIdAndClassId(teacherId, engclassId)).toString();
		return Action.SUCCESS;
	}
	
	
	public String createTeacherBackInfo() {
		Integer teacherId = getLoginTeacherId();
		String[] userIdList = (String[])ServletActionContext.getRequest().getParameterMap().get("userIdList[]");
		String backInfo = (String)ServletActionContext.getRequest().getParameter("backInfo");
		backInfoServer.insertTeacherBackInfo(teacherId, getEngclassId(), formatToIntger(userIdList), backInfo);
		this.setJsonResult("success");
		return Action.SUCCESS;
	}
	
	public String findUserTimeSheetDetail() {
		Integer engclassId = engclass.getClassId();
		String queryDate = ((String [])ServletActionContext.getRequest().getParameterMap().get("queryDate"))[0].toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			jsonResult = JSONArray.fromObject(userServer.queryUserTimeSheetByEngclassId(engclassId, sdf.parse(queryDate))).toString();
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
		
	}
	
	public String createTimeSheet() {
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
	
	public String teacherLogin() {
		if(!teacherServer.loginCheck(account)) {
			return Action.ERROR;
		}
		Map<String, Object> map = ActionContext.getContext().getSession();
		map.put("teacherId", account.getRoleId());
		return Action.SUCCESS;
	}
	
	
	public String teacherLogout() {
		Map<String, Object> map = ActionContext.getContext().getSession();
		map.remove("teacherId");
		return Action.SUCCESS;
	}
	
	
	private Integer getLoginTeacherId() {
		Map<String, Object> map = ActionContext.getContext().getSession();
		Object id = map.get("teacherId");
		if(id == null || "".equals(id)) {
			return null;
		}
		//未登录测试
		return new Integer(id.toString());
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

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
