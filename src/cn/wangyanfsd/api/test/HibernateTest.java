package cn.wangyanfsd.api.test;

import org.hibernate.cfg.Configuration;
import org.junit.Test;

import cn.wangyanfsd.api.service.ClassroomBiz;
import cn.wangyanfsd.api.service.JHPTBiz;
import cn.wangyanfsd.api.service.impl.ClassroomBizImpl;
import cn.wangyanfsd.api.service.impl.JHPTBizImpl;
import cn.wangyanfsd.api.util.TransactionUtil;

public class HibernateTest {
	@Test
	public void config() {
		//检查hibernate映射是否正确
		new Configuration().configure().buildSessionFactory();
	}
	@Test
	public void classroomBizFind(){
		ClassroomBiz classroomBiz = (ClassroomBiz)new TransactionUtil().newProxy(new ClassroomBizImpl());
		System.err.println(classroomBiz.getClassroomList());
	}
}
