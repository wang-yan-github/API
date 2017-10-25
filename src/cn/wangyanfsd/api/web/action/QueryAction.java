package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.bean.GuanJianZi;
import cn.wangyanfsd.api.service.BslcCflcService;
import cn.wangyanfsd.api.service.BslcJclcService;
import cn.wangyanfsd.api.service.BslcXklcService;
import cn.wangyanfsd.api.service.BslcZzlcService;
import cn.wangyanfsd.api.service.FjJtdtService;
import cn.wangyanfsd.api.service.FjLbtService;
import cn.wangyanfsd.api.service.FjQdymService;
import cn.wangyanfsd.api.service.FjRmjxService;
import cn.wangyanfsd.api.service.FjYqljService;
import cn.wangyanfsd.api.service.GuanJianZiService;
import cn.wangyanfsd.api.service.GxzdCwgkService;
import cn.wangyanfsd.api.service.GxzdSsfaService;
import cn.wangyanfsd.api.service.GxzdZfgsService;
import cn.wangyanfsd.api.service.LiuLiangService;
import cn.wangyanfsd.api.service.ZfjgCfjgService;
import cn.wangyanfsd.api.service.ZfjgJcjgService;
import cn.wangyanfsd.api.service.ZfjgXkjgService;
import cn.wangyanfsd.api.service.ZfjjService;
import cn.wangyanfsd.api.service.ZfqxJcsxService;
import cn.wangyanfsd.api.service.ZfqxQlsxService;
import cn.wangyanfsd.api.service.ZfqxZrsxService;
import cn.wangyanfsd.api.service.ZtyjDfhscService;
import cn.wangyanfsd.api.service.ZtyjGkglcService;
import cn.wangyanfsd.api.service.ZtyjGlglzService;
import cn.wangyanfsd.api.service.ZtyjHdglzService;
import cn.wangyanfsd.api.service.ZtyjJtgczlService;
import cn.wangyanfsd.api.service.ZtyjJtysglsService;
import cn.wangyanfsd.api.service.ZtyjJtysjService;
import cn.wangyanfsd.api.service.ZtyjXzjtService;
import cn.wangyanfsd.api.service.ZtzdDfhscService;
import cn.wangyanfsd.api.service.ZtzdGkglcService;
import cn.wangyanfsd.api.service.ZtzdGlglzService;
import cn.wangyanfsd.api.service.ZtzdHdglzService;
import cn.wangyanfsd.api.service.ZtzdJtgczlService;
import cn.wangyanfsd.api.service.ZtzdJtysglsService;
import cn.wangyanfsd.api.service.ZtzdJtysjService;
import cn.wangyanfsd.api.service.ZtzdXzjtService;
import cn.wangyanfsd.api.service.impl.BslcCflcServiceImpl;
import cn.wangyanfsd.api.service.impl.BslcJclcServiceImpl;
import cn.wangyanfsd.api.service.impl.BslcXklcServiceImpl;
import cn.wangyanfsd.api.service.impl.BslcZzlcServiceImpl;
import cn.wangyanfsd.api.service.impl.FjJtdtServiceImpl;
import cn.wangyanfsd.api.service.impl.FjLbtServiceImpl;
import cn.wangyanfsd.api.service.impl.FjQdymServiceImpl;
import cn.wangyanfsd.api.service.impl.FjRmjxServiceImpl;
import cn.wangyanfsd.api.service.impl.FjYqljServiceImpl;
import cn.wangyanfsd.api.service.impl.GuanJianZiServiceImpl;
import cn.wangyanfsd.api.service.impl.GxzdCwgkServiceImpl;
import cn.wangyanfsd.api.service.impl.GxzdSsfaServiceImpl;
import cn.wangyanfsd.api.service.impl.GxzdZfgsServiceImpl;
import cn.wangyanfsd.api.service.impl.LiuLiangServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfjgCfjgServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfjgJcjgServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfjgXkjgServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfjjServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfqxJcsxServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfqxQlsxServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfqxZrsxServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjDfhscServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjGkglcServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjGlglzServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjHdglzServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjJtgczlServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjJtysglsServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjJtysjServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtyjXzjtServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdDfhscServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdGkglcServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdGlglzServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdHdglzServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdJtgczlServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdJtysglsServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdJtysjServiceImpl;
import cn.wangyanfsd.api.service.impl.ZtzdXzjtServiceImpl;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.TransactionUtil;

public class QueryAction extends HttpServlet{
	private static final long serialVersionUID = -9124449862145851743L;
	
