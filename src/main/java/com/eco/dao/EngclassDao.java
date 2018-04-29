package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;


/*
 * date:   2018年4月20日 下午10:31:04
 * author: Shixiaodong
 */
public interface EngclassDao extends BaseDao<Engclass> {


	/** 
	* @Description: 开设班级 
	* @param engclass void
	*/ 
	public abstract void createEngClass(Engclass engclass);

	public abstract List<EngclassDetail> getEngclassList(Integer teacherId);
	
	
	
	/** 
	* @Description: 查询用户班级信息
	* @param userid
	* @return List<EngclassDetail>
	*/ 
	public List<EngclassDetail> queryUserAllEngclassList(Integer userid);
	
	/** 
	* @Description: 查询用户当前正在进行的班级信息 
	* @param userId
	* @return List<EngclassDetail>
	*/ 
	public abstract List<EngclassDetail> queryNowUserEngclassList(Integer userId);
	
	
	/** 
	* @Description: 根据班级查询教师id 
	* @param classId
	* @return Integer
	*/ 
	public abstract Integer queryTeacherIdByEngclassId(Integer classId);
	

	
	public Engclass getEngclassByClassId(Integer teacherId, Integer classId);
	 
	public List<Engclass> getEngclassListByName(Integer teacherId, String className);
	
	public EngclassDetail getEngclassDetail(Integer classId);
	
}
