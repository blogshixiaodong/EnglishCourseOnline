package com.eco.dao.impl;

import com.eco.bean.model.UserAccount;
import com.eco.dao.UserAccountDao;

public class UserAccountDaoImpl extends AbstractBaseDao<UserAccount> implements UserAccountDao {

	@Override
	public Integer countAccount(Integer accountId) {
		return ((Long) this.getUniqueResult("SELECT COUNT(*) FROM UserAccount WHERE id = ?", accountId)).intValue();
	}

	@Override
	public UserAccount selectAccount(Integer id) {
		return this.get(id);
	}

}
