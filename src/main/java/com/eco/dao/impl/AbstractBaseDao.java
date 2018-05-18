package com.eco.dao.impl;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.eco.bean.model.PageContainer;
import com.eco.dao.BaseDao;
import com.eco.util.ReflectUtils;


/*
 * date:   2018/4/10 2:41:47
 * author: Shixiaodong
 */
public abstract class AbstractBaseDao<T> implements BaseDao<T> {

	private static Configuration configuration;
	
	protected Class<T> entityClass;
	  
    protected SessionFactory sessionFactory;
    
    protected Session session;
    
    protected Transaction transaction;
    
    protected Boolean autoCommit = true;
	
    static {
    	configuration = new Configuration().configure();
    }
    
    public AbstractBaseDao() {
    	sessionFactory = configuration.buildSessionFactory();
//    	session = getSession();
//		transaction = session.beginTransaction();
		entityClass = ReflectUtils.getClass(getClass());
    }
    
	@Override
	public Object save(T entity) {
		Object identifier = null;
		session = getSession();
		if(getAutoCommit()) {
			transaction = session.beginTransaction();
			identifier = session.save(entity);
			commit();
		} else {
			identifier = session.save(entity);	
		}
		return identifier;
	}

	@Override
	public void save(List<T> list) {
		this.setAutoCommit(false);
		session = getSession();
		transaction = session.beginTransaction();
		for(T t : list) {
			save(t);
		}
		commit();
	}

	@Override
	public void delete(T entity) {
		session = getSession();
		if(getAutoCommit()) {
			transaction = session.beginTransaction();
			session.delete(entity);
			commit();
		} else {
			session.delete(entity);
		}
	}

	@Override
	public void delete(List<T> list) {
		this.setAutoCommit(false);
		session = getSession();
		transaction = session.beginTransaction();
		for(T t : list) {
			delete(t);
		}
		commit();
	}

	@Override
	public void update(Object entity) {
		session = getSession();
		if(getAutoCommit()) {
			transaction = session.beginTransaction();
			session.update(entity);
			commit();
		} else {
			session.update(entity);
		}
	}

	@Override
	public void update(List<T> list) {
		this.setAutoCommit(false);
		session = getSession();
		transaction = session.beginTransaction();
		for(T t : list) {
			update(t);
		}
		commit();
	}

	@Override
	public void saveOrUpdate(Object entity) {
		session = getSession();
		if(getAutoCommit()) {
			transaction = session.beginTransaction();
			session.saveOrUpdate(entity);
			commit();
		}else {
			session.saveOrUpdate(entity);
		}
	}

	@Override
	public void saveOrUpdate(List<T> list) {
		this.setAutoCommit(false);
		session = getSession();
		transaction = session.beginTransaction();
		for(T t : list) {
			saveOrUpdate(t);
		}
		commit();
	}

	@Override
	public Integer executeSQLUpdate(String sql, Object... params) {
		session = getSession();
		transaction = session.beginTransaction();
		NativeQuery nativeQuery = session.createNativeQuery(sql);
		setParameter(nativeQuery, params);
		Integer result = nativeQuery.executeUpdate();
		commit();
		return result;
	}

	@Override
	public Integer executeHQLUpdate(String hql, Object... params) {
		session = getSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery(hql);
		setParameter(query, params);
		Integer result = query.executeUpdate();
		commit();
		return result;
	}

	@Override
	public T get(Serializable id) {
		T t = getSession().get(entityClass, id);
		closeSession();
		return t;
	}


	@Override
	public T get(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		List<T> list = query.list();
		if(list == null || list.isEmpty()) {
			return null;
		}
		closeSession();
		return list.get(0);
	}

	@Override
	public List<T> list(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		List<T> list = query.list();
		closeSession();
		return list;
	}


	@Override
	public PageContainer<T> list(String hql, PageContainer<T> pageContainer, Object... params) {
		Query query = getSession().createQuery(hql.toString());
		int pageSize = pageContainer.getPageSize();
		int currentPageNo = pageContainer.getCurrentPageNo();
        if (pageSize > 0 && currentPageNo > 0) {  
            query.setFirstResult((currentPageNo < 2) ? 0 : (currentPageNo - 1) * pageSize);  
            query.setMaxResults(pageSize);  
        }  
        setParameter(query, params);  
        
        List<T> list = query.list();
        System.out.println(entityClass.getSimpleName());
        String countString = "SELECT COUNT(*) " + hql.substring(hql.indexOf("FROM"));
        query = getSession().createQuery(countString);
        setParameter(query, params);
        pageContainer.setRecordCount(Integer.parseInt(query.uniqueResult().toString()));
        pageContainer.setList(list);
        closeSession();
        return pageContainer;  
	}
	
	@Override
	public Object getUniqueResult(String hql, Object... params) {
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		Object result = query.uniqueResult();
		closeSession();
		return result;
	}

	public Session getSession() {
		if(session == null || !session.isOpen()) {
			if(sessionFactory.isClosed()) {
				sessionFactory = configuration.buildSessionFactory();
			}
			session = sessionFactory.openSession();	
		}
		return session;
	}
	
	public void commit() {
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
	
	public void rollback() {
		transaction.rollback();
		session.close();
		sessionFactory.close();
	}
	
	public void closeSession() {
		session.close();
		session = null;
	}
	
	private void setParameter(Query query, Object... params) {
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}
	
	private void setParameter(Query query, Map<String, Object> parameterMap) {  
        for (Iterator iterator = parameterMap.keySet().iterator(); iterator.hasNext(); ) {  
            String key = (String) iterator.next();  
            query.setParameter(key, parameterMap.get(key));  
        }  
    } 

	public Boolean getAutoCommit() {
		return autoCommit;
	}

	public void setAutoCommit(Boolean autoCommit) {
		this.autoCommit = autoCommit;
	}

}
