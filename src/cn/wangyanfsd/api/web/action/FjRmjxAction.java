package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.util.FileTools;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.StrUtil;
import cn.wangyanfsd.api.util.TransactionUtil;
import cn.wangyanfsd.api.bean.BslcCflc;
import cn.wangyanfsd.api.bean.FangWen;
import cn.wangyanfsd.api.bean.FjQdym;
import cn.wangyanfsd.api.bean.FjRmjx;
import cn.wangyanfsd.api.bean.LiuLiang;
import cn.wangyanfsd.api.service.FangWenService;
import cn.wangyanfsd.api.service.FjRmjxService;
import cn.wangyanfsd.api.service.LiuLiangService;
import cn.wangyanfsd.api.service.impl.FangWenServiceImpl;
import cn.wangyanfsd.api.service.impl.FjRmjxServiceImpl;
import cn.wangyanfsd.api.service.impl.LiuLiangServiceImpl;

public class FjRmjxAction extends HttpServlet {

    private FjRmjxService fjRmjxService = (FjRmjxService)new TransactionUtil().newProxy(new FjRmjxServiceImpl());
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
        String image = request.getParameter("image");
        String date = request.getParameter("date");
        String person = request.getParameter("person");
        
        map = new HashMap<Object,Object>();

        if(!"".equals(title)&&title!=null&&!"".equals(content)&&content!=null){
            FjRmjx fjRmjx = new FjRmjx();
            fjRmjx.setTitle(title);
            fjRmjx.setContent(content);
            fjRmjx.setImage(image);
            fjRmjx.setDate(date);
            fjRmjx.setPerson(person);
            fjRmjxService.save(fjRmjx);
            map.put("fjRmjx", fjRmjx);
            System.out.println(fjRmjx.toString());
            map.put("message", "添加成功");
        }else{
        	map.put("message", "输入参错不正确，或内容不存在");
        }

        message = JSONUtils.toJSONString(map);
        System.out.println(message);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result remove() {

        String id = request.getParameter("id");
        map = new HashMap<Object,Object>();

        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)){
            int i = Integer.parseInt(id);
            FjRmjx fjRmjx = fjRmjxService.find(i);
            FileTools.rm(request.getSession().getServletContext().getRealPath("") + "/WEB-INF/upload/",fjRmjx.getImage());
            map.put("fjRmjx", fjRmjx);
            fjRmjxService.remove(i);
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
        String image = request.getParameter("image");
        String date = request.getParameter("date");
        String person = request.getParameter("person");
        map = new HashMap<Object,Object>();

        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)&&!"".equals(title)&&title!=null&&!"".equals(content)&&content!=null){
            FjRmjx fjRmjx = fjRmjxService.find(Integer.parseInt(id));
            fjRmjx.setId(Integer.parseInt(id));
            fjRmjx.setTitle(title);
            fjRmjx.setContent(content);
            fjRmjx.setDate(date);
            fjRmjx.setPerson(person);
            System.out.println(fjRmjx.toString());
            fjRmjxService.update(fjRmjx);
            map.put("fjRmjx", fjRmjx);
            map.put("message", "修改成功");
        }else{
        	map.put("message", "输入参错不正确，或内容不存在");
        }

        message = JSONUtils.toJSONString(map);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result list() {
    	
    	FangWenService fangWenService = (FangWenService)new TransactionUtil().newProxy(new FangWenServiceImpl());
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        FangWen fw = new FangWen();
        String date = sf.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
        fw.setDate(date);
        fangWenService.save(fw);
    	
        String where = request.getParameter("where");
        List list = new ArrayList();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort() + request.getContextPath() +"/UploadAction?choice=UploadFind&Location=";
		List <FjRmjx> result;

        if(!"".equals(where)&&where!=null){
        	result = fjRmjxService.list(" title LIKE '%"+where+"%' OR content LIKE '%"+where+"%'  ",null);
        	for (FjRmjx fjRmjx : result) {
        		fjRmjx.setImage(basePath+fjRmjx.getImage());
			}
            message = JSONUtils.toJSONString(result);
        }else{
        	result = fjRmjxService.list();
        	for (FjRmjx fjRmjx : result) {
        		fjRmjx.setImage(basePath+fjRmjx.getImage());
			}
            message = JSONUtils.toJSONString(result);
        }
        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }

    private Result find() {

        String id = request.getParameter("id");
        map = new HashMap<Object,Object>();

        if(!"".equals(id)&&id!=null&&StrUtil.isNumeric(id)){
            int i = Integer.parseInt(id);
            message = JSONUtils.toJSONString(fjRmjxService.find(i));
        }

        request.setAttribute("message",message);
        return new Result("/WEB-INF/index.html");
    }

}