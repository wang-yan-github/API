package cn.wangyanfsd.api.base;

import cn.wangyanfsd.api.bean.ZtzdDfhsc;
import cn.wangyanfsd.api.bean.ZtzdGkglc;
import cn.wangyanfsd.api.bean.ZtzdGlglz;
import cn.wangyanfsd.api.bean.ZtzdHdglz;
import cn.wangyanfsd.api.bean.ZtzdJtgczl;
import cn.wangyanfsd.api.bean.ZtzdJtysgls;
import cn.wangyanfsd.api.bean.ZtzdJtysj;
import cn.wangyanfsd.api.bean.ZtzdXzjt;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-10-24
 */
public class BeanUtilTest {

	public static void main(String[] args) throws Exception{
		BeanUtilTest beanUtilTest = new BeanUtilTest();
		BeanUtils beanUtils = new BeanUtils();
		beanUtilTest.beanTool(beanUtils, ZtzdDfhsc.class);
		beanUtilTest.beanTool(beanUtils, ZtzdGkglc.class);
		beanUtilTest.beanTool(beanUtils, ZtzdGlglz.class);
		beanUtilTest.beanTool(beanUtils, ZtzdHdglz.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtgczl.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtysgls.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtysj.class);
		beanUtilTest.beanTool(beanUtils, ZtzdXzjt.class);

	}
	
	/**
	 * 根据bean生成相应的文件
	 * @param beanUtils
	 * @param c
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void beanTool(BeanUtils beanUtils ,Class c)throws Exception{
		//beanUtils.createBeanDao(c);
		//beanUtils.createBeanDaoImpl(c);
		//beanUtils.createBeanService(c);
		beanUtils.createBeanServiceImpl(c);
	}
}
