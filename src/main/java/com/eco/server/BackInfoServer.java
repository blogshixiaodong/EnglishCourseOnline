package com.eco.server;

import java.util.List;

import com.eco.bean.dto.BackInfoDetail;

/*
 * date:   2018年4月24日 上午11:23:58
 * author: Shixiaodong
 */
public interface BackInfoServer {
		
	public abstract List<BackInfoDetail> getBackInfoByTeacherIdAndClassId(Integer teacherId, Integer engclassId);

}	