	Map <Object,Object> map;
    private HttpServletRequest request;
    private String message = "";


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        this.request = request;
        request.setCharacterEncoding("UTF-8");
        String choice = request.getParameter("choice");
        Result r = null;

        if ("list".equals(choice)) {
            r = list();
        }

        PrintWriter out = response.getWriter();
        out.println(message);
        out.flush();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }
    
    private Result list() {

        String where = request.getParameter("where");
        map = new HashMap<Object,Object>();
        List list = new ArrayList();
        
        GuanJianZiService guanJianZiService = (GuanJianZiService)new TransactionUtil().newProxy(new GuanJianZiServiceImpl());
        GuanJianZi gjz = new GuanJianZi();
        gjz.setContent(where);
        guanJianZiService.save(gjz);
        
        if(!"".equals(where)&&where!=null){
    		
        	BslcCflcService BslcCflc = (BslcCflcService)new TransactionUtil().newProxy(new BslcCflcServiceImpl());
        	list.addAll(BslcCflc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("BslcCflc", BslcCflc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            BslcJclcService BslcJclcService = (BslcJclcService)new TransactionUtil().newProxy(new BslcJclcServiceImpl());
            list.addAll(BslcJclcService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("BslcJclc", BslcJclcService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            BslcXklcService BslcXklcService = (BslcXklcService)new TransactionUtil().newProxy(new BslcXklcServiceImpl());
            list.addAll(BslcXklcService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("BslcXklc", BslcXklcService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            BslcZzlcService BslcZzlcService = (BslcZzlcService)new TransactionUtil().newProxy(new BslcZzlcServiceImpl());
            list.addAll(BslcZzlcService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("BslcZzlc", BslcZzlcService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
            GxzdCwgkService GxzdCwgk = (GxzdCwgkService)new TransactionUtil().newProxy(new GxzdCwgkServiceImpl());
            list.addAll(BslcCflc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("GxzdCwgk", BslcCflc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            GxzdSsfaService GxzdSsfaService = (GxzdSsfaService)new TransactionUtil().newProxy(new GxzdSsfaServiceImpl());
            list.addAll(GxzdSsfaService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("GxzdSsfa", GxzdSsfaService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            GxzdZfgsService GxzdZfgsService = (GxzdZfgsService)new TransactionUtil().newProxy(new GxzdZfgsServiceImpl());
            list.addAll(GxzdZfgsService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("GxzdZfgs", GxzdZfgsService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
            ZtyjDfhscService ZtyjDfhsc = (ZtyjDfhscService)new TransactionUtil().newProxy(new ZtyjDfhscServiceImpl());
            list.addAll(ZtyjDfhsc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjDfhsc", ZtyjDfhsc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjGkglcService ZtyjGkglc = (ZtyjGkglcService)new TransactionUtil().newProxy(new ZtyjGkglcServiceImpl());
            list.addAll(ZtyjGkglc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjGkglc", ZtyjGkglc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjGlglzService ZtyjGlglz = (ZtyjGlglzService)new TransactionUtil().newProxy(new ZtyjGlglzServiceImpl());
            list.addAll(ZtyjGlglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjGlglz", ZtyjGlglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjHdglzService ZtyjHdglz = (ZtyjHdglzService)new TransactionUtil().newProxy(new ZtyjHdglzServiceImpl());
            list.addAll(ZtyjHdglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjHdglz", ZtyjHdglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjJtgczlService ZtyjJtgczl = (ZtyjJtgczlService)new TransactionUtil().newProxy(new ZtyjJtgczlServiceImpl());
            list.addAll(ZtyjJtgczl.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjJtgczl", ZtyjJtgczl.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjJtysglsService ZtyjJtysgls = (ZtyjJtysglsService)new TransactionUtil().newProxy(new ZtyjJtysglsServiceImpl());
            list.addAll(ZtyjJtysgls.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjJtysgls", ZtyjJtysgls.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjJtysjService ZtyjJtysj = (ZtyjJtysjService)new TransactionUtil().newProxy(new ZtyjJtysjServiceImpl());
            list.addAll(ZtyjJtysj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjJtysj", ZtyjJtysj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtyjXzjtService ZtyjXzjt = (ZtyjXzjtService)new TransactionUtil().newProxy(new ZtyjXzjtServiceImpl());
            list.addAll(ZtyjXzjt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtyjXzjt", ZtyjXzjt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
    		ZtzdDfhscService ZtzdDfhsc = (ZtzdDfhscService)new TransactionUtil().newProxy(new ZtzdDfhscServiceImpl());
    		list.addAll(ZtzdDfhsc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdDfhsc", ZtzdDfhsc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdGkglcService ZtzdGkglc = (ZtzdGkglcService)new TransactionUtil().newProxy(new ZtzdGkglcServiceImpl());
            list.addAll(ZtzdGkglc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdGkglc", ZtzdGkglc.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdGlglzService ZtzdGlglz = (ZtzdGlglzService)new TransactionUtil().newProxy(new ZtzdGlglzServiceImpl());
            list.addAll(ZtzdGlglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdGlglz", ZtzdGlglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdHdglzService ZtzdHdglz = (ZtzdHdglzService)new TransactionUtil().newProxy(new ZtzdHdglzServiceImpl());
            list.addAll(ZtzdHdglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdHdglz", ZtzdHdglz.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdJtgczlService ZtzdJtgczl = (ZtzdJtgczlService)new TransactionUtil().newProxy(new ZtzdJtgczlServiceImpl());
            list.addAll(ZtzdJtgczl.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdJtgczl", ZtzdJtgczl.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdJtysglsService ZtzdJtysgls = (ZtzdJtysglsService)new TransactionUtil().newProxy(new ZtzdJtysglsServiceImpl());
            list.addAll(ZtzdJtysgls.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdJtysgls", ZtzdJtysgls.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdJtysjService ZtzdJtysj = (ZtzdJtysjService)new TransactionUtil().newProxy(new ZtzdJtysjServiceImpl());
            list.addAll(ZtzdJtysj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdJtysj", ZtzdJtysj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZtzdXzjtService ZtzdXzjt = (ZtzdXzjtService)new TransactionUtil().newProxy(new ZtzdXzjtServiceImpl());
            list.addAll(ZtzdXzjt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZtzdXzjt", ZtzdXzjt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
    		ZfqxJcsxService ZfqxJcsx = (ZfqxJcsxService)new TransactionUtil().newProxy(new ZfqxJcsxServiceImpl());
    		list.addAll(ZfqxJcsx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZfqxJcsx", ZfqxJcsx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZfqxQlsxService ZfqxQlsx = (ZfqxQlsxService)new TransactionUtil().newProxy(new ZfqxQlsxServiceImpl());
            list.addAll(ZfqxQlsx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZfqxQlsx", ZfqxQlsx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZfqxZrsxService ZfqxZrsx = (ZfqxZrsxService)new TransactionUtil().newProxy(new ZfqxZrsxServiceImpl());
            list.addAll(ZfqxZrsx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZfqxZrsx", ZfqxZrsx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
    		ZfjjService Zfjj = (ZfjjService)new TransactionUtil().newProxy(new ZfjjServiceImpl());
    		list.addAll(Zfjj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("Zfjj", Zfjj1.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
    		ZfjgCfjgService ZfjgCfjg = (ZfjgCfjgService)new TransactionUtil().newProxy(new ZfjgCfjgServiceImpl());
    		list.addAll(ZfjgCfjg.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZfjgCfjg", ZfjgCfjg.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZfjgJcjgService ZfjgJcjg = (ZfjgJcjgService)new TransactionUtil().newProxy(new ZfjgJcjgServiceImpl());
            list.addAll(ZfjgJcjg.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZfjgJcjg", ZfjgJcjg.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            ZfjgXkjgService ZfjgXkjg = (ZfjgXkjgService)new TransactionUtil().newProxy(new ZfjgXkjgServiceImpl());
            list.addAll(ZfjgXkjg.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            //map.put("ZfjgXkjg", ZfjgXkjg.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
            
    		FjJtdtService FjJtdt = (FjJtdtService)new TransactionUtil().newProxy(new FjJtdtServiceImpl());
    		list.addAll(FjJtdt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		//map.put("FjJtdt", FjJtdt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		FjLbtService FjLbt = (FjLbtService)new TransactionUtil().newProxy(new FjLbtServiceImpl());
    		list.addAll(FjLbt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		//map.put("FjLbt", FjLbt.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		FjRmjxService FjRmjx = (FjRmjxService)new TransactionUtil().newProxy(new FjRmjxServiceImpl());
    		list.addAll(FjRmjx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		//map.put("FjRmjx", FjRmjx.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		FjYqljService FjYqlj = (FjYqljService)new TransactionUtil().newProxy(new FjYqljServiceImpl());
    		list.addAll(FjYqlj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		//map.put("FjYqlj", FjYqlj.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		FjQdymService FjQdym = (FjQdymService)new TransactionUtil().newProxy(new FjQdymServiceImpl());
    		list.addAll(FjQdym.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
    		//map.put("FjQdym", FjQdym.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
        }
        message = JSONUtils.toJSONString(list);
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }
}
