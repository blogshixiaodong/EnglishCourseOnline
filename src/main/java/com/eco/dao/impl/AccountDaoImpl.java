package com.eco.dao.impl;

import com.eco.bean.model.TeacherAccount;
import com.eco.dao.AccountDao;

public class AccountDaoImpl extends AbstractBaseDao<TeacherAccount> implements AccountDao {

	@Override
	public int countAccount(Integer id) {
		String sql = "SELECT count(*) FROM account WHERE id = ?;";
		return Integer.parseInt(this.queryForValue(sql, id).toString());
	}

	@Override
	public TeacherAccount selectAccount(Integer id) {
		String sql = "SELECT * FROM account WHERE id = ?";
		return this.queryForObjectEx(sql, TeacherAccount.class, id);
	}

	
	
}
