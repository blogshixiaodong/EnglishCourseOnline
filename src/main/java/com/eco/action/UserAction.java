package com.eco.action;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserAccount;
import com.eco.bean.model.UserBackInfo;
import com.eco.server.UserServer;
import com.eco.server.impl.UserServerImpl;
import com.eco.util.DateFormat;
import com.eco.util.JsonUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

public class UserAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private TimeSheet timeSheet;
	
	private UserBackInfo userBackInfo;
	
	private Integer courseRecordId;
	
	private Engclass engclass;
	
	private String jsonResult = "";
	
	private UserAccount account;
	
	private PageContainer pageContainer;
	
	String queryDate;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	UserServer userServer = new UserServerImpl();
	
	
	//获取当前正在进行的课程信息
	public String findUserNowCourseDetailList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}	
		PageContainer<Course> courseList = userServer.queryUserNowCourseListByUserId(userId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course","engclassSet");
		jsonResult = JSONObject.fromObject(courseList,jsonConfig).toString();
		return SUCCESS;
	}

	//获取所有的课程信息
	public String findUserAllCourseDetailList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		PageContainer<Course> courseList =userServer.queryUserAllCourseListByUserId(userId,pageContainer) ;
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course","engclassSet");
		jsonResult = JSONObject.fromObject(courseList,jsonConfig).toString();
		return SUCCESS;
	}

	//获取所有历史的课程信息
	public String findUserHistoryCourseDetailList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		PageContainer<Course> courseList =userServer.queryUserHistoryCourseListByUserId(userId,pageContainer) ;
		JsonConfig jsonConfig = JsonUtils.JsonExclude("course","engclassSet");
		jsonResult = JSONObject.fromObject(courseList,jsonConfig).toString();
		return SUCCESS;
	}
	
	//查询所有班级
	public String findUserAllEngclassesList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		PageContainer<Engclass> engclassList =userServer.queryUserAllEngclassByUserId(userId,pageContainer) ;
		JsonConfig jsonConfig = JsonUtils.JsonExclude("userSet","teacherBackInfoSet","userBackInfoSet","timeSheetSet","teacher","engclassSet","courseRecordSet");                         
		jsonResult = JSONObject.fromObject(engclassList,jsonConfig).toString();
		return SUCCESS;
	}
	
	//查询当前班级
	public String findUserNowEngclassesList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		PageContainer<Engclass> engclassList = userServer.queryUserNowEngclassByUserId(userId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("userSet","teacherBackInfoSet","userBackInfoSet","timeSheetSet","teacher","engclassSet","courseRecordSet");                         
		jsonResult = JSONObject.fromObject(engclassList,jsonConfig).toString();
		return SUCCESS;
	}
	
	//查询历史班级
	public String findUserHistoryEngclassesList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null){
			return Action.ERROR;
		}
		PageContainer<Engclass> engclassList = userServer.queryUserHistoryEngclassListByUserId(userId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("userSet","teacherBackInfoSet","userBackInfoSet","timeSheetSet","teacher","engclassSet","courseRecordSet");                         
		jsonResult = JSONObject.fromObject(engclassList,jsonConfig).toString();
		return SUCCESS;
	}

	public String findEngclassIdAndEngclassName() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		List<Engclass> engclassList = userServer.queryEngclassByUserId(userId);
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return SUCCESS;
	}

	
	//查询某门课程的考勤记录
	public String findUserTimeSheetList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		String queryDate = (String)request.getParameter("queryDate");
		PageContainer<TimeSheet> timeSheeList =userServer.queryTimeSheetByUserId(userId, engclass.getEngclassId(), queryDate,pageContainer) ;
		JsonConfig jsonConfig = JsonUtils.JsonExclude("timeSheetSet","userAccount","engclassSet","userSet","teacherBackInfoSet","userBackInfoSet","teacher","courseRecord");                       
		jsonResult = JSONObject.fromObject(timeSheeList,jsonConfig).toString();
		return SUCCESS;
	}
	
	//查询教师给的反馈信息
	public String findTeacherBackInfoList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		PageContainer<TeacherBackInfo> backInfoList = userServer.queryTeacherBackInfoByEngclassIdAndUserId(engclass.getEngclassId(),userId,pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("timeSheetSet","userAccount","engclassSet","courseRecord","userSet","teacherBackInfoSet","userBackInfoSet","teacherAccount");                   
		jsonResult = JSONObject.fromObject(backInfoList,jsonConfig).toString();
		return SUCCESS;
	}
	
	//获取用户历史反馈信息
	public String findUserHistoryBackInfoList() {
		Integer userId = this.getLoginUser().getUserId();
		Integer engclassId = engclass.getEngclassId();
		if(userId == null || engclassId == null) {
			return Action.ERROR;
		}
		PageContainer<UserBackInfo> userBackInfoList = userServer.queryUserBackInfoByEngclassIdAndUserId(engclass.getEngclassId(), userId, pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("courseRecord","teacher","userSet","teacherBackInfoSet","userBackInfoSet","timeSheetSet","engclassSet","userAccount");                               
		jsonResult = JSONObject.fromObject(userBackInfoList,jsonConfig).toString();
		return Action.SUCCESS;
	} 
	

	//获取报名列表
	public String findenrollCourseList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		PageContainer<CourseRecord> enrollCourseList = userServer.queryAllEnroll(pageContainer);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("engclassSet","courseRecord","courseRecordSet");
		jsonResult = JSONObject.fromObject(enrollCourseList,jsonConfig).toString();
		return Action.SUCCESS;
	}
	
	
	public String enrollCourse() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		userServer.addUserEngclass(userId, courseRecordId);
		return Action.SUCCESS;
	}

	//用户添加反馈信息
	public String createUserBackInfo() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		userServer.addUserBackInfo(userBackInfo,userId);
		return SUCCESS;
	}
	
	
	//创建一条考勤记录（请假）
	public String createUserTimeSheet() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		String queryDate = (String)request.getParameter("queryDate");
		java.util.Date formateDate = stringFormateToDate(queryDate);
		timeSheet.setRecordTime(formateDate);
		jsonResult =userServer.addTimeSheet(timeSheet,userId) ;
		return SUCCESS;
	}
	
	//登录判断
	public String userLogin() {
		if(!userServer.loginCheck(account)) {
			return Action.ERROR;
		}
		User user = userServer.queryUserByAccountId(account.getId());
		request.getSession().setAttribute("user",user);
		return SUCCESS;
	}
	
	//退出登录
	public String userLoginOut() {
		request.getSession().removeAttribute("user");
		return SUCCESS;
	}
	
	
	//获取课表
	public String getengClassTimeTable(){
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<Engclass> engclassList = userServer.queryTimeTable(queryDate, userId);
		JsonConfig jsonConfig = JsonUtils.JsonExclude("userSet","teacherBackInfoSet","userBackInfoSet","timeSheetSet","engclassSet","courseRecordSet");                       
		jsonResult = JSONArray.fromObject(engclassList,jsonConfig).toString();
		return Action.SUCCESS;
	}

	protected java.util.Date stringFormateToDate(String stringDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return sdf.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private User getLoginUser() {
		User user = (User)request.getSession().getAttribute("user");
		return user;
	}

	public TimeSheet getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}

	public UserBackInfo getUserBackInfo() {
		return userBackInfo;
	}

	public void setUserBackInfo(UserBackInfo userBackInfo) {
		this.userBackInfo = userBackInfo;
	}

	public Integer getCourseRecordId() {
		return courseRecordId;
	}

	public void setCourseRecordId(Integer courseRecordId) {
		this.courseRecordId = courseRecordId;
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

	public UserAccount getAccount() {
		return account;
	}

	public void setAccount(UserAccount account) {
		this.account = account;
	}

	public String getQueryDate() {
		return queryDate;
	}

	public void setQueryDate(String queryDate) {
		this.queryDate = queryDate;
	}

}
