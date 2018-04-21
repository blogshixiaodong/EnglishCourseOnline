package com.eco.dao;

import java.util.List;

import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.TimeSheet;

/*
 * date:   2018年4月20日 下午11:07:27
 * author: Shixiaodong
 */
public interface TimeSheetDao extends BaseDao<TimeSheet> {
	
	public abstract List<TimeSheetDetail> getTimeSheetDetail(Integer engclass);
}
