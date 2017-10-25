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
		/** 二、主体职责
			1、邳州市交通运输局:
			2、邳州市交通运输管理所:
			3、邳州市公路管理站:
			4、邳州市乡镇交通运输综合管理所:
			5、邳州市地方海事处:
			6、邳州市航道管理站:
			7、邳州市港口管理处:
			8、邳州市交通工程质量监督站:
		 */
		beanUtilTest.beanTool(beanUtils, ZtzdDfhsc.class);
		beanUtilTest.beanTool(beanUtils, ZtzdGkglc.class);
		beanUtilTest.beanTool(beanUtils, ZtzdGlglz.class);
		beanUtilTest.beanTool(beanUtils, ZtzdHdglz.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtgczl.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtysgls.class);
		beanUtilTest.beanTool(beanUtils, ZtzdJtysj.class);
		beanUtilTest.beanTool(beanUtils, ZtzdXzjt.class);

		/** 三、执法依据
			1、邳州市交通运输局:
			2、邳州市交通运输管理所:
			3、邳州市公路管理站:
			4、邳州市乡镇交通运输综合管理所:
			5、邳州市地方海事处:
			6、邳州市航道管理站:
			7、邳州市港口管理处:
			8、邳州市交通工程质量监督站:
		*/
		
		/**四、办事流程
			1、行政许可流程；
			2、行政处罚流程；
			3、行政强制流程；
			4、行政检查流程；
		 */
		
		/** 五、执法权限
			1、行政权力事项；
			2、行政责任事项；
			3、行政检查事项
		 */
		
		/** 六、执法救济*/
		
		/** 七、执法结果
		 	1、许可结果；
			2、处罚结果；
			3、检查结果。
		 */
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
	}
}
