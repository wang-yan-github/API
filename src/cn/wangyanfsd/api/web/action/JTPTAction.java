package cn.wangyanfsd.api.web.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.JHPT;
import cn.wangyanfsd.api.service.JHPTBiz;
import cn.wangyanfsd.api.service.impl.JHPTBizImpl;
import cn.wangyanfsd.api.util.TransactionUtil;

public class JTPTAction extends HttpServlet {
	private static final long serialVersionUID = -7641015202674205501L;
	private JHPTBiz JHPTBiz = (JHPTBiz)new TransactionUtil().newProxy(new JHPTBizImpl());
	private HttpServletRequest request;
	private Integer pageIndex = 1;
	private Integer pageSize = 3;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/page/JHPTAction?choice=JHPTList&pageIndex=3&pageSize=3
		String choice = request.getParameter("choice");
		this.request = request;
		Result r = null;
		if ("JHPTList".equals(choice)) {
			r = JHPTList();
		} 
		
		if (r == null) {
			response.sendRedirect("/error.jsp");
		} else if (r.isRedirect()) {
			response.sendRedirect(r.getPath());
		} else {
			request.getRequestDispatcher(r.getPath()).forward(request,response);
		}
	}

	private Result JHPTList() {
		String pageIndexs = request.getParameter("pageIndex");
		if (pageIndexs != null) {
			pageIndex = Integer.parseInt(pageIndexs);
		}
		String pageSizes = request.getParameter("pageSize");
		if (pageSizes != null) {
			pageSize = Integer.parseInt(pageSizes);
		}
		Pagination<JHPT> JHPTList = JHPTBiz.getJHPTList(pageIndex, pageSize);
		JHPTList.setPageNumber(3);
		request.setAttribute("JHPTList",JHPTList);
		return new Result("/WEB-INF/page/JHPTList.jsp");
	}
}
