package cn.wangyanfsd.api.dao;

import java.util.List;

import cn.wangyanfsd.api.bean.Student;

public interface StudentDao extends BaseDao<Student> {
	public void batchSave(List<Student> students);
}
