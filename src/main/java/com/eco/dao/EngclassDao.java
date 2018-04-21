package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Engclass;


/*
 * date:   2018年4月20日 下午10:31:04
 * author: Shixiaodong
 */
public interface EngclassDao extends BaseDao<Engclass> {

	public abstract List<EngclassDetail> getEngclassList(Integer teacherId);
	
	
	
}
