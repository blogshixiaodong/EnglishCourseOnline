package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.model.TeacherBackInfo;
import com.eco.bean.model.UserClass;

public interface TeacherBackInfoDao {
	
	
	
	public List<BackInfoDetail> queryBackInfoByUserClass(UserClass userClass);
	
	public abstract List<BackInfoDetail> getBackInfoByTeacherIdAndClassId(Integer teacherId, Integer engclassId);
	
	public abstract Boolean insertBackInfo(TeacherBackInfo teacherBackInfo);
	
}
