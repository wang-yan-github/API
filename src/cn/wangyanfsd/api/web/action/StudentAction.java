package cn.wangyanfsd.api.web.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.Classroom;
import cn.wangyanfsd.api.bean.Student;
import cn.wangyanfsd.api.service.ClassroomBiz;
import cn.wangyanfsd.api.service.StudentBiz;
import cn.wangyanfsd.api.service.impl.ClassroomBizImpl;
import cn.wangyanfsd.api.service.impl.StudentBizImpl;
import cn.wangyanfsd.api.util.TransactionUtil;

public class StudentAction extends HttpServlet {
	private static final long serialVersionUID = -7641015202674205501L;
	private StudentBiz studentBiz = (StudentBiz)new TransactionUtil().newProxy(new StudentBizImpl());
	private ClassroomBiz classroomBiz = (ClassroomBiz)new TransactionUtil().newProxy(new ClassroomBizImpl());
	private HttpServletRequest request;
	private Integer pageIndex = 1;
	private Integer pageSize = 3;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//http://localhost:8080/page/studentAction?choice=studentList&pageIndex=3&pageSize=3
		String choice = request.getParameter("choice");
		this.request = request;
		Result r = null;
		if ("studentList".equals(choice)) {
			r = studentList();
		} else if ("addStudentUI".equals(choice)) {
			r = addStudentUI();
		} else if ("deleteStudent".equals(choice)) {
			r = deleteStudent();
		} else if ("addStudent".equals(choice)) {
			r = addStudent();
		}
		
		if (r == null) {
			response.sendRedirect("/error.jsp");
		} else if (r.isRedirect()) {
			response.sendRedirect(r.getPath());
		} else {
			request.getRequestDispatcher(r.getPath()).forward(request,response);
		}
	}
	private Result addStudent() {
		Integer classId =Integer.parseInt(request.getParameter("classId"));
		//这里最好拿classId去查询一次数据库表，把classId对应的班级对象查询出来。
		Classroom classroom = new Classroom();
		classroom.setClassId(classId);
		
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		Student student = new Student(userName,passWord);
		student.setClassroom(classroom);
		
		studentBiz.addStudent(student);
		return new Result("studentAction?choice=studentList", true);
	}
	private Result deleteStudent() {
		Integer studentId = Integer.parseInt(request.getParameter("studentId"));
		pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		pageSize = Integer.parseInt(request.getParameter("pageSize"));
		if (studentBiz.deleteStudent(studentId)) {
			pageIndex = 1;
			pageSize = 3;
		}
		return new Result("studentAction?choice=studentList&pageIndex=" + pageIndex + "&pageSize=" + pageSize, true);
	}
	private Result addStudentUI() {
		List<Classroom> classroomList = classroomBiz.getClassroomList();
		request.setAttribute("classroomList", classroomList);
		return new Result("/WEB-INF/page/addStudentUI.jsp");
	}
	private Result studentList() {
		String pageIndexs = request.getParameter("pageIndex");
		if (pageIndexs != null) {
			pageIndex = Integer.parseInt(pageIndexs);
		}
		String pageSizes = request.getParameter("pageSize");
		if (pageSizes != null) {
			pageSize = Integer.parseInt(pageSizes);
		}
		Pagination<Student> studentList = studentBiz.getStudentList(pageIndex, pageSize);
		studentList.setPageNumber(3);
		request.setAttribute("studentList",studentList);
		return new Result("/WEB-INF/page/studentList.jsp");
	}
}
