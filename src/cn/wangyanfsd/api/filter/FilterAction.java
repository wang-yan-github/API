package cn.wangyanfsd.api.filter;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.bean.FangWen;
import cn.wangyanfsd.api.bean.GuanJianZi;
import cn.wangyanfsd.api.bean.LiuLiang;
import cn.wangyanfsd.api.service.FangWenService;
import cn.wangyanfsd.api.service.LiuLiangService;
import cn.wangyanfsd.api.service.impl.FangWenServiceImpl;
import cn.wangyanfsd.api.service.impl.LiuLiangServiceImpl;
import cn.wangyanfsd.api.util.TransactionUtil;

/**
 * @author wangy
 * @javaDoc 过滤器
 *
 */
public class FilterAction implements Filter{

	LiuLiangService liuLiangService = (LiuLiangService)new TransactionUtil().newProxy(new LiuLiangServiceImpl());
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
    String date = sf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
    Map <Object,Object> map = new HashMap<Object, Object>();
    private String message = "";
    private HttpServletRequest request;
	
	public void destroy() {
		System.out.println("----Filter销毁----");  
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        this.request = request;
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        GuanJianZi gjz = new GuanJianZi();
        
        
        // 允许跨域即
        /*String curOrigin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        // 对request、response进行一些预处理  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println("----调用service之前执行一段代码----");  
        filterChain.doFilter(request, response); // 执行目标资源，放行  
        System.out.println("----调用service之后执行一段代码----");  
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("----Filter初始化----"); 
		
		// 初始化数据
		LiuLiang ll = new LiuLiang();
		System.out.println("---------------------------------- " + liuLiangService.getCount());
		if(liuLiangService.getCount() == 0 ){
			
			ll.setContent("BslcCflc");
			ll.setType("Bslc");
			ll.setName("处罚结果");
			liuLiangService.save(ll);
			ll.setContent("BslcJclc");
			ll.setType("Bslc");
			ll.setName("检查结果");
			liuLiangService.save(ll);
			ll.setContent("BslcXklc");
			ll.setType("Bslc");
			ll.setName("许可结果");
			liuLiangService.save(ll);
			ll.setContent("BslcZzlc");
			ll.setType("Bslc");
			ll.setName("强制结果");
			liuLiangService.save(ll);
			
			ll.setContent("GxzdCwgk");
			ll.setType("Gxzd");
			ll.setName("政务公开");
			liuLiangService.save(ll);
			ll.setContent("GxzdSsfa");
			ll.setType("Gxzd");
			ll.setName("实施方案");
			liuLiangService.save(ll);
			ll.setContent("GxzdZfgs");
			ll.setType("Gxzd");
			ll.setName("执法公示");
			liuLiangService.save(ll);
			
			ll.setContent("ZtyjDfhsc");
			ll.setType("Ztyj");
			ll.setName("地方海事处");
			liuLiangService.save(ll);
			ll.setContent("ZtyjGkglc");
			ll.setType("Ztyj");
			ll.setName("港口管理处");
			liuLiangService.save(ll);
			ll.setContent("ZtyjGlglz");
			ll.setType("Ztyj");
			ll.setName("公路管理站");
			liuLiangService.save(ll);
			ll.setContent("ZtyjHdglz");
			ll.setType("Ztyj");
			ll.setName("航道管理站");
			liuLiangService.save(ll);
			ll.setContent("ZtyjJtgczl");
			ll.setType("Ztyj");
			ll.setName("交通工程质量监督站");
			liuLiangService.save(ll);
			ll.setContent("ZtyjJtysgls");
			ll.setType("Ztyj");
			ll.setName("交通运输管理所");
			liuLiangService.save(ll);
			ll.setContent("ZtyjJtysj");
			ll.setType("Ztyj");
			ll.setName("交通运输局");
			liuLiangService.save(ll);
			ll.setContent("ZtyjXzjt");
			ll.setType("Ztyj");
			ll.setName("乡镇交通运输综合管理所");
			liuLiangService.save(ll);
			
			ll.setContent("ZtzdDfhsc");
			ll.setType("Ztzd");
			ll.setName("地方海事处");
			liuLiangService.save(ll);
			ll.setContent("ZtzdGkglc");
			ll.setType("Ztzd");
			ll.setName("港口管理处");
			liuLiangService.save(ll);
			ll.setContent("ZtzdGlglz");
			ll.setType("Ztzd");
			ll.setName("公路管理站");
			liuLiangService.save(ll);
			ll.setContent("ZtzdHdglz");
			ll.setType("Ztzd");
			ll.setName("航道管理站");
			liuLiangService.save(ll);
			ll.setContent("ZtzdJtgczl");
			ll.setType("Ztzd");
			ll.setName("交通工程质量监督站");
			liuLiangService.save(ll);
			ll.setContent("ZtzdJtysgls");
			ll.setType("Ztzd");
			ll.setName("交通运输管理所");
			liuLiangService.save(ll);
			ll.setContent("ZtzdJtysj");
			ll.setType("Ztzd");
			ll.setName("交通运输局");
			liuLiangService.save(ll);
			ll.setContent("ZtzdXzjt");
			ll.setType("Ztzd");
			ll.setName("乡镇交通运输综合管理所");
			liuLiangService.save(ll);
			
			ll.setContent("ZfqxJcsx");
			ll.setType("Zfqx");
			ll.setName("检查事项");
			liuLiangService.save(ll);
			ll.setContent("ZfqxQlsx");
			ll.setType("Zfqx");
			ll.setName("权力事项");
			liuLiangService.save(ll);
			ll.setContent("ZfqxZrsx");
			ll.setType("Zfqx");
			ll.setName("责任事项");
			liuLiangService.save(ll);
			
			ll.setContent("Zfjj");
			ll.setType("Zfjj");
			ll.setName("执法救济");
			liuLiangService.save(ll);
			
			ll.setContent("ZfjgCfjg");
			ll.setType("Zfjg");
			ll.setName("处罚结果");
			liuLiangService.save(ll);
			ll.setContent("ZfjgJcjg");
			ll.setType("Zfjg");
			ll.setName("检查结果");
			liuLiangService.save(ll);
			ll.setContent("ZfjgXkjg");
			ll.setType("Zfjg");
			ll.setName("许可结果");
			liuLiangService.save(ll);
			
		}
	}

}
