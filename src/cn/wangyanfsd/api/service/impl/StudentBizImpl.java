package cn.wangyanfsd.api.service.impl;

import com.cdzg.pagination.DefaultPagination;
import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.Student;
import cn.wangyanfsd.api.dao.StudentDao;
import cn.wangyanfsd.api.dao.impl.StudentDaoImpl;
import cn.wangyanfsd.api.service.StudentBiz;

public class StudentBizImpl implements StudentBiz {
	private StudentDao studentDao = new StudentDaoImpl();
	//开启事务
	public boolean addStudent(Student student) {
		try {
			studentDao.save(student);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	//提交或回滚事务

	public boolean deleteStudent(Integer studentId) {
		try {
			studentDao.remove(studentId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Student getStudentById(Integer studentId) {
		return studentDao.find(studentId);
	}

	public Student getStudentByNameAndPass(String userName, String passWord) {
		return studentDao.find("o.userName = ? and o.passWord = ?", userName,passWord);
	}

	public void updateStudent(Student student) {
		studentDao.update(student);
	}

	public Pagination<Student> getStudentList(Integer pageIndex,
			Integer pageSize) {
		return new DefaultPagination<Student>(studentDao.queryResult(pageIndex, pageSize), pageIndex, pageSize);
	}

}
