package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import cn.wangyanfsd.api.bean.LiuLiang;
import cn.wangyanfsd.api.service.LiuLiangService;
import cn.wangyanfsd.api.service.impl.LiuLiangServiceImpl;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.StrUtil;
import cn.wangyanfsd.api.util.TransactionUtil;

public class LiuLiangAction extends HttpServlet {

    private LiuLiangService liuLiangService = (LiuLiangService)new TransactionUtil().newProxy(new LiuLiangServiceImpl());
    Map <Object,Object> map;
    private HttpServletRequest request;
    private String message;


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        this.request = request;
        request.setCharacterEncoding("UTF-8");
        String choice = request.getParameter("choice");
        Result r = null;

        if ("save".equals(choice)) {
            r = save();
        } else if ("remove".equals(choice)) {
            r = remove();
        } else if ("update".equals(choice)) {
            r = update();
        } else if ("list".equals(choice)) {
            r = list();
        } else if ("find".equals(choice)) {
            r = find();
        }else if ("sum".equals(choice)){
        	r = sum();
        }

        PrintWriter out = response.getWriter();
        out.println(message);
        out.flush();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    private Result save() {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        String person = request.getParameter("person");
        map = new HashMap<Object,Object>();

        if(!"".equals(title)&&title!=null&&!"".equals(content)&&content!=null&&!"".equals(date)&&date!=null&&!"".equals(person)&&person!=null){
            LiuLiang liuLiang = new LiuLiang();
            liuLiangService.save(liuLiang);
            map.put("liuLiang", liuLiang);
            map.put("message", "添加成功");
        }else{
        map.put("message", "输入参错不正确，或内容不存在");
        }

        message = JSONUtils.toJSONString(map);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result remove() {

        String id = request.getParameter("id");
        map = new HashMap<Object,Object>();

        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)){
            int i = Integer.parseInt(id);
            map.put("liuLiang", liuLiangService.find(i));
            liuLiangService.remove(i);
            map.put("message", "删除成功");
        }else{
        map.put("message", "输入参错不正确，或内容不存在");
        }

        message = JSONUtils.toJSONString(map);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result update() {

        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String date = request.getParameter("date");
        String person = request.getParameter("person");
        map = new HashMap<Object,Object>();

        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(title)&&title!=null&&!"".equals(content)&&content!=null&&!"".equals(date)&&date!=null&&!"".equals(person)&&person!=null){
            LiuLiang liuLiang = new LiuLiang();
            liuLiang.setId(Integer.parseInt(id));
            liuLiangService.update(liuLiang);
            map.put("liuLiang", liuLiang);
            map.put("message", "修改成功");
        }else{
        map.put("message", "输入参错不正确，或内容不存在");
        }

        message = JSONUtils.toJSONString(map);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result list() {

        String where = request.getParameter("where");
        List list = new ArrayList();

        if(!"".equals(where)&&where!=null){
            message = JSONUtils.toJSONString(liuLiangService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
        }else{
            message = JSONUtils.toJSONString(liuLiangService.list());
        }
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }

    private Result find() {

    	Configuration cfg = new Configuration().configure();  
        SessionFactory sessionFactory = cfg.buildSessionFactory();  
        Session session = sessionFactory.openSession();  
        Transaction tr = session.beginTransaction();  
        //1. 创建 Query 对象与  
        Query query = session.createQuery("from LiuLiang order by number desc");// 升序, asc 可以去掉  
        //2. 命名参数动态绑定查询条件  
        //query.setString("v_name", "test");  
        //2. 执行 SQL  
        List list = query.list();  
        List result = new ArrayList();
        //3. 输出结果  
        for (int i = 0;i<list.size();i++) {  
        	LiuLiang ll = (LiuLiang) list.get(i);
            //System.out.println(ll.getContent()); 
        	result.add(ll);
        }  
        //4. 事务提交  
        tr.commit();  
        //5. 关闭 session  
        session.close(); 
    	

        message = JSONUtils.toJSONString(result);
        System.out.println(message);
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }
    
    private Result sum() {

    	Configuration cfg = new Configuration().configure();  
        SessionFactory sessionFactory = cfg.buildSessionFactory();  
        Session session = sessionFactory.openSession();  
        Transaction tr = session.beginTransaction();  
        List result = new ArrayList();
        List list;
        
        Query q1 = session.createQuery("select sum(number) from LiuLiang where type='Bslc'");
        map = new HashMap<Object,Object>();
        list = q1.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "办事流程");
            result.add(map);
        }
        
        Query q2 = session.createQuery("select sum(number) from LiuLiang where type='Gxzd'");
        map = new HashMap<Object,Object>();
        list = q2.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "各项制度");
            result.add(map);
        }
        
        Query q3 = session.createQuery("select sum(number) from LiuLiang where type='Ztyj'");
        map = new HashMap<Object,Object>();
        list = q3.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "执法依据");
            result.add(map);
        }
        
        Query q4 = session.createQuery("select sum(number) from LiuLiang where type='Ztzd'");
        map = new HashMap<Object,Object>();
        list = q4.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "主体职责");
            result.add(map);
        }
        
        Query q5 = session.createQuery("select sum(number) from LiuLiang where type='Zfqx'");
        map = new HashMap<Object,Object>();
        list = q5.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "执法权限");
            result.add(map);
        }
        
        Query q6 = session.createQuery("select sum(number) from LiuLiang where type='Zfjj'");
        map = new HashMap<Object,Object>();
        list = q6.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "执法救济");
            result.add(map);
        }
        
        Query q7 = session.createQuery("select sum(number) from LiuLiang where type='Zfjg'");
        map = new HashMap<Object,Object>();
        list = q7.list();
        for (int i = 0;i<list.size();i++) {  
            map.put("number", list.get(i));
            map.put("type", "执法结果");
            result.add(map);
        }
        
        tr.commit();  
        session.close(); 
    	

        message = JSONUtils.toJSONString(result);
        System.out.println(message);
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }
    

}