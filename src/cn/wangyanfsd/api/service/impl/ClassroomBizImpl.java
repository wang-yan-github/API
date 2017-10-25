package cn.wangyanfsd.api.service.impl;

import java.util.List;

import cn.wangyanfsd.api.bean.Classroom;
import cn.wangyanfsd.api.dao.ClassroomDao;
import cn.wangyanfsd.api.dao.impl.ClassroomDaoImpl;
import cn.wangyanfsd.api.service.ClassroomBiz;

public class ClassroomBizImpl implements ClassroomBiz {
	private ClassroomDao classroomDao = new ClassroomDaoImpl();
	public List<Classroom> getClassroomList() {
		return classroomDao.list();
	}
}
