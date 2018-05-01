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

import com.eco.bean.model.PageContainer;
import com.eco.dao.BaseDao;
import com.eco.dao.PageDao;
import com.sxd.util.jdbc.JdbcUtils;

/*
 * date:   2018/4/10 2:41:47
 * author: Shixiaodong
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T>, PageDao {
	
	private Connection connection;
	
	private QueryRunner query = new QueryRunner();
	
	protected Boolean autoCommit = true;

	protected Boolean isPaging = false;
	
	protected PageContainer pageContainer;
	
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
	
	private T doQueryForObject(String sql, Object... params) {
		T bean = null;
		try {
			bean = (T) query.query(connection, sql, new BeanHandler<>(getBeanClass()), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}
	
	protected void afterQueryForObject() {
		close();
	}
	
	@Override
	public <V> V queryForObjectEx(String sql, Class<V> clazz, Object... params) {
		String convertSql = initQueryForObjectEx(sql);
		V bean =  doQueryForObjectEx(convertSql, clazz, params);
		afterQueryForObjectEx();
		return bean;
	}

	private String initQueryForObjectEx(String sql) {
		init();
		return beforeQueryForObjectEx(sql);
	}
	
	protected String beforeQueryForObjectEx(String sql) {
		return sql;
	}
	
	
	private <V> V doQueryForObjectEx(String sql, Class<V> clazz, Object[] params) {
		V bean = null;
		try {
			bean = (V) query.query(connection, sql, new BeanHandler<>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bean;
	}

	protected void afterQueryForObjectEx() {
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
	
	private List<T> doQueryForList(String sql, Object... params) {
		List<T> beanList = null;
		try {
			beanList = (List<T>) query.query(connection, sql, new BeanListHandler<>(getBeanClass()), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	protected void afterQueryForList() {
		close();
	}
	
	@Override
	public <V> List<V> queryForListEx(String sql, Class<V> clazz, Object... params) {
		String convertSql = initQueryForListEx(sql);
		List<V> beanList = doQueryForListEx(convertSql, clazz, params);
		afterQueryForListEx();
		return beanList;
	}
	
	private String initQueryForListEx(String sql) {
		init();
		return beforeQueryForList(sql);
	}
	
	protected String beforeQueryForListEx(String sql) {
		return sql;
	}
	
	private <V> List<V> doQueryForListEx(String sql, Class<V> clazz, Object... params) {
		List<V> beanList = null;
		try {
			beanList = (List<V>) query.query(connection, sql, new BeanListHandler<>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beanList;
	}
	
	protected void afterQueryForListEx() {
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
		closePaging();
	}
	
	protected Boolean isAutoCommit() {
		return autoCommit;
	}
	
	protected void setAutoCommit(Boolean isAutoCommit) {
		this.autoCommit = isAutoCommit;
	}
		
	@SuppressWarnings("unchecked")
	public Class<T> getBeanClass() {
		Type type = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) type).getActualTypeArguments();  
        return (Class<T>) params[0];
	}

	@Override
	public Boolean isPaging() {
		return isPaging;
	}
	
	@Override
	public void beginPaging(PageContainer pageContainer) {
		this.isPaging = true;
		this.pageContainer = pageContainer;
	}

	@Override
	public void closePaging() {
		this.isPaging = false;
		this.pageContainer = null;	
	}
	
}
