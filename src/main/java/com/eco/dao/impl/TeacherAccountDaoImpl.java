package com.eco.dao.impl;

import com.eco.bean.model.TeacherAccount;
import com.eco.dao.TeacherAccountDao;

public class TeacherAccountDaoImpl extends AbstractBaseDao<TeacherAccount> implements TeacherAccountDao {

	@Override
	public Integer countAccount(Integer id) {
		return ((Long) this.getUniqueResult("SELECT COUNT(*) FROM TeacherAccount WHERE id = ?", id)).intValue();
	}

	@Override
	public TeacherAccount selectAccount(Integer id) {
		return this.get(id);
	}

}
