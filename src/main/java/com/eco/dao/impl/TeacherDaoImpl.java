package com.eco.dao.impl;

import com.eco.bean.model.Account;
import com.eco.bean.model.Teacher;
import com.eco.dao.TeacherDao;

/*
 * date:   2018年4月19日 上午9:44:47
 * author: Shixiaodong
 */
public class TeacherDaoImpl extends AbstractBaseDao<Teacher> implements TeacherDao {

	@Override
	public int insert(Teacher teacher) {
		String sql = "INSERT INTO teacher(teacherid, idcard, name, sex, age, phone, address, imgurl) VALUES(?, ?, ?, ?, ?, ?)";
		return this.insert(sql, teacher.getIdCard(), teacher.getTeacherName(), teacher.getSex(), teacher.getAge(), teacher.getPhone(), teacher.getAddress(), teacher.getImgUrl());	
	}
	
	public int countAccount(Integer id) {
		String sql = "SELECT count(*) FROM account WHERE id = ?;";
		return Integer.parseInt(this.queryForValue(sql, id).toString());
	}

	@Override
	public Account selectAccount(Integer id) {
		String sql = "SELECT * FROM account WHERE id = ?";
		return this.queryForObjectEx(sql, Account.class, id);
	}
	
}
