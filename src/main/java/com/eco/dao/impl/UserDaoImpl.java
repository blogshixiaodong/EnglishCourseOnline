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
	
	private PageContainer pageContainer;

	@Override
	public List<User> selectEngclassAllUserByEngclassId(Integer engclassId) {
		String hql = " SELECT u FROM User u LEFT JOIN u.engclassSet es WHERE es.engclassId = ? ";
		return this.list(hql, pageContainer, engclassId);
	}

	public PageContainer getPageContainer() {
		return pageContainer;
	}

	public void setPageContainer(PageContainer pageContainer) {
		this.pageContainer = pageContainer;
	}

}
