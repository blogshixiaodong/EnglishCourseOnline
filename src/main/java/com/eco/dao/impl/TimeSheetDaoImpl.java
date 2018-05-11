package com.eco.dao.impl;

import java.util.Date;
import java.util.List;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.TimeSheet;
import com.eco.dao.TimeSheetDao;

/*
 * date:   2018年4月20日 下午11:14:45
 * author: Shixiaodong
 */
public class TimeSheetDaoImpl extends AbstractBaseDao<TimeSheet> implements TimeSheetDao {

	private PageContainer pageContainer;
	
	@Override
	public List<TimeSheet> selectTimeSheetByEnglassIdAndDate(Integer engclassId, Date date) {
		String hql = " SELECT t FROM TimeSheet t WHERE t.engclass.engclassId = ? AND STR_TO_DATE(t.recordTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return this.list(hql, pageContainer, engclassId, date);
	}

	@Override
	public void insertUserTimeSheet(List<TimeSheet> timeSheetList) {
		this.save(timeSheetList);
	}

	public PageContainer getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;
	}

}
