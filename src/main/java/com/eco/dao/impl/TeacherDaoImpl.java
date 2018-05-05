package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.Teacher;
import com.eco.dao.TeacherDao;

/*
 * date:   2018年4月19日 上午9:44:47
 * author: Shixiaodong
 */
public class TeacherDaoImpl extends AbstractBaseDao<Teacher> implements TeacherDao {

	@Override
	public Long insert(Teacher teacher) {
		String sql = "INSERT INTO teacher(teacherid, idcard, name, sex, age, phone, address, imgurl) VALUES(?, ?, ?, ?, ?, ?)";
		return this.insert(sql, teacher.getIdCard(), teacher.getTeacherName(), teacher.getSex(), teacher.getAge(), teacher.getPhone(), teacher.getAddress(), teacher.getImgUrl());	
	}

	@Override
	public Teacher selectTeacher(Integer teacherid) {
		String sql = "SELECT * FROM teacher WHERE teacherid = ?";
		return this.queryForObjectEx(sql, Teacher.class, teacherid);
	}

	@Override
	public List<Teacher> selectAllTeaher() {
		String sql = "SELECT * FROM teacher";
		return this.queryForList(sql, new Object[] {});
	}
	
	
	
}
