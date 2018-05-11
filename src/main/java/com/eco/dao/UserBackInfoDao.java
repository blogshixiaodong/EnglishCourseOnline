package com.eco.dao;

import java.util.List;

import com.eco.bean.model.UserBackInfo;


/**
 * @author lenovo
 *
 */
public interface UserBackInfoDao {
	
	/**
	 * 根据班级编号查询学生反馈信息
	 * @param engclassId
	 * @return
	 */
	List<UserBackInfo> selectUserBackInfoByEngclassId(Integer engclassId);
	
}
