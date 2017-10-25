package cn.wangyanfsd.api.dao.impl;

import java.util.List;

import cn.wangyanfsd.api.bean.Student;
import cn.wangyanfsd.api.dao.StudentDao;

public class StudentDaoImpl extends BaseDaoSupport<Student> implements
		StudentDao {
	public void batchSave(List<Student> students) {
		for (Student student : students) {
			save(student);
		}
	}
}
