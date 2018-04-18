package com.eco.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.eco.dao.BaseDao;

import com.sxd.util.jdbc.JdbcUtils;

/*
 * date:   2018年4月10日 下午2:41:47
 * author: Shixiaodong
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T> {
	
	private Connection connection;
	private QueryRunner query;
	protected Boolean autoCommit = true;

	
	@Override
	public final int insert(String sql, Object... params) {
		String convertSql = initInsert(sql);
		int generatedKeys = doInsert(convertSql, params);
		afterInsert();
		return generatedKeys;
	}
	
	private String initInsert(String sql) {
		init();
		return beforeInsert(sql);
	}
	
	protected String beforeInsert(String sql) {	
		return sql;
	}
	
	private int doInsert(String sql, Object... params) {
		int insertRowCount = -1;
		try {
			insertRowCount = query.insert(connection, sql, new ScalarHandler<Integer>(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return insertRowCount;
	}
	
	
	protected void afterInsert() {
		close();
	}

	
	@Override
	public int update(String sql, Object... params) {
		String convertSql = initUpdate(sql);
		int updateRowCount = doUpdate(convertSql, params);
		afterUpdate();
		return updateRowCount;
	}
	
	private String initUpdate(String sql) {
		init();
		return beforeUpdate(sql);
	}

	protected String beforeUpdate(String sql) {
		return sql;
	}
	
	private int doUpdate(String sql, Object... params) {
		int updateRowCount = -1;
		try {
			updateRowCount = query.update(connection, sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updateRowCount;
	}
	
	protected void afterUpdate() {
		close();
	}
	
	@Override
	public Object queryForValue(String sql, Object... params) {
		String convertSql = initQueryForValue(sql);
		Object value = doQueryForValue(convertSql, params);
		afterQueryForValue();
		return value;
	}
	
	private String initQueryForValue(String sql) {
		init();
		return beforeQueryForObject(sql);
	}
	
	protected String beforeQueryForValue(String sql) {
		return sql;
	}
	
	private Object doQueryForValue(String sql, Object... params) {
		Object value = null;
		try {
			value = query.query(connection, sql, new ScalarHandler<>(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	protected void afterQueryForValue() {
		close();
	}
	

	public T queryForObject(String sql, Object... params) {
		String convertSql = initQueryForObject(sql);
		T bean = doQueryForObject(convertSql, params);
		afterQueryForObject();
		return bean;
	}
	
	private String initQueryForObject(String sql) {
		init();
		return beforeQueryForObject(sql);
	}
	
	protected String beforeQueryForObject(String sql) {
		return sql;
	}
	
	@SuppressWarnings("unchecked")
	private T doQueryForObject(String sql, Object... params) {
		T bean = null;
		try {
			bean = (T) query.query(connection, sql, new BeanHandler<>(getClass()), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	protected void afterQueryForObject() {
		close();
	}
	
	public List<T> queryForList(String sql, Object... params) {
		String convertSql = initQueryForList(sql);
		List<T> beanList = doQueryForList(convertSql, params);
		afterQueryForList();
		return beanList;
	}
	
	private String initQueryForList(String sql) {
		init();
		return beforeQueryForList(sql);
	}
	protected String beforeQueryForList(String sql) {
		return sql;
	}
	
	@SuppressWarnings("unchecked")
	private List<T> doQueryForList(String sql, Object... params) {
		List<T> beanList = null;
		try {
			beanList = (List<T>) query.query(connection, sql, new BeanListHandler<>(getClass()), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	protected void afterQueryForList() {
		close();
	}
	
	public void init() {
		try {
			if(connection == null || connection.isClosed()) {
				connection = JdbcUtils.newInstance().getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		if(isAutoCommit()) {	
			try {
				if(connection != null && !connection.isClosed()) {
					connection.close();
					connection = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected Boolean isAutoCommit() {
		return autoCommit;
	}
	
	protected void setAutoCommit(Boolean isAutoCommit) {
		this.autoCommit = isAutoCommit;
	}
		
	public Class<?> getBeanClass() {
		Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        return (Class<?>) params[0];
	}
	
	 
	
}
