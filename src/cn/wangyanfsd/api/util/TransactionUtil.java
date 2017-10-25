package cn.wangyanfsd.api.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.hibernate.Session;

import cn.wangyanfsd.api.dao.HibernateUtil;

//事务管理的代理
public final class TransactionUtil implements InvocationHandler {
	private Object targetObject;//被代理对象
	
	public Object newProxy(Object object) {
		this.targetObject = object;
		return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(),this);
	}

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object r = null;
		Session session = HibernateUtil.getSession();//底层代表的是一份connection
		try {
			HibernateUtil.beginTransaction(session);
			System.out.println("代理的目标类名：" + targetObject.getClass().getName());
			System.out.println("代理的目标方法名：" + method.getName());
			r = method.invoke(targetObject, args);
			HibernateUtil.commit(session);
		} catch (Exception e) {
			HibernateUtil.rollback(session);
			e.printStackTrace();
		}
		return r;
	}
}
