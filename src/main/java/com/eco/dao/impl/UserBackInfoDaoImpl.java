package com.eco.dao.impl;

import java.util.List;

import com.eco.bean.model.PageContainer;
import com.eco.bean.model.UserBackInfo;
import com.eco.dao.UserBackInfoDao;

/**
 * @author lenovo
 *
 */
public class UserBackInfoDaoImpl extends AbstractBaseDao<UserBackInfo> implements UserBackInfoDao {

	private PageContainer<UserBackInfo> pageContainer;
	
	@Override
	public PageContainer<UserBackInfo> selectUserBackInfoByEngclassId(Integer engclassId) {
		String hql = " SELECT ubi FROM UserBackInfo ubi WHERE ubi.engclass.engclassId = ?";
		return this.list(hql, pageContainer, engclassId);
	}

	@Override
	public List<UserBackInfo> selectUserBackInfoByUserIdAndEngclassId(Integer userId, Integer engclassId) {
		String hql = "SELECT ubi FROM User u LEFT JOIN u.engclassSet ec LEFT JOIN ec.userBackInfoSet ubi WHERE u.userId = ? AND ec.engclassId = ? ";
		return this.list(hql, userId,engclassId);
	}

	@Override
	public void insertUserBackInfo(UserBackInfo userBackInfo) {
		save(userBackInfo);
	}

	@Override
	public PageContainer<UserBackInfo> getPageContainer() {
		return this.pageContainer;
	}

	@Override
	public void setPageContainer(PageContainer<UserBackInfo> pageContainer) {
		this.pageContainer = pageContainer;
	}

}
