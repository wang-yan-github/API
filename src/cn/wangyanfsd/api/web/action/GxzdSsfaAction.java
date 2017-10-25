package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.bean.GxzdSsfa;
import cn.wangyanfsd.api.service.GxzdSsfaBiz;
import cn.wangyanfsd.api.service.impl.GxzdSsfaBizImpl;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.TransactionUtil;

public class GxzdSsfaAction extends HttpServlet {
	private static final long serialVersionUID = -7641015202674205501L;
	private GxzdSsfaBiz GxzdSsfaBiz = (GxzdSsfaBiz)new TransactionUtil().newProxy(new GxzdSsfaBizImpl());
	private HttpServletRequest request;
	private String message;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/API/GxzdSsfaAction?choice=GxzdSsfaList
		String choice = request.getParameter("choice");
		this.request = request;
		Result r = null;
		if ("GxzdSsfaList".equals(choice)) {
			r = GxzdSsfaList();
		} else if ("deleteGxzdSsfa".equals(choice)) {
			//r = deleteGxzdSsfa();
		} else if ("addGxzdSsfa".equals(choice)) {
			//r = addGxzdSsfa();
		}
		
		 // 设置响应内容类型
		 response.setContentType("text/html");
		 response.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset==utf-8");
	     PrintWriter out = response.getWriter();
	     out.println(message);
	     out.flush();
		
	}
	
	
	private Result GxzdSsfaList() {
		List<GxzdSsfa> GxzdSsfaList = GxzdSsfaBiz.getGxzdSsfaList();
		message = JSONUtils.toJSONString(GxzdSsfaList);
		request.setAttribute("GxzdSsfaList",GxzdSsfaList);
		return new Result("/WEB-INF/index.html");
	}
}
