package cn.wangyanfsd.api.base;

import cn.wangyanfsd.api.bean.FangWen;
import cn.wangyanfsd.api.bean.GuanJianZi;
import cn.wangyanfsd.api.bean.LiuLiang;
import cn.wangyanfsd.api.bean.User;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-10-24
 */
public class BeanUtilTest {

	public static void main(String[] args) throws Exception{
		BeanUtilTest beanUtilTest = new BeanUtilTest();
		BeanUtils beanUtils = new BeanUtils();
		
		/*beanUtilTest.beanTool(beanUtils, BslcCflc.class);
		beanUtilTest.beanTool(beanUtils, BslcJclc.class);
		beanUtilTest.beanTool(beanUtils, BslcXklc.class);
		beanUtilTest.beanTool(beanUtils, BslcZzlc.class);
		
		beanUtilTest.beanTool(beanUtils, GxzdCwgk.class);
		beanUtilTest.beanTool(beanUtils, GxzdSsfa.class);
		beanUtilTest.beanTool(beanUtils, GxzdZfgs.class);
		
		beanUtilTest.beanTool(beanUtils, ZtyjDfhsc.class);
		beanUtilTest.beanTool(beanUtils, ZtyjGkglc.class);
		beanUtilTest.beanTool(beanUtils, ZtyjGlglz.class);
		beanUtilTest.beanTool(beanUtils, ZtyjHdglz.class);
		beanUtilTest.beanTool(beanUtils, ZtyjJtgczl.class);
		beanUtilTest.beanTool(beanUtils, ZtyjJtysgls.class);
		beanUtilTest.beanTool(beanUtils, ZtyjJtysj.class);
		beanUtilTest.beanTool(beanUtils, ZtyjXzjt.class);
		
		beanUtilTest.beanTool(beanUtils, ZtzdDfhsc.class);
		beanUtilTest.beanTool(beanUtils, ZtzdGkglc.class);
		beanUtilTest.beanTool(beanUtils, ZtzdGlglz.class);
		beanUtilTest.beanTool(beanUtils, ZtzdHdglz.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtgczl.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtysgls.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtysj.class);
		beanUtilTest.beanTool(beanUtils, ZtzdXzjt.class);
		
		beanUtilTest.beanTool(beanUtils, ZfqxJcsx.class);
		beanUtilTest.beanTool(beanUtils, ZfqxQlsx.class);
		beanUtilTest.beanTool(beanUtils, ZfqxZrsx.class);
		
		beanUtilTest.beanTool(beanUtils, Zfjj.class);
		
		beanUtilTest.beanTool(beanUtils, ZfjgCfjg.class);
		beanUtilTest.beanTool(beanUtils, ZfjgJcjg.class);
		beanUtilTest.beanTool(beanUtils, ZfjgXkjg.class);
		
		beanUtilTest.beanTool(beanUtils, FjJtdt.class);
		beanUtilTest.beanTool(beanUtils, FjLbt.class);
		beanUtilTest.beanTool(beanUtils, FjRmjx.class);
		beanUtilTest.beanTool(beanUtils, FjYqlj.class);
		beanUtilTest.beanTool(beanUtils, FjQdym.class);
		
		beanUtilTest.beanTool(beanUtils, User.class);*/
		
		beanUtilTest.beanTool(beanUtils, LiuLiang.class);
		beanUtilTest.beanTool(beanUtils, GuanJianZi.class);
		beanUtilTest.beanTool(beanUtils, FangWen.class);
	}
	
	/**
	 * 根据bean生成相应的文件
	 * @param beanUtils
	 * @param c
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void beanTool(BeanUtils beanUtils ,Class c)throws Exception{
		beanUtils.createBeanDao(c);
		beanUtils.createBeanDaoImpl(c);
		beanUtils.createBeanService(c);
		beanUtils.createBeanServiceImpl(c);
		beanUtils.createAction(c);
	}
}
