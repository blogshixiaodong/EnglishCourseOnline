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

	PageContainer PageContainer;

	@Override
	public List<TimeSheet> selectTimeSheetByUserIdAndEngclassId(Integer userId, Integer engclassId) {
		String hql = "FROM TimeSheet ts LEFT JOIN FETCH ts.engclass ec LEFT JOIN FETCH ts.user u WHERE u.userId = ? and ec.engclassId = ?";
		return this.list(hql, userId,engclassId);
	}

	@Override
	public List<TimeSheet> selectTimeSheetByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId,Date queryDate) {
		String hql = "FROM TimeSheet ts LEFT JOIN FETCH ts.engclass ec LEFT JOIN FETCH ts.user u WHERE u.userId = ? and ec.engclassId = ? AND STR_TO_DATE(ts.recordTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return this.list(hql, userId,engclassId,queryDate);
	}

	//判断用户在这个班级的这一天有没有课程，没有请假失败
	@Override
	public Integer countCourseByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate) {
		String hql = "SELECT COUNT(*) FROM User u ELFT JOIN u.engclassSet ec LEFT JOIN ec.courseRecord cr WHERE STR_TO_DATE(cr.startTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') AND u.userId = ? AND ec.engclassId = ? ";
		return (Integer) this.getUniqueResult(hql, userId,engclassId);
	}

	@Override
	public Integer countTimeSheetByUserIdAndEngclassIdAndDate(Integer userId, Integer engclassId, Date queryDate) {
		String hql = "SELECT COUNT(*) FROM User u LEFT JOIN u.engclassSet ec LEFT JOIN ec.timeSheetSet ts WHERE u.userId = ? AND ec.engclassId = ? AND STR_TO_DATE(ts.recordTime,'%Y-%m-%d') = STR_TO_DATE(?,'%Y-%m-%d') ";
		return (Integer) this.getUniqueResult(hql,userId,engclassId,queryDate);
	}

	@Override
	public void insertTimeSheet(TimeSheet timeSheet) {
		this.save(timeSheet);
	}
	
	public PageContainer getPageContainer() {
		return PageContainer;
	}

	public void setPageContainer(PageContainer pageContainer) {
		PageContainer = pageContainer;
	}
	
	

}
