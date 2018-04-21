package com.eco.dao;

import java.util.Date;
import java.util.List;

import com.eco.bean.dto.CourseDetail;
import com.eco.bean.dto.TimeSheetDetail;
import com.eco.bean.model.Teacher;
import com.eco.bean.model.User;

/*
 * date:   2018年4月19日 上午9:45:03
 * author: Shixiaodong
 */
public interface TeacherDao extends BaseDao<Teacher> {
	
	public abstract int insertTeacher(Teacher teacher);
	

	
	
	

}
