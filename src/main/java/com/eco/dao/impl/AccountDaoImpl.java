package com.eco.dao.impl;

import com.eco.bean.model.Account;
import com.eco.dao.AccountDao;

public class AccountDaoImpl extends AbstractBaseDao<Account> implements AccountDao {

	@Override
	public boolean queryAccountByid(Integer id, String password) {
		String sql = "SELECT * FROM account WHERE id = ? AND password = ?";
		return this.queryForObject(sql, id,password) == null;
	}



	

}
