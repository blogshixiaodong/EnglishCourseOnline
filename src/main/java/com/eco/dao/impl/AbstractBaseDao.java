package com.eco.dao.impl;

import java.io.Serializable;
import java.util.List;

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
	
    static {
    	configuration = new Configuration().configure();
    }
    
    public AbstractBaseDao() {
    	sessionFactory = configuration.buildSessionFactory();
		session = getSession();
		transaction = session.beginTransaction();
		entityClass = ReflectUtils.getClass(getClass());
    }
    
	@Override
	public Object save(T entity) {
		Object identifier = session.save(entity);
		commit();
		return identifier;
	}

	@Override
	public void save(List<T> list) {
		for(T t : list) {
			save(t);
		}
	}

	@Override
	public void delete(T entity) {
		session.delete(entity);
		commit();
	}

	@Override
	public void delete(List<T> list) {
		for(T t : list) {
			delete(t);
		}
	}

	@Override
	public void update(Object entity) {
		session.update(entity);
		commit();
	}

	@Override
	public void update(List<T> list) {
		for(T t : list) {
			update(t);
		}
	}

	@Override
	public void saveOrUpdate(Object entity) {
		session.saveOrUpdate(entity);
		commit();
	}

	@Override
	public void saveOrUpdate(List<T> list) {
		for(T t : list) {
			saveOrUpdate(t);
		}
	}

	@Override
	public Integer executeSQLUpdate(String sql, Object... params) {
		NativeQuery nativeQuery = session.createNativeQuery(sql);
		setParameter(nativeQuery, params);
		return nativeQuery.executeUpdate();
	}

	@Override
	public Integer executeHQLUpdate(String hql, Object... params) {
		Query query = session.createQuery(hql);
		setParameter(query, params);
		return query.executeUpdate();
	}

	@Override
	public T get(Serializable id) {
		return session.get(entityClass, id);
	}


	@Override
	public <T> T get(String hql, Object... params) {
		Query query = session.createQuery(hql);
		setParameter(query, params);
		List<T> list = query.list();
		if(list == null || list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}

	@Override
	public List<T> list(String hql, Object... params) {
		Query query = session.createQuery(hql);
		setParameter(query, params);
		return query.list();
	}


	@Override
	public List<T> list(String hql, PageContainer pageContainer, Object... params) {
		if(pageContainer == null) {
			return list(hql, params);
		}
		Query query = getSession().createQuery(hql.toString());
		int pageSize = pageContainer.getPageSize();
		int currentPageNo = pageContainer.getCurrentPageNo();
        if (pageSize > 0 && currentPageNo > 0) {  
            query.setFirstResult((currentPageNo < 2) ? 0 : (currentPageNo - 1) * pageSize);  
            query.setMaxResults(pageSize);  
        }  
        setParameter(query, params);  
       
        List<T> list = query.list();  
        String countString = "SELECT COUNT(*) FROM " + entityClass.getName();
        query = getSession().createQuery(countString);
        pageContainer.setRecordCount(Integer.parseInt(query.uniqueResult().toString()));
        return list;  
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
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
	
	private void setParameter(Query query, Object... params) {
		for(int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}
	
}
