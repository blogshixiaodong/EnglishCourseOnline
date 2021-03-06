package com.eco.server;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.User;

/*
 * date:   2018年4月24日 上午10:16:14
 * author: Shixiaodong
 */
public interface EngclassServer {
  
	/**
	 * 根据班级编号获取这个班级所有的学生列表
	 * @param classId
	 * @return
	 */
	public abstract List<User> queryUserListByEngclassId(Integer engclassId);
	
	public abstract List<Engclass> queryEnglclassListByCourseId(Integer courseId);
	
	public abstract EngclassDetail queryEngclassDetailByEngclasId(Integer engclassId);
	
	public abstract Long addUserClass(Integer userId, Integer engclassId);
	
	public abstract int queryEngclassIdByCourseRecordId(Integer courseRecordId); 
	
	public abstract long create(Engclass engclass);
	
	
	
	public abstract int queryCourseRecordIdByEngclassId(Integer engclassId);
	
	
	
}
