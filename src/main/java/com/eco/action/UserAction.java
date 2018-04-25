package com.eco.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.CourseRecord;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserBackInfo;
import com.eco.bean.model.UserClass;
import com.eco.dao.UserDao;
import com.eco.server.BackInfoServer;
import com.eco.server.UserServer;
import com.eco.server.impl.BackInfoServerImpl;
import com.eco.server.impl.UserServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TimeSheet timeSheet;
	
	private Integer classid;
	
	private UserBackInfo userBackInfo;
	
	private Integer courseRecordId;
	
	private UserClass userClass;
	
	private Engclass engclass;
	
	private String jsonResult = "";
	
	HttpServletRequest request = ServletActionContext.getRequest();
	UserServer userServer = new UserServerImpl();
	
	
	//获取当前正在进行的课程信息
	public String showNowCourses() {
		Integer userid = this.getLoginUserId();
		
		List<CourseDetail> courseDetailList = userServer.queryNowCourseDetail(userid);
		request.setAttribute("courseDetailList",courseDetailList);
		
		return SUCCESS;
	}

	//获取所有的课程信息
	public String showAllCourses() {
		Integer userid = this.getLoginUserId();

		List<CourseDetail> courseDetailList = userServer.queryAllCourseDetail(userid);
		request.setAttribute("courseDetailList",courseDetailList);
		
		return SUCCESS;
	}

	//获取所有的课程信息
	public String showHistoryCourses() {
		Integer userid = this.getLoginUserId();

		List<CourseDetail> courseDetailList = userServer.queryHistoryCourseDetail(userid);
		request.setAttribute("courseDetailList",courseDetailList);
		
		return SUCCESS;
	}
	
	//查询所有班级
	public String showAllEngclasses() {
		Integer userid = this.getLoginUserId();
		
		List<EngclassDetail> engclassDetailList = userServer.queryAllEngclassDetail(userid);
		request.setAttribute("engclassDetailList", engclassDetailList);
		
		return SUCCESS;
	}
	
	
	public String queryUserByClassid() {
		
		if(classid == null) {
			return Action.ERROR;
		}
		
		List<User> userList = userServer.queryUserListByClassid(classid);
		if(userList == null) {
			return ERROR;
		}
		
		jsonResult = JSONArray.fromObject(userList).toString();
		
		return SUCCESS;
	}
	
	
	
	//查询某门课程的考勤记录
	public String showTimeSheets() {
		Integer userid = this.getLoginUserId();

		List<TimeSheetDetail> timeSheetDetailList = userServer.queryTimeSheetDetailByUser(userid, engclass.getClassId(),engclass.getClassName());
		request.setAttribute("timeSheetDetailList", timeSheetDetailList);
		
		return SUCCESS;
	}
	
	//查询教师给的反馈信息
	public String showTeacherBackInfos() {
		Integer userid = this.getLoginUserId();

		List<BackInfoDetail> backInfoDetailList = userServer.queryTeacherBackInfo(classid, userid);
		//request.setAttribute("backInfoDetailList", backInfoDetailList);
		
		jsonResult = JSONArray.fromObject(backInfoDetailList).toString();
		return SUCCESS;
	}
	
	//获取用户历史反馈信息
	public String userBackInfoHistory() {
		Integer userId = this.getLoginUserId();
		Integer engclassId = engclass.getClassId();
		if(userId == null || engclassId == null) {
			return Action.ERROR;
		}
		
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		jsonResult = JSONArray.fromObject(backInfoServer.getBackInfoByUserIdAndClassId(userId, engclassId)).toString();
		return Action.SUCCESS;
	} 
	
	//查询用户所在班级
	public String searchEngclasses() {
		Integer userId = this.getLoginUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		
		UserServer userServer = new UserServerImpl();
		List<EngclassDetail> engclassDetailList = userServer.queryAllEngclassDetail(userId);
		if(engclassDetailList == null) {
			return Action.ERROR;
		}
		//jsonResult = JSONArray.fromObject(engclassDetailList).toString();
		request.setAttribute("engclassDetailList", engclassDetailList);
		
		return Action.SUCCESS;
	}
	
	
	public String 
	
	
	
	//用户添加反馈信息
	public String createUserBackInfoAction() {
		Integer userid = this.getLoginUserId();
		
		//检查userBackInfo中信息是否完整！！！！
		userServer.createUserBackInfo(userBackInfo);
		
		return SUCCESS;
	}
	
	
	//创建一条考勤记录（请假）
	public String createTimeSheetAction() {
		Integer userid = this.getLoginUserId();
		
		//考勤记录手动添加 用户id 和classid -->待定
		timeSheet.setUserId(userid);
		
		userServer.createTimeSheet(timeSheet);
		
		return SUCCESS;
	}
	
	//报名课程
	public String enrolmentClassAction() {
		Integer userid = this.getLoginUserId();
		
		userServer.enrolmentClass(userClass, courseRecordId);
		
		return SUCCESS;
	}
	
	
	private Integer getLoginUserId() {
		Integer userid = (Integer)request.getAttribute("userid");
		if(userid == null && !"".equals("")) {
			System.out.println("失败");
		}
		
		userid = 40000;//暂时赋值 -_-!!
		
		return userid;
	}
	
	
	public TimeSheet getTimeSheet() {
		return timeSheet;
	}

	public void setTimeSheet(TimeSheet timeSheet) {
		this.timeSheet = timeSheet;
	}

	public Integer getClassid() {
		return classid;
	}

	public void setClassid(Integer classid) {
		this.classid = classid;
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

	public UserClass getUserClass() {
		return userClass;
	}

	public void setUserClass(UserClass userClass) {
		this.userClass = userClass;
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
