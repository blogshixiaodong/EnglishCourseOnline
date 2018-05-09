package com.eco.action;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.TeacherAccount;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserAccount;
import com.eco.bean.model.UserBackInfo;
import com.eco.server.BackInfoServer;
import com.eco.server.CourseServer;
import com.eco.server.EngclassServer;
import com.eco.server.UserServer;
import com.eco.server.impl.BackInfoServerImpl;
import com.eco.server.impl.CourseServerImpl;
import com.eco.server.impl.EngclassServerImpl;
import com.eco.server.impl.UserServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONArray;

public class UserAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TimeSheet timeSheet;
	
	private Integer engclassId;
	
	private UserBackInfo userBackInfo;
	
	private Integer courseRecordId;
	
	private Engclass engclass;
	
	private String jsonResult = "";
	
	private String backInfo = "";
	
	private String leaveInfo = "";
	
	private UserAccount account;
	
	private PageContainer pageContainer;
	
	
	HttpServletRequest request = ServletActionContext.getRequest();
	UserServer userServer = new UserServerImpl();
	CourseServer courseServer = new CourseServerImpl(); 
	EngclassServer engclassServer = new EngclassServerImpl();
	
	
	//获取当前正在进行的课程信息
	public String findUserNowCourseDetailList() {
		Integer userId = this.getLoginUser().getUserId();
		
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<CourseDetail> courseDetailList = userServer.queryUserNowCourseListByUserId(userId,pageContainer);
		request.setAttribute("courseDetailList",courseDetailList);
		request.setAttribute("pageContainer", pageContainer);
		return SUCCESS;
	}

	//获取所有的课程信息
	public String findUserAllCourseDetailList() {
		Integer userId = this.getLoginUser().getUserId();
		
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<CourseDetail> courseDetailList =userServer.queryUserAllCourseListByUserId(userId,pageContainer) ;
		request.setAttribute("courseDetailList",courseDetailList);
		request.setAttribute("pageContainer", pageContainer);
		
		return SUCCESS;
	}

	//获取所有历史的课程信息
	public String findUserHistoryCourseDetailList() {
		Integer userId = this.getLoginUser().getUserId();
		
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<CourseDetail> courseDetailList =userServer.queryUserHistoryCourseListByUserId(userId,pageContainer) ;
		request.setAttribute("courseDetailList",courseDetailList);
		request.setAttribute("pageContainer", pageContainer);
		return SUCCESS;
	}
	
	//查询所有班级
	public String findUserAllEngclassesList() {
		Integer userId = this.getLoginUser().getUserId();
		
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<EngclassDetail> engclassDetailList =userServer.queryUserAllEngclassByUserId(userId,pageContainer) ;
		request.setAttribute("engclassDetailList", engclassDetailList);
		request.setAttribute("pageContainer", pageContainer);
		
		return SUCCESS;
	}
	
	
	//通过班级编号查询所有学生信息
	public String findUserListByClassid() {
		
		if(engclassId == null) {
			return Action.ERROR;
		}
		
		List<User> userList = userServer.queryUserListByClassid(this.getEngclassId(),pageContainer);
		if(userList == null) {
			return ERROR;
		}
		
		jsonResult = JSONArray.fromObject(userList).toString();
		
		return SUCCESS;
	}
	
	
	
	//查询某门课程的考勤记录
	public String findUserTimeSheetList() {
		Integer userId = this.getLoginUser().getUserId();
		
		if(userId == null) {
			return Action.ERROR;
		}
		
		String queryDate = (String)request.getParameter("queryDate");
		
		List<TimeSheetDetail> timeSheetDetailList =userServer.queryTimeSheetByUserId(userId, engclass.getEngclassId(), queryDate) ;
		
		jsonResult = JSONArray.fromObject(timeSheetDetailList).toString();
		
		return SUCCESS;
	}
	
	//查询教师给的反馈信息
	public String findTeacherBackInfoList() {
		Integer userId = this.getLoginUser().getUserId();

		if(userId == null) {
			return Action.ERROR;
		}
		
		List<BackInfoDetail> backInfoDetailList = userServer.queryTeacherBackInfoByEngclassIdAndUserId(engclass.getEngclassId(),userId);
		
		jsonResult = JSONArray.fromObject(backInfoDetailList).toString();
		return SUCCESS;
	}
	
	//获取用户历史反馈信息
	public String findUserHistoryBackInfoList() {
		Integer userId = this.getLoginUser().getUserId();
		Integer engclassId = engclass.getEngclassId();
		if(userId == null || engclassId == null) {
			return Action.ERROR;
		}
		
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		jsonResult = JSONArray.fromObject(backInfoServer.queryBackInfoByUserIdAndClassId(userId, engclassId)).toString();
		return Action.SUCCESS;
	} 
	
	//根据classid 查询某班级的所有用户反馈信息
	public String findUserBackInfoInListByEngclass() {
		Integer engclassId = engclass.getEngclassId();
		
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		List<BackInfoDetail> backInfoDetailList =backInfoServer.queryUserBackInfobyClassId(engclassId) ;
		jsonResult = JSONArray.fromObject(backInfoDetailList).toString();
		
		return SUCCESS;
	}
	
	public String enrollCourseList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		List<CourseDetail> enrollCourseList = courseServer.queryEnrollCourseList();
		if(enrollCourseList == null) {
			return Action.ERROR;
		}
		request.setAttribute("enrollCourseList", enrollCourseList);
		return Action.SUCCESS;
	}
	
	public String enrollCourse() {
		Integer courseRecordId = Integer.parseInt(request.getAttribute("courseRecordId").toString());
		Integer engclassId = engclassServer.queryEngclassIdByCourseRecordId(courseRecordId);
		engclassServer.addUserClass(this.getLoginUser().getUserId(), engclassId);
		return Action.SUCCESS;
	}
	
	//查询用户所有的所在班级
	public String findUserAllEngclassList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<EngclassDetail> engclassDetailList =userServer.queryUserAllEngclassByUserId(userId,pageContainer);
		if(engclassDetailList == null) {
			return Action.ERROR;
		}
		request.setAttribute("engclassDetailList", engclassDetailList);
		
		return Action.SUCCESS;
	}
	
	//查询用户当前正在进行的  班级
	public String findUserNowEngclassList() {
		Integer userId = this.getLoginUser().getUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<EngclassDetail> engclassDetailList =userServer.queryUserNowEngclassByUserId(userId) ;
		if(engclassDetailList == null) {
			return Action.ERROR;
		}
		request.setAttribute("engclassDetailList", engclassDetailList);
		
		return Action.SUCCESS;
	}
	
	
	
	
	//用户添加反馈信息
	public String createUserBackInfo() {
		Integer userId = this.getLoginUser().getUserId();
		
		if(userId == null) {
			return Action.ERROR;
		}
		
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		backInfoServer.addUserBackInfo(engclass.getEngclassId(),userId, backInfo);
		this.setJsonResult("success");
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
		
		//timeSheet.setUserId(userId);
		timeSheet.setRecordTime(formateDate);
		
		jsonResult =userServer.addTimeSheet(timeSheet) ;
		return SUCCESS;
	}
	//登录判断
	public String userLogin() {
		
		if(!userServer.loginCheck(account)) {
			return Action.ERROR;
		}
		User user = userServer.queryUserByAccountId(account.getUser().getUserId());
		request.getSession().setAttribute("user",user);
		
		return SUCCESS;
	}
	
	//退出登录
	public String userLoginOut() {
		request.getSession().removeAttribute("user");
		
		return SUCCESS;
		
	}
	
	//报名课程
	/*public String enrolmentClassAction() {
		Integer userid = this.getLoginUserId();
		
		//userServer.enrolmentClass(userClass, courseRecordId);
		
		return SUCCESS;
	}*/
	
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


	public Integer getEngclassId() {
		return engclassId;
	}

	public void setEngclassId(Integer engclassId) {
		this.engclassId = engclassId;
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

	public String getBackInfo() {
		return backInfo;
	}

	public void setBackInfo(String backInfo) {
		this.backInfo = backInfo;
	}

	public String getLeaveInfo() {
		return leaveInfo;
	}

	public void setLeaveInfo(String leaveInfo) {
		this.leaveInfo = leaveInfo;
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
	
}
