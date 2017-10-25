package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
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

import cn.wangyanfsd.api.bean.GuanJianZi;
import cn.wangyanfsd.api.service.GuanJianZiService;
import cn.wangyanfsd.api.service.impl.GuanJianZiServiceImpl;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.StrUtil;
import cn.wangyanfsd.api.util.TransactionUtil;

public class GuanJianZiAction extends HttpServlet {

    private GuanJianZiService guanJianZiService = (GuanJianZiService)new TransactionUtil().newProxy(new GuanJianZiServiceImpl());
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
            GuanJianZi guanJianZi = new GuanJianZi();
            guanJianZiService.save(guanJianZi);
            map.put("guanJianZi", guanJianZi);
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
            map.put("guanJianZi", guanJianZiService.find(i));
            guanJianZiService.remove(i);
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
            GuanJianZi guanJianZi = new GuanJianZi();
            guanJianZi.setId(Integer.parseInt(id));
            guanJianZiService.update(guanJianZi);
            map.put("guanJianZi", guanJianZi);
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
            message = JSONUtils.toJSONString(guanJianZiService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
        }else{
            message = JSONUtils.toJSONString(guanJianZiService.list());
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
        Query query = session.createQuery("select content, count(*) AS number from GuanJianZi group by Content order by number DESC");
        //2. 命名参数动态绑定查询条件  
        //query.setString("v_name", "test");  
        //2. 执行 SQL  
        List list = new ArrayList();
        list = query.list();  
        List result = new ArrayList();
        //3. 输出结果  
        for (int i = 0;i<list.size();i++) {  
        	result.add(list.get(i));
        }  
        //4. 事务提交  
        tr.commit();  
        //5. 关闭 session  
        session.close();
        
    	

        message = JSONUtils.toJSONString(result);
        System.out.println("GuanJianZi--------------: " + message);
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }

}