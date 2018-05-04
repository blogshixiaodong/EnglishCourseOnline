package com.eco.server.impl;

import java.util.ArrayList;
import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.EngclassDetail;
import com.eco.bean.model.Account;
import com.eco.bean.model.Engclass;
import com.eco.bean.model.PageContainer;
import com.eco.dao.CourseDao;
import com.eco.dao.EngclassDao;
import com.eco.dao.TeacherDao;
import com.eco.dao.impl.CourseDaoImpl;
import com.eco.dao.impl.EngclassDaoImpl;
import com.eco.dao.impl.TeacherDaoImpl;
import com.eco.server.TeacherServer;

/*
 * date:   2018年4月21日 上午11:06:01
 * author: Shixiaodong
 */
public class TeacherServerImpl implements TeacherServer {

	private CourseDao courseDao = new CourseDaoImpl();
	
	private EngclassDao engclassDao = new EngclassDaoImpl();
	
	private TeacherDao teacherDao = new TeacherDaoImpl();
	
	@Override
	public List<CourseDetail> queryNowCourseDetailListByTeacherId(Integer teacherId,PageContainer pageContainer) {
		
		pageContainer.setPageSize(5);
		pageContainer.setRecordCount(courseDao.countNowCourseDetailByTeacherId(teacherId));
		
		courseDao.beginPaging(pageContainer);
		return courseDao.selectTeacherNowCourseDetailListByTeacherId(teacherId);
	}

	@Override
	public List<CourseDetail> queryHistoryCourseDetailListByTeacherId(Integer teacherId,PageContainer pageContainer) {
		
		pageContainer.setPageSize(5);
		pageContainer.setRecordCount(courseDao.countHistoryCourseDetailByTeacherId(teacherId));
		
		return courseDao.selectTeacherIdHistoryCourseDetailListByTeacherId(teacherId);
	}

	@Override
	public List<CourseDetail> queryAllCourseDetailListByTeacherId(Integer teacherId, PageContainer pageContainer) {
		pageContainer.setPageSize(5);
		courseDao.beginPaging(pageContainer);
		pageContainer.setRecordCount(courseDao.countAllCourseDetailByTeacherId(teacherId));
		courseDao.beginPaging(pageContainer);
		return courseDao.selectAllCourseDetailListByTeacherId(teacherId);
	}
	
	@Override
	public List<EngclassDetail> queryEngclassListByTeacherId(Integer teacherId,PageContainer pageContainer) {
		
		pageContainer.setPageSize(5);
		pageContainer.setRecordCount(engclassDao.countAllEngclassDetailByTeacher(teacherId));
		engclassDao.beginPaging(pageContainer);
		return engclassDao.selectEngclassListByTeacherId(teacherId);
	}

	@Override
	public List<Engclass> queryEngclassByCondition(Integer teacherId, Integer classId, String className) {
		List<Engclass> engclassList = null;
		if(classId == null) {
			if(className == null || "".equals(className)) {
				return null;
			} else {
				engclassList = engclassDao.selectEngclassListByTeacherIdAndEngclassName(teacherId, className);
			}
		} else {
			engclassList = new ArrayList<>();
			engclassList.add(engclassDao.selectEngclassByTeacherIdAndEngclassId(teacherId, classId));
		}
		return engclassList;
	}

	@Override
	public EngclassDetail queryEngclassDetailByEngclassId(Integer classId) {
		return engclassDao.selectEngclassDetailByEngclassId(classId);
	}
	
	@Override
	public Boolean loginCheck(Account account) {
		//账号是否存在
		if(teacherDao.countAccount(account.getId()) != 1) {
			return false;
		}
		Account dbAccount = teacherDao.selectAccount(account.getId());
		if(!dbAccount.getPassword().equals(account.getPassword())) {
			return false;
		}
		account.setRoleId(dbAccount.getRoleId());
		account.setRole(dbAccount.getRole());
		return true;
	}
	
}
