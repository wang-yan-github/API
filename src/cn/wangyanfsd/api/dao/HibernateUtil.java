package cn.wangyanfsd.api.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public final class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY;
	static {
		try {
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			throw new ExceptionInInitializerError(e);
		}
	}
	public static Session getSession() {
		return SESSION_FACTORY.getCurrentSession();
	}
	public static void beginTransaction(Session session) {
		if (session != null) {
			session.beginTransaction();
		}
	}
	public static void commit(Session session) {
		if (session != null) {
			session.getTransaction().commit();
		}
	}
	public static void rollback(Session session) {
		if (session != null) {
			session.getTransaction().rollback();
		}
	}
}
