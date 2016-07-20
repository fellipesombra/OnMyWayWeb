package br.com.onmyway.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {  
  
    private static Configuration configuration;  
    private static SessionFactory sessionFactory;  
    private static final ThreadLocal<Session> threadSession = new ThreadLocal<Session>();  
    private static final ThreadLocal<Transaction> threadTransaction = new ThreadLocal<Transaction>();  
  
 static {  
        try {  
            configuration = new Configuration();  
            sessionFactory = configuration.configure().buildSessionFactory();  
        } catch (Throwable ex) {  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
  
    public static Configuration getConfiguration() {  
        return configuration;  
    }  
  
	public static Session getSession()  
        throws HibernateException {  
        Session s = threadSession.get();  
        try {  
            if (s == null) {  
                s = getSessionFactory().openSession();  
                threadSession.set(s);  
            }  
        } catch (HibernateException ex) {  
            throw new RuntimeException(ex);  
        }  
        return s;  
    }  
  
	public static void closeSession()  
        throws HibernateException {  
        try {  
            Session s = threadSession.get();  
            threadSession.set(null);  
            if (s != null && s.isOpen()) {  
                s.close();  
            }  
        } catch (HibernateException ex) {  
            throw new RuntimeException(ex);  
        }  
    }  
  
	public static void beginTransaction()  
        throws HibernateException {  
        Transaction tx = threadTransaction.get();  
        try {  
            if (tx == null) {  
                tx = getSession().beginTransaction();  
                threadTransaction.set(tx);  
            }  
        } catch (HibernateException ex) {  
            throw new RuntimeException(ex);  
        }  
    }  
  
	public static void commitTransaction()  
        throws HibernateException {  
        Transaction tx = threadTransaction.get();  
        try {  
            if ( tx != null ) {  
                tx.commit();  
            }  
            threadTransaction.set(null);  
        } catch (HibernateException ex) {  
            rollbackTransaction();  
            throw new RuntimeException(ex);  
        }  
    }  
  
	public static void rollbackTransaction()  
        throws HibernateException {  
        Transaction tx = threadTransaction.get();  
        try {  
            threadTransaction.set(null);  
            if ( tx != null ) {  
                tx.rollback();  
            }  
        } catch (HibernateException ex) {  
            throw new RuntimeException(ex);  
        } finally {  
            closeSession();  
        }  
    }  
}  
