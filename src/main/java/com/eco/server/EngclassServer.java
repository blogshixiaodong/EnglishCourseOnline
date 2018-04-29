package com.eco.server;

import java.util.List;

import com.eco.bean.model.User;

/*
 * date:   2018年4月24日 上午10:16:14
 * author: Shixiaodong
 */
public interface EngclassServer {

	public abstract List<User> queryUserListByEngclassId(Integer engclassId);
	
}
