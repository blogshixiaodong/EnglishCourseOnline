package com.eco.server;

import java.util.Date;
import java.util.List;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.Account;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.bean.model.User;
import com.eco.bean.model.UserBackInfo;
import com.eco.bean.model.UserClass;

public interface UserServer {
	
	
	//public abstract boolean login(Account account);
	
	/** 
	* @Description: 报名班级，用户班级记录及修改课程记录中报名人数
	* @param uc
	* @param crId
	* @return boolean
	*/ 
	/*public abstract boolean enrolmentClass(UserClass uc,Integer crId);*/
	

	
	/** 
	* @Description: 查看正在进行的课程 
	* @param userId
	* @param pageContainer
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryUserNowCourseListByUserId(Integer userId,PageContainer pageContainer);
	
	
	
	/** 
	* @Description: 查看所有进行的课程 
	* @param userId
	* @param pageContainer
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryUserAllCourseListByUserId(Integer userId, PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询历史的课程
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryUserHistoryCourseListByUserId(Integer userId,PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询所有班级 
	* @param userid
	* @return List<EngclassDetail>
	*/ 
	public abstract List<EngclassDetail> queryUserAllEngclassByUserId(Integer userId,PageContainer pageContainer);
	
	
	/** 
	* @Description: 查询当前正在进行的班级
	* @param userId
	* @return String
	*/ 
	public abstract List<EngclassDetail> queryUserNowEngclassByUserId(Integer userId);
	
	
	/** 
	* @Description: 根据班级id 查询该班所有学生 
	* @param classid
	* @return List<User>
	*/ 
	public abstract List<User> queryUserListByClassid(Integer classid,PageContainer pageContainer);
	
	
	/** 
	* @Description: 用户查询教师反馈信息 
	* @param classid
	* @param userid
	* @return List<TeacherBackInfo>
	*/ 
	public abstract List<BackInfoDetail> queryTeacherBackInfoByEngclassIdAndUserId(Integer engclassId,Integer userId);
	
	
	/** 
	* @Description: 查询用户某门课程下考勤记录
	* @param userid
	* @param engclass
	* @return List<TimeSheetDetail>
	*/ 
	public abstract List<TimeSheetDetail> queryTimeSheetByUserId(Integer userId,Integer engclassId,String queryDate);
	
	
	
	/** 
	* @Description: 根据classid和日期查询该班级的考勤记录
	* @param classid
	* @param date
	* @return List<TimeSheetDetail>
	*/ 
	public abstract List<TimeSheetDetail> queryUserTimeSheetByEngclassId(Integer engclassId,Date date);
	
	
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
	public abstract Boolean loginCheck(Account account);
	
	
	/** 
	* @Description: 根据登录账号查询用户个人信息 
	* @param accountId
	* @return User
	*/ 
	public User queryUserByAccountId(Integer accountId);
	
	
	
	public boolean mergeEngclass(Integer oldEngclassId1,Integer oldEngclassId2,Integer engclassId);
	
	
	
}
