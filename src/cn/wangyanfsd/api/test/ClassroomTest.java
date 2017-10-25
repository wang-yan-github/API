package cn.wangyanfsd.api.test;

import org.junit.Before;
import org.junit.Test;

import cn.wangyanfsd.api.bean.Classroom;
import cn.wangyanfsd.api.service.ClassroomBiz;
import cn.wangyanfsd.api.service.impl.ClassroomBizImpl;
import cn.wangyanfsd.api.util.TransactionUtil;


public class ClassroomTest {
	ClassroomBiz Classroom = null;

	@Before
	public void init(){
		Classroom = (ClassroomBiz)new TransactionUtil().newProxy(new ClassroomBizImpl());
	}
	
	@Test
	public void list(){
		System.out.println(Classroom.getClassroomList());
	}
	
}
