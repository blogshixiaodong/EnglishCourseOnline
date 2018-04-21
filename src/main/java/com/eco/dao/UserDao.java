package com.eco.dao;

import java.util.List;

import com.eco.bean.model.User;

/*
 * date:   2018年4月20日 下午10:18:27
 * author: Shixiaodong
 */
public interface UserDao extends BaseDao<User> {
	
	public abstract List<User> getUserListByEngclassId(Integer engclassId);
}
