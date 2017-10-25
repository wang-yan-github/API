package cn.wangyanfsd.api.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.hibernate.Session;

import cn.wangyanfsd.api.dao.HibernateUtil;

//�������Ĵ���
public final class TransactionUtil implements InvocationHandler {
	private Object targetObject;//���������
	
	public Object newProxy(Object object) {
		this.targetObject = object;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object r = null;
		Session session = HibernateUtil.getSession();//�ײ�������һ��connection
		try {
			HibernateUtil.beginTransaction(session);
			System.out.println("�����Ŀ��������" + targetObject.getClass().getName());
			System.out.println("�����Ŀ�귽������" + method.getName());
			r = method.invoke(targetObject, args);
			HibernateUtil.commit(session);
		} catch (Exception e) {
			HibernateUtil.rollback(session);
			e.printStackTrace();
		}
		return r;
	}
}
