package cn.wangyanfsd.api.service;

import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.Student;

public interface StudentBiz {
	public boolean addStudent(Student student);
	public boolean deleteStudent(Integer studentId);
	public void updateStudent(Student student);
	public Student getStudentById(Integer studentId);
	public Student getStudentByNameAndPass(String userName,String passWord);
	public Pagination<Student> getStudentList(Integer pageIndex,Integer pageSize);
}
