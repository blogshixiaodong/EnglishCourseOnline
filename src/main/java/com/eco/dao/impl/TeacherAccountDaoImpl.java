package com.eco.dao.impl;

import com.eco.bean.model.TeacherAccount;
import com.eco.dao.TeacherAccountDao;

public class TeacherAccountDaoImpl extends AbstractBaseDao<TeacherAccount> implements TeacherAccountDao {

	@Override
	public int countAccount(Integer id) {
		return this.executeHQLUpdate("SELECT COUNT(*) FROM TeacherAccount WHERE id = ?", id);
	}

	@Override
	public TeacherAccount selectAccount(Integer id) {
		return this.get(id);
	}

}
