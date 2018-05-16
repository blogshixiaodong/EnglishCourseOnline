package com.eco.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/*
 * date:   2018年5月15日 下午11:40:43
 * author: Shixiaodong
 */
public final class HibernateUtils {
	
	private static Configuration configuration;
	  
    private static SessionFactory sessionFactory;
    
    private Session session;
    
    private Transaction transaction;
	
	static {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}
	
	private HibernateUtils() {
		
	}
	
	public Session getSession() {
		if(session == null || !session.isOpen()) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public void beginTransaction() {
		transaction = getSession().beginTransaction();
	}
	
	public void commit() {
		transaction.commit();
	}
	
	public void rollback() {
		transaction.rollback();
	}
	
	public void close() {
		session.close();
		session = null;
	}
	
	
	
	

}
