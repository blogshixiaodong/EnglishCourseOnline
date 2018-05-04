package com.eco.dao.impl;

import com.eco.bean.model.Account;
import com.eco.dao.AccountDao;

public class AccountDaoImpl extends AbstractBaseDao<Account> implements AccountDao {

	@Override
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
