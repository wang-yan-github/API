package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.wangyanfsd.api.bean.GxzdCwgk;
import cn.wangyanfsd.api.service.GxzdCwgkBiz;
import cn.wangyanfsd.api.service.impl.GxzdCwgkBizImpl;
import cn.wangyanfsd.api.util.JSONUtils;
import cn.wangyanfsd.api.util.TransactionUtil;

public class GxzdCwgkAction extends HttpServlet {
	private static final long serialVersionUID = -7641015202674205501L;
	private GxzdCwgkBiz GxzdCwgkBiz = (GxzdCwgkBiz)new TransactionUtil().newProxy(new GxzdCwgkBizImpl());
	private HttpServletRequest request;
	private String message;

	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/API/GxzdCwgkAction?choice=GxzdCwgkList
		String choice = request.getParameter("choice");
		this.request = request;
		Result r = null;
		if ("GxzdCwgkList".equals(choice)) {
			r = GxzdCwgkList();
		} else if ("deleteGxzdCwgk".equals(choice)) {
			//r = deleteGxzdCwgk();
		} else if ("addGxzdCwgk".equals(choice)) {
			//r = addGxzdCwgk();
		}
		
		 // 设置响应内容类型
		 response.setContentType("text/html");
		 response.setCharacterEncoding("utf-8");
	     response.setContentType("text/html;charset==utf-8");
	     PrintWriter out = response.getWriter();
	     out.println(message);
	     out.flush();
		
	}
	
	
	private Result GxzdCwgkList() {
		List<GxzdCwgk> GxzdCwgkList = GxzdCwgkBiz.getGxzdCwgkList();
		message = JSONUtils.toJSONString(GxzdCwgkList);
		request.setAttribute("GxzdCwgkList",GxzdCwgkList);
		return new Result("/WEB-INF/index.html");
	}
}
