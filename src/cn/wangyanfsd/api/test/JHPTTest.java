package cn.wangyanfsd.api.test;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import cn.wangyanfsd.api.bean.JHPT;
import cn.wangyanfsd.api.service.JHPTBiz;
import cn.wangyanfsd.api.service.impl.JHPTBizImpl;
import cn.wangyanfsd.api.util.TransactionUtil;

public class JHPTTest {
	JHPTBiz JHPT = null;
	
	@Before
	public void init(){
		JHPT = (JHPTBiz)new TransactionUtil().newProxy(new JHPTBizImpl());
	}
	@Test
	public void add(){
		JHPT p = new JHPT();
		p.setYXT("ԭϵͳ1");
		p.setMBXT("Ŀ��ϵͳ1");
		p.setYB("ԭ��1");
		p.setMBB("Ŀ���");
		p.setSCJL("�����¼");
		p.setXZHS("1");
		p.setGXHS("2");
		p.setCWHS("3");
		p.setZT("ʧ��");
		p.setKSSJ(new Date());
		p.setJSSJ(new Date());
		System.err.println(JHPT.addJHPT(p));
	}
	@Test
	public void findById(){
		System.err.println(JHPT.getJHPTById(1));
	}
	
	@Test
	public void findPage(){
		System.err.println(JHPT.getJHPTList(1, 1));
	}
}
