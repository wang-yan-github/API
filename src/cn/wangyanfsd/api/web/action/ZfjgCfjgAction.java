package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.StrUtil;
import cn.wangyanfsd.api.util.TransactionUtil;
import cn.wangyanfsd.api.bean.FangWen;
import cn.wangyanfsd.api.bean.LiuLiang;
import cn.wangyanfsd.api.bean.ZfjgCfjg;
import cn.wangyanfsd.api.service.FangWenService;
import cn.wangyanfsd.api.service.LiuLiangService;
import cn.wangyanfsd.api.service.ZfjgCfjgService;
import cn.wangyanfsd.api.service.impl.FangWenServiceImpl;
import cn.wangyanfsd.api.service.impl.LiuLiangServiceImpl;
import cn.wangyanfsd.api.service.impl.ZfjgCfjgServiceImpl;

public class ZfjgCfjgAction extends HttpServlet {

    private ZfjgCfjgService zfjgCfjgService = (ZfjgCfjgService)new TransactionUtil().newProxy(new ZfjgCfjgServiceImpl());
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
            ZfjgCfjg zfjgCfjg = new ZfjgCfjg();
            zfjgCfjg.setTitle(title);
            zfjgCfjg.setContent(content);
            zfjgCfjg.setDate(date);
            zfjgCfjg.setPerson(person);
            zfjgCfjgService.save(zfjgCfjg);
            map.put("zfjgCfjg", zfjgCfjg);
            map.put("message", "���ӳɹ�");
        }else{
        map.put("message", "����δ�����ȷ�������ݲ�����");
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
            map.put("zfjgCfjg", zfjgCfjgService.find(i));
            zfjgCfjgService.remove(i);
            map.put("message", "ɾ���ɹ�");
        }else{
        map.put("message", "����δ�����ȷ�������ݲ�����");
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
            ZfjgCfjg zfjgCfjg = new ZfjgCfjg();
            zfjgCfjg.setId(Integer.parseInt(id));
            zfjgCfjg.setTitle(title);
            zfjgCfjg.setContent(content);
            zfjgCfjg.setDate(date);
            zfjgCfjg.setPerson(person);
            zfjgCfjgService.update(zfjgCfjg);
            map.put("zfjgCfjg", zfjgCfjg);
            map.put("message", "�޸ĳɹ�");
        }else{
        map.put("message", "����δ�����ȷ�������ݲ�����");
        }

        message = JSONUtils.toJSONString(map);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result list() {
    	
    	LiuLiang ll = liuLiangService.find("content = 'ZfjgCfjg' ",null);
    	ll.setNumber(ll.getNumber() +1);
    	liuLiangService.update(ll);
    	
    	FangWenService fangWenService = (FangWenService)new TransactionUtil().newProxy(new FangWenServiceImpl());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
        FangWen fw = new FangWen();
        String date = sf.format(new Date());// new Date()Ϊ��ȡ��ǰϵͳʱ�䣬Ҳ��ʹ�õ�ǰʱ���
        fw.setDate(date);
        fangWenService.save(fw);

        String where = request.getParameter("where");
        List list = new ArrayList();

        if(!"".equals(where)&&where!=null){
            message = JSONUtils.toJSONString(zfjgCfjgService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null));
        }else{
            message = JSONUtils.toJSONString(zfjgCfjgService.list());
        }
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }

    private Result find() {

        String id = request.getParameter("id");
        map = new HashMap<Object,Object>();

        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)){
            int i = Integer.parseInt(id);
            message = JSONUtils.toJSONString(zfjgCfjgService.find(i));
        }

        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }

}