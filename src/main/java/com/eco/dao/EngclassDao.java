package com.eco.dao;

import java.util.List;

import com.eco.bean.model.Engclass;
import com.eco.bean.model.User;

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
	
	
	
}
