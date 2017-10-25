package cn.wangyanfsd.api.test;

import org.junit.Before;
import org.junit.Test;

import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.Student;
import cn.wangyanfsd.api.service.StudentBiz;
import cn.wangyanfsd.api.service.impl.StudentBizImpl;
import cn.wangyanfsd.api.util.TransactionUtil;

public class StudentTest {
	StudentBiz studentBiz = null;
	@Before
	public void init(){
		studentBiz = (StudentBiz)new TransactionUtil().newProxy(new StudentBizImpl());
	}

	@Test
	public void findByPage(){
		Pagination<Student> p = studentBiz.getStudentList(1, 1);
		for (int i = 0; i < p.getPageSize(); i++) {
			System.out.println(p.getQueryResult());
		}
	}
	
}
