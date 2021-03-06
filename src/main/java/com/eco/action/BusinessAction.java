package com.eco.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Account;
import com.eco.bean.model.Course;
import com.eco.bean.model.CourseRecord;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.Teacher;
import com.eco.dao.CourseRecordDao;
import com.eco.server.BusinessServer;
import com.eco.server.CourseServer;
import com.eco.server.EngclassServer;
import com.eco.server.TeacherServer;
import com.eco.server.UserServer;
import com.eco.server.impl.BusinessServerImpl;
import com.eco.server.impl.CourseServerImpl;
import com.eco.server.impl.EngclassServerImpl;
import com.eco.server.impl.TeacherServerImpl;
import com.eco.server.impl.UserServerImpl;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * date:   2018年5月5日 下午16:41:15
 * author: Shixiaodong
 */
public class BusinessAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private CourseServer courseServer = new CourseServerImpl();
	
	private TeacherServer teacherServer = new TeacherServerImpl();
	
	private EngclassServer engclassServer = new EngclassServerImpl();
	
	private Course course;
	
	private Account account;
	
	private PageContainer pageContainer;
	
	
	private CourseRecord courseRecord;
	
	private Engclass engclass;
	
	private Integer oldEngclassId1;
	private Integer oldEngclassId2;
	private Integer userNum1;
	private Integer userNum2;
	
	
	private BusinessServer businessServer = new BusinessServerImpl();
	private HttpServletRequest request = ServletActionContext.getRequest();
	
	
	private String jsonResult = "";
	
	public String findAllCourse() {
		List<Course> corseList = courseServer.queryAllCourse();
		jsonResult = JSONArray.fromObject(corseList).toString();
		return Action.SUCCESS;
	}
	
	public String findCourseByCourseId() {
		Course destCourse = courseServer.queryCourseByCourseId(getCourseId());
		jsonResult = JSONObject.fromObject(destCourse).toString();
		
		return Action.SUCCESS;
	}
	
	public String findAllTeacherList() {
		List<Teacher> teacherList = teacherServer.queryAllTeacher();
		jsonResult = JSONArray.fromObject(teacherList).toString();
		return Action.SUCCESS;
	}
	
	
	public String findTeacherByTeacherId() {
		Teacher teacher = teacherServer.queryTeacher(getTeacherId());
		jsonResult = JSONObject.fromObject(teacher).toString();
		return Action.SUCCESS;
	}
	
	//创建班级，课程记录
	public String createEngclass() {
		
		businessServer.setUpEngclass(engclass, courseRecord);
		
		
		return Action.SUCCESS;
	}
	
	public String createCourse() {
		//判断商家账号
		
		if(businessServer.addCourse(course)) {
			return SUCCESS; 
		}
		return ERROR;
	}
	
	
	public String mergeEngclass() {
		
		EngclassServer engclassServer = new EngclassServerImpl();
		
		int courseRecordId = engclassServer.queryCourseRecordIdByEngclassId(oldEngclassId1);
		
		engclass.setCourseRecordId(courseRecordId);
		engclass.setUserCount(userNum1 + userNum2);
		int engclassId = new Long(engclassServer.create(engclass)).intValue();
		
		//教师无法修改
		UserServer userver = new UserServerImpl();
		userver.mergeEngclass(oldEngclassId1, oldEngclassId2, engclassId);
		
		return SUCCESS;
	}
	
	//数据库两个主码修改 user_class
	//teacher 中有一个页面有bug
	
	
	public String findAllCourseList() {

		List<Course> courseList =businessServer.queryqueryAllCourseList(pageContainer) ;
		request.setAttribute("courseList",courseList);
		request.setAttribute("pageContainer", pageContainer);
		
		return SUCCESS;
	}

	public String findEngclassListByCourseId() {
		List<Engclass> engclassList = engclassServer.queryEnglclassListByCourseId(getCourseId());
		jsonResult = JSONArray.fromObject(engclassList).toString();
		return Action.SUCCESS;
	}
	
	public String findEngclassByEngclassId() {
		EngclassDetail engclass = engclassServer.queryEngclassDetailByEngclasId(getEngclassId());
		jsonResult = JSONObject.fromObject(engclass).toString();
		return Action.SUCCESS;
	}
	
	public String businessLogin() {
		if(account != null) {
			if(account.getId() == 123 && account.getPassword().equals("123")) {
				return Action.SUCCESS;
			}
		}
		return Action.ERROR;
	}
	
	//parameter内的参数
	private Integer getEngclassId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("engclassId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	
	private Integer getCourseId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("courseId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	
	private Integer getTeacherId() {
		Object id = ((Map<String, Object>)ActionContext.getContext().get("parameters")).get("teacherId");
		if(id != null) {
			return new Integer(id.toString());
		}
		return null;
	}
	

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
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

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jsonResult) {
		this.jsonResult = jsonResult;
	}

	public CourseRecord getCourseRecord() {
		return courseRecord;
	}

	public void setCourseRecord(CourseRecord courseRecord) {
		this.courseRecord = courseRecord;
	}

	public Engclass getEngclass() {
		return engclass;
	}

	public void setEngclass(Engclass engclass) {
		this.engclass = engclass;
	}

	public Integer getOldEngclassId1() {
		return oldEngclassId1;
	}

	public void setOldEngclassId1(Integer oldEngclassId1) {
		this.oldEngclassId1 = oldEngclassId1;
	}

	public Integer getOldEngclassId2() {
		return oldEngclassId2;
	}

	public void setOldEngclassId2(Integer oldEngclassId2) {
		this.oldEngclassId2 = oldEngclassId2;
	}

	public Integer getUserNum1() {
		return userNum1;
	}

	public void setUserNum1(Integer userNum1) {
		this.userNum1 = userNum1;
	}

	public Integer getUserNum2() {
		return userNum2;
	}

	public void setUserNum2(Integer userNum2) {
		this.userNum2 = userNum2;
	}
	
	
	

}