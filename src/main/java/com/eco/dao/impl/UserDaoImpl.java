package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.User;
import com.eco.dao.UserDao;

/*
 * date:   2018年4月20日 下午10:18:16
 * author: Shixiaodong
 */
public class UserDaoImpl extends AbstractBaseDao<User> implements UserDao {
	
	private PageContainer<User> pageContainer;

	@Override
	public PageContainer<User> selectEngclassAllUserByEngclassId(Integer engclassId) {
		String hql = " SELECT u FROM User u LEFT JOIN u.engclassSet es WHERE es.engclassId = ? ";
		return this.list(hql, pageContainer, engclassId);
	}
	
	public List<User> selectUserIdAndUsernameByEngclassId(Integer engclassId) {
		//String hql = " SELECT new User(userId, username) FROM User u LEFT JOIN u.engclassSet es WHERE es.engclassId = ? ";
		String hql = " SELECT u FROM User u LEFT JOIN u.engclassSet es WHERE es.engclassId = ? ";
		return this.list(hql, engclassId);
	}
	
	public PageContainer<User> getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer<User> pageContainer) {
		this.pageContainer = pageContainer;
	}

	@Override
	public User selectUserByUserId(Integer userId) {
		return this.get(userId) ;
	}

}
