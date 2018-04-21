package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;
import com.eco.bean.model.UserBackInfo;
import com.eco.bean.model.UserClass;

/**
 * @author lenovo
 *
 */
public interface UserBackInfoDao {
	
	
	
	
	/** 
	* @Description: 根据用户班级对象，查询反馈信息 
	* @param userClass
	* @return List<BackInfoDetail>
	*/ 
	List<BackInfoDetail> queryBackInfoByUserClass(UserClass userClass);
	
	
	boolean createUserBackInfo(UserBackInfo backInfo);
	
	
	public abstract List<BackInfoDetail> queryBackInfoByEngclass(Integer engclassId);
	
	
}
