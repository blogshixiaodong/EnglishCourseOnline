package com.eco.server;

import java.util.List;
import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.TimeSheet;
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
	public abstract boolean enrolmentClass(UserClass uc,Integer crId);
	

	/** 
	* @Description: 查询正在进行的courseDetail 
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryNowCourseDetail(Integer userid);
	
	
	/** 
	* @Description: 查询所有的courseDetail 
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryAllCourseDetail(Integer userid);
	
	
	/** 
	* @Description: 查询历史的courseDetail 
	* @param userid
	* @return List<CourseDetail>
	*/ 
	public abstract List<CourseDetail> queryHistoryCourseDetail(Integer userid);
	
	
	/** 
	* @Description: 查询所在班级 
	* @param userid
	* @return List<EngclassDetail>
	*/ 
	public abstract List<EngclassDetail> queryEngclassDetail(Integer userid);
	
	
	/** 
	* @Description: 用户添加反馈信息 
	* @param info
	* @return 
	*/ 
	public abstract void createUserBackInfo(UserBackInfo backInfo);
	
	
	/** 
	* @Description: 用户查询教师反馈信息 
	* @param classid
	* @param userid
	* @return List<TeacherBackInfo>
	*/ 
	public abstract List<BackInfoDetail> queryTeacherBackInfo(Integer classid,Integer userid);
	
	
	/** 
	* @Description: 查询用户某门课程下考勤记录
	* @param userid
	* @param engclass
	* @return List<TimeSheetDetail>
	*/ 
	public abstract List<TimeSheetDetail> queryTimeSheetDetailByUser(Integer userid,Integer engclassid);
	
	
	/** 
	* @Description: 用户请假
	* @param timeSheet
	* @return void
	*/ 
	public abstract boolean createTimeSheet(TimeSheet timeSheet);
	
	
	
}