package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.StrUtil;
import cn.wangyanfsd.api.util.TransactionUtil;

import cn.wangyanfsd.api.bean.User;
import cn.wangyanfsd.api.service.UserService;
import cn.wangyanfsd.api.service.impl.UserServiceImpl;

public class UserAction extends HttpServlet {

    private UserService userService = (UserService)new TransactionUtil().newProxy(new UserServiceImpl());
    Map <Object,Object> map;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private String message;
    private String userName;
    private String passWord;
    private String identity;
    private String url;
    List list;
    

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        this.request = request;
        request.setCharacterEncoding("UTF-8");
        String choice = request.getParameter("choice");
        url = request.getParameter("url");
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
            find();
        }

        PrintWriter out = response.getWriter();
        out.println(message);
        out.flush();

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    private Result save() {

        userName = request.getParameter("userName");
        passWord = request.getParameter("passWord");
        identity = request.getParameter("identity");
        map = new HashMap<Object,Object>();

        if(!"".equals(userName)&&userName!=null&&!"".equals(passWord)&&passWord!=null){
            User user = new User();
            user.setPassWord(passWord);
            user.setUserName(userName);
            user.setIdentity(identity);
            userService.save(user);
            map.put("user", user);
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
            map.put("user", userService.find(i));
            userService.remove(i);
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
        userName = request.getParameter("userName");
        passWord = request.getParameter("passWord");
        identity = request.getParameter("identity");
        map = new HashMap<Object,Object>();

        if(!"".equals(userName)&&userName!=null&&!"".equals(passWord)&&passWord!=null){
            User user = new User();
            user.setId(Integer.parseInt(id));
            user.setPassWord(passWord);
            user.setUserName(userName);
            user.setIdentity(identity);
            userService.update(user);
            map.put("user", user);
            map.put("message", "修改成功");
        }else{
        	map.put("message", "输入参错不正确，或内容不存在");
        }

        message = JSONUtils.toJSONString(map);
        request.setAttribute("message",map);
        return new Result("/WEB-INF/index.html");
    }

    private Result list() {
    	return null;
    }

    private Result find() throws ServletException, IOException {

    	String where = request.getParameter("where");
        userName = request.getParameter("userName");
        passWord = request.getParameter("passWord");
        list = new ArrayList();

        if(!"".equals(userName)&&userName!=null&&!"".equals(passWord)&&passWord!=null){
        	List i = userService.list(" userName = '"+userName+"' and passWord = '"+passWord+" '  ",null);
        	if(i.size() > 0 ){
        		list.add("1");
        	}else{
        		list.add("0");
        	}
        }
        
        message = JSONUtils.toJSONString(list);
        request.setAttribute("message",JSONUtils.toJSONString(list));
        return new Result("/WEB-INF/index.html");
		
    }

}