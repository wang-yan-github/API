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
		p.setYXT("原系统1");
		p.setMBXT("目标系统1");
		p.setYB("原表1");
		p.setMBB("目标表");
		p.setSCJL("输出记录");
		p.setXZHS("1");
		p.setGXHS("2");
		p.setCWHS("3");
		p.setZT("失败");
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
