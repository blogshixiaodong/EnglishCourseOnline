package com.eco.dao;

import java.util.List;

/*
 * date:   2018年4月10日 下午2:34:08
 * author: Shixiaodong
 */
public interface BaseDao<T> {
	
	/*
	 * 返回数据库自增主键
	 * */
	int insert(String sql, Object... params);
	
	/*
	 * 返回 insert, delete，update影响行数
	 * */
	int update(String sql, Object... params);
	
	/*
	 * 返回单值
	 * */
	Object queryForValue(String sql, Object... params);
	
	/*
	 * 返回对象
	 * */
	T queryForObject(String sql, Object... params);
	
	/*
	 * 返回对象列表
	 * */
	List<T> queryForList(String sql, Object... params);
	
}
