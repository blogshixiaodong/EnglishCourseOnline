package com.eco.dao.impl;

import java.util.List;
import com.eco.bean.model.UserBackInfo;
import com.eco.dao.UserBackInfoDao;

/**
 * @author lenovo
 *
 */
public class UserBackInfoDaoImpl extends AbstractBaseDao<UserBackInfo> implements UserBackInfoDao {

	@Override
	public List<UserBackInfo> selectUserBackInfoByEngclassId(Integer engclassId) {
		String hql = " SELECT ubi FROM UserBackInfo ubi WHERE ubi.engclass.engclassId = ?";
		return this.list(hql, engclassId);
	}

}
