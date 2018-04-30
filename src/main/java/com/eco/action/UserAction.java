package com.eco.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.Account;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserBackInfo;
import com.eco.bean.model.UserClass;
import com.eco.dao.AccountDao;
import com.eco.dao.impl.AccountDaoImpl;
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
	
	private Integer engclassId;
	
	private UserBackInfo userBackInfo;
	
	private Integer courseRecordId;
	
	private UserClass userClass;
	
	private Engclass engclass;
	
	private String jsonResult = "";
	
	private String backInfo = "";
	
	private String leaveInfo = "";
	
	private Account account;
	
	HttpServletRequest request = ServletActionContext.getRequest();
	UserServer userServer = new UserServerImpl();
	
	
	//获取当前正在进行的课程信息
	public String findUserNowCourseDetailList() {
		Integer userId = this.getLoginUserId();
		
		List<CourseDetail> courseDetailList = userServer.queryUserNowCourseListByUserId(userId);
		request.setAttribute("courseDetailList",courseDetailList);
		
		return SUCCESS;
	}

	//获取所有的课程信息
	public String findUserAllCourseDetailList() {
		Integer userId = this.getLoginUserId();

		List<CourseDetail> courseDetailList =userServer.queryUserAllCourseListByUserId(userId) ;
		request.setAttribute("courseDetailList",courseDetailList);
		
		return SUCCESS;
	}

	//获取所有的课程信息
	public String findUserHistoryCourseDetailList() {
		Integer userId = this.getLoginUserId();

		List<CourseDetail> courseDetailList =userServer.queryUserHistoryCourseListByUserId(userId) ;
		request.setAttribute("courseDetailList",courseDetailList);
		
		return SUCCESS;
	}
	
	//查询所有班级
	public String findUserAllEngclassesList() {
		Integer userId = this.getLoginUserId();
		
		List<EngclassDetail> engclassDetailList =userServer.queryUserAllEngclassByUserId(userId) ;
		request.setAttribute("engclassDetailList", engclassDetailList);
		
		return SUCCESS;
	}
	
	
	//通过班级编号查询所有学生信息
	public String findUserListByClassid() {
		
		if(engclassId == null) {
			return Action.ERROR;
		}
		
		List<User> userList = userServer.queryUserListByClassid(this.getEngclassId());
		if(userList == null) {
			return ERROR;
		}
		
		jsonResult = JSONArray.fromObject(userList).toString();
		
		return SUCCESS;
	}
	
	
	
	//查询某门课程的考勤记录
	public String findUserTimeSheetList() {
		Integer userId = this.getLoginUserId();
		
		String queryDate = (String)request.getParameter("queryDate");
		
		List<TimeSheetDetail> timeSheetDetailList =userServer.queryTimeSheetByUserId(userId, engclass.getClassId(), queryDate) ;
		
		jsonResult = JSONArray.fromObject(timeSheetDetailList).toString();
		
		return SUCCESS;
	}
	
	//查询教师给的反馈信息
	public String findTeacherBackInfoList() {
		Integer userId = this.getLoginUserId();

		List<BackInfoDetail> backInfoDetailList = userServer.queryTeacherBackInfoByEngclassIdAndUserId(engclass.getClassId(),userId);
		
		jsonResult = JSONArray.fromObject(backInfoDetailList).toString();
		return SUCCESS;
	}
	
	//获取用户历史反馈信息
	public String findUserHistoryBackInfoList() {
		Integer userId = this.getLoginUserId();
		Integer engclassId = engclass.getClassId();
		if(userId == null || engclassId == null) {
			return Action.ERROR;
		}
		
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		jsonResult = JSONArray.fromObject(backInfoServer.queryBackInfoByUserIdAndClassId(userId, engclassId)).toString();
		return Action.SUCCESS;
	} 
	
	//根据classid 查询某班级的所有用户反馈信息
	public String findUserBackInfoInListByEngclass() {
		
		Integer engclassId = engclass.getClassId();
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		List<BackInfoDetail> backInfoDetailList =backInfoServer.queryUserBackInfobyClassId(engclassId) ;
		jsonResult = JSONArray.fromObject(backInfoDetailList).toString();
		
		return SUCCESS;
	}
	
	
	//查询用户所在班级
	public String findUserAllEngclassList() {
		Integer userId = this.getLoginUserId();
		if(userId == null) {
			return Action.ERROR;
		}
		
		List<EngclassDetail> engclassDetailList =userServer.queryUserAllEngclassByUserId(userId);
		if(engclassDetailList == null) {
			return Action.ERROR;
		}
		request.setAttribute("engclassDetailList", engclassDetailList);
		
		return Action.SUCCESS;
	}
	
	//查询用户当前正在进行的  班级
	public String findUserNowEngclassList() {
		Integer userId = this.getLoginUserId();
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
		Integer userId = this.getLoginUserId();
		
		BackInfoServer backInfoServer = new BackInfoServerImpl();
		backInfoServer.addUserBackInfo(engclass.getClassId(),userId, backInfo);
		this.setJsonResult("success");
		return SUCCESS;
	}
	
	
	//创建一条考勤记录（请假）
	public String createUserTimeSheet() {
		Integer userId = this.getLoginUserId();
		
		String queryDate = (String)request.getParameter("queryDate");
		
		jsonResult =userServer.addTimeSheet(userId, engclassId, queryDate, this.getLeaveInfo()) ;
	
		return SUCCESS;
	}
	
	//登录判断
	public String userLogin() {
		
		AccountDao aDao = new AccountDaoImpl();
		if(aDao.checkLoginAccount(account.getId(), account.getPassword())) {
			return SUCCESS;
		}
		
		return ERROR;
	}
	
	
	
	//报名课程
	/*public String enrolmentClassAction() {
		Integer userid = this.getLoginUserId();
		
		//userServer.enrolmentClass(userClass, courseRecordId);
		
		return SUCCESS;
	}*/
	
	
	private Integer getLoginUserId() {
		Integer userId = (Integer)request.getAttribute("userId");
		if(userId == null && !"".equals("")) {
			System.out.println("失败");
		}
		
		userId = 40000;//暂时赋值 -_-!!
		
		return userId;
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

}
