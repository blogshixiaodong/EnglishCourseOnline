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

	private PageContainer<TimeSheet> pageContainer;

	@Override
	public PageContainer<TimeSheet> selectTimeSheetByUserIdAndEngclassId(Integer userId, Integer engclassId) {
		String hql = "SELECT ts FROM TimeSheet ts LEFT JOIN ts.engclass ec LEFT JOIN ts.user u WHERE u.userId = ? and ec.engclassId = ?";
		return this.list(hql,pageContainer, userId,engclassId);
	}

	@Override
	public PageContainer<TimeSheet> selectTimeSheetByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId,Date queryDate) {
		String hql = "SELECT ts FROM TimeSheet ts LEFT JOIN ts.engclass ec LEFT JOIN ts.user u WHERE u.userId = ? and ec.engclassId = ? AND STR_TO_DATE(ts.recordTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return this.list(hql,pageContainer ,userId,engclassId,queryDate);
	}

	@Override
	public Integer countCourseByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate) {
		String hql = "SELECT COUNT(*) FROM User u LEFT JOIN u.engclassSet ec LEFT JOIN ec.courseRecord cr WHERE STR_TO_DATE(cr.startTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') AND u.userId = ? AND ec.engclassId = ? ";
		return ((Long) this.getUniqueResult(hql, queryDate,userId,engclassId)).intValue();
	}

	@Override
	public Integer countTimeSheetByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate) {
		String hql = "SELECT COUNT(*) FROM User u LEFT JOIN u.engclassSet ec LEFT JOIN ec.timeSheetSet ts WHERE u.userId = ? AND ec.engclassId = ? AND STR_TO_DATE(ts.recordTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return ((Long) this.getUniqueResult(hql,userId,engclassId,queryDate)).intValue();
	}

	@Override
	public void insertTimeSheet(TimeSheet timeSheet) {
		this.save(timeSheet);
	}
	
	@Override
	public PageContainer<TimeSheet> selectTimeSheetByEnglassIdAndDate(Integer engclassId, Date date) {
		String hql = " SELECT t FROM TimeSheet t WHERE t.engclass.engclassId = ? AND STR_TO_DATE(t.recordTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return this.list(hql, pageContainer, engclassId, date);
	}

	@Override
	public void insertUserTimeSheet(List<TimeSheet> timeSheetList) {
		this.save(timeSheetList);
	}
	
	public PageContainer<TimeSheet> getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer<TimeSheet> pageContainer) {
		this.pageContainer = pageContainer;
	}

}
