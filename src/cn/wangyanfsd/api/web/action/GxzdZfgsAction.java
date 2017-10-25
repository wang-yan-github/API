package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.bean.GxzdZfgs;
import cn.wangyanfsd.api.service.GxzdZfgsBiz;
import cn.wangyanfsd.api.service.impl.GxzdZfgsBizImpl;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.TransactionUtil;

public class GxzdZfgsAction extends HttpServlet {
	private static final long serialVersionUID = -7641015202674205501L;
	private GxzdZfgsBiz GxzdZfgsBiz = (GxzdZfgsBiz)new TransactionUtil().newProxy(new GxzdZfgsBizImpl());
	private HttpServletRequest request;
	private String message;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/API/GxzdZfgsAction?choice=GxzdZfgsList
		String choice = request.getParameter("choice");
		this.request = request;
		Result r = null;
		if ("GxzdZfgsList".equals(choice)) {
			r = GxzdZfgsList();
		} else if ("deleteGxzdZfgs".equals(choice)) {
			//r = deleteGxzdZfgs();
		} else if ("addGxzdZfgs".equals(choice)) {
			//r = addGxzdZfgs();
		}
		
		 // 设置响应内容类型
		 response.setContentType("text/html");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset==utf-8");
	     PrintWriter out = response.getWriter();
	     out.println(message);
	     out.flush();
		
	}
	
	
	private Result GxzdZfgsList() {
		List<GxzdZfgs> GxzdZfgsList = GxzdZfgsBiz.getGxzdZfgsList();
		message = JSONUtils.toJSONString(GxzdZfgsList);
		request.setAttribute("GxzdZfgsList",GxzdZfgsList);
		return new Result("/WEB-INF/index.html");
	}
}
