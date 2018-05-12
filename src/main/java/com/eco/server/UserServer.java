package com.eco.server;

import java.util.Date;
import java.util.List;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.Course;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserAccount;

public interface UserServer {
	
	
	
	/** 
	* @Description: 查看正在进行的课程 
	* @param userId
	* @param pageContainer
	* @return List<CourseDetail>
	*/ 
	public abstract PageContainer<Course> queryUserNowCourseListByUserId(Integer userId,PageContainer pageContainer);
	
	
	
	/** 
	* @Description: 查看所有进行的课程 
	* @param userId
	* @param pageContainer
	* @return List<CourseDetail>
	*/ 
	public abstract PageContainer<Course> queryUserAllCourseListByUserId(Integer userId, PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询历史的课程
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract PageContainer<Course> queryUserHistoryCourseListByUserId(Integer userId,PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询所有班级 
	* @param userid
	* @return List<EngclassDetail>
	*/ 
	public abstract PageContainer<Engclass> queryUserAllEngclassByUserId(Integer userId,PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询当前正在进行的班级
	* @param userId
	* @return String
	*/ 
	public abstract  PageContainer<Engclass> queryUserNowEngclassByUserId(Integer userId,PageContainer pageContainer);
	
	
	/** 
	* @Description: 根据班级id 查询该班所有学生 
	* @param classid
	* @return List<User>
	*/ 
	public abstract  PageContainer<User> queryUserListByClassid(Integer classid,PageContainer pageContainer);
	
	
	/** 
	* @Description: 用户查询教师反馈信息 
	* @param classid
	* @param userid
	* @return List<TeacherBackInfo>
	*/ 
	public abstract  PageContainer<TeacherBackInfo> queryTeacherBackInfoByEngclassIdAndUserId(Integer engclassId,Integer userId,PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询用户某门课程下考勤记录
	* @param userid
	* @param engclass
	* @return List<TimeSheetDetail>
	*/ 
	public abstract  PageContainer<TimeSheet> queryTimeSheetByUserId(Integer userId,Integer engclassId,String queryDate,PageContainer pageContainer);
	
	
	
	/** 
	* @Description: 根据classid和日期查询该班级的考勤记录
	* @param classid
	* @param date
	* @return List<TimeSheetDetail>
	*/ 
	public abstract  PageContainer<TimeSheet> queryUserTimeSheetByEngclassId(Integer engclassId,Date date);
	
	
	/** 
	* @Description: 请假 
	* @param userId
	* @param classId
	* @param queryDate
	* @param leaveInfo
	* @return String
	*/ 

	public abstract String addTimeSheet(TimeSheet timeSheet);
	
	
	/** 
	* @Description: 根据账号信息，进行登陆校验
	* @param account
	* @return Boolean
	*/ 
	public abstract Boolean loginCheck(UserAccount account);
	
	
	/** 
	* @Description: 根据登录账号查询用户个人信息 
	* @param accountId
	* @return User
	*/ 
	public User queryUserByAccountId(Integer accountId);
	
	
	
	public boolean mergeEngclass(Integer oldEngclassId1,Integer oldEngclassId2,Integer engclassId);
	
	
	
}
