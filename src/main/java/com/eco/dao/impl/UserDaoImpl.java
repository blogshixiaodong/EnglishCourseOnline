package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.User;
import com.eco.dao.UserDao;

/*
 * date:   2018年4月20日 下午10:18:16
 * author: Shixiaodong
 */
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {
	
	@Override
	public List<User> getUserListByEngclassId(Integer engclassId) {
		String sql = "SELECT u.userid, username, age, idcard, sex, imgurl " +
				     "FROM user_class uc, user u " + 
				     "WHERE uc.userid = u.userid AND uc.classid = ?";
		return this.queryForList(sql, engclassId);
	}
}
