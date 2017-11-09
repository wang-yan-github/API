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
 * @javaDoc ������
 *
 */
public class FilterAction implements Filter{

	LiuLiangService liuLiangService = (LiuLiangService)new TransactionUtil().newProxy(new LiuLiangServiceImpl());
	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
    String date = sf.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ�䣬Ҳ��ʹ�õ�ǰʱ���
    Map <Object,Object> map = new HashMap<Object, Object>();
    private String message = "";
    private HttpServletRequest request;
	
	public void destroy() {
		System.out.println("----Filter����----");  
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        this.request = request;
        request.setCharacterEncoding("UTF-8");
        String url = request.getServletPath();
        GuanJianZi gjz = new GuanJianZi();
        
        
        // �������
        /*String curOrigin = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");*/
        response.setHeader("Access-Control-Allow-Origin", "*");
        
        // ��request��response����һЩԤ����  
        request.setCharacterEncoding("UTF-8");  
        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");
        
        System.out.println("----����service֮ǰִ��һ�δ���----");  
        filterChain.doFilter(request, response); // ִ��Ŀ����Դ������  
        System.out.println("----����service֮��ִ��һ�δ���----");  
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("----Filter��ʼ��----"); 
		
		// ��ʼ������
		LiuLiang ll = new LiuLiang();
		System.out.println("---------------------------------- " + liuLiangService.getCount());
		if(liuLiangService.getCount() == 0 ){
			
			ll.setContent("BslcCflc");
			ll.setType("Bslc");
			ll.setName("�������");
			liuLiangService.save(ll);
			ll.setContent("BslcJclc");
			ll.setType("Bslc");
			ll.setName("�����");
			liuLiangService.save(ll);
			ll.setContent("BslcXklc");
			ll.setType("Bslc");
			ll.setName("��ɽ��");
			liuLiangService.save(ll);
			ll.setContent("BslcZzlc");
			ll.setType("Bslc");
			ll.setName("ǿ�ƽ��");
			liuLiangService.save(ll);
			
			ll.setContent("GxzdCwgk");
			ll.setType("Gxzd");
			ll.setName("���񹫿�");
			liuLiangService.save(ll);
			ll.setContent("GxzdSsfa");
			ll.setType("Gxzd");
			ll.setName("ʵʩ����");
			liuLiangService.save(ll);
			ll.setContent("GxzdZfgs");
			ll.setType("Gxzd");
			ll.setName("ִ����ʾ");
			liuLiangService.save(ll);
			
			ll.setContent("ZtyjDfhsc");
			ll.setType("Ztyj");
			ll.setName("�ط����´�");
			liuLiangService.save(ll);
			ll.setContent("ZtyjGkglc");
			ll.setType("Ztyj");
			ll.setName("�ۿڹ���");
			liuLiangService.save(ll);
			ll.setContent("ZtyjGlglz");
			ll.setType("Ztyj");
			ll.setName("��·����վ");
			liuLiangService.save(ll);
			ll.setContent("ZtyjHdglz");
			ll.setType("Ztyj");
			ll.setName("��������վ");
			liuLiangService.save(ll);
			ll.setContent("ZtyjJtgczl");
			ll.setType("Ztyj");
			ll.setName("��ͨ���������ලվ");
			liuLiangService.save(ll);
			ll.setContent("ZtyjJtysgls");
			ll.setType("Ztyj");
			ll.setName("��ͨ���������");
			liuLiangService.save(ll);
			ll.setContent("ZtyjJtysj");
			ll.setType("Ztyj");
			ll.setName("��ͨ�����");
			liuLiangService.save(ll);
			ll.setContent("ZtyjXzjt");
			ll.setType("Ztyj");
			ll.setName("����ͨ�����ۺϹ�����");
			liuLiangService.save(ll);
			
			ll.setContent("ZtzdDfhsc");
			ll.setType("Ztzd");
			ll.setName("�ط����´�");
			liuLiangService.save(ll);
			ll.setContent("ZtzdGkglc");
			ll.setType("Ztzd");
			ll.setName("�ۿڹ���");
			liuLiangService.save(ll);
			ll.setContent("ZtzdGlglz");
			ll.setType("Ztzd");
			ll.setName("��·����վ");
			liuLiangService.save(ll);
			ll.setContent("ZtzdHdglz");
			ll.setType("Ztzd");
			ll.setName("��������վ");
			liuLiangService.save(ll);
			ll.setContent("ZtzdJtgczl");
			ll.setType("Ztzd");
			ll.setName("��ͨ���������ලվ");
			liuLiangService.save(ll);
			ll.setContent("ZtzdJtysgls");
			ll.setType("Ztzd");
			ll.setName("��ͨ���������");
			liuLiangService.save(ll);
			ll.setContent("ZtzdJtysj");
			ll.setType("Ztzd");
			ll.setName("��ͨ�����");
			liuLiangService.save(ll);
			ll.setContent("ZtzdXzjt");
			ll.setType("Ztzd");
			ll.setName("����ͨ�����ۺϹ�����");
			liuLiangService.save(ll);
			
			ll.setContent("ZfqxJcsx");
			ll.setType("Zfqx");
			ll.setName("�������");
			liuLiangService.save(ll);
			ll.setContent("ZfqxQlsx");
			ll.setType("Zfqx");
			ll.setName("Ȩ������");
			liuLiangService.save(ll);
			ll.setContent("ZfqxZrsx");
			ll.setType("Zfqx");
			ll.setName("��������");
			liuLiangService.save(ll);
			
			ll.setContent("Zfjj");
			ll.setType("Zfjj");
			ll.setName("ִ���ȼ�");
			liuLiangService.save(ll);
			
			ll.setContent("ZfjgCfjg");
			ll.setType("Zfjg");
			ll.setName("�������");
			liuLiangService.save(ll);
			ll.setContent("ZfjgJcjg");
			ll.setType("Zfjg");
			ll.setName("�����");
			liuLiangService.save(ll);
			ll.setContent("ZfjgXkjg");
			ll.setType("Zfjg");
			ll.setName("��ɽ��");
			liuLiangService.save(ll);
			
		}
	}

}
