package cn.wangyanfsd.api.service.impl;

import java.util.List;

import cn.wangyanfsd.api.bean.GxzdSsfa;
import cn.wangyanfsd.api.dao.GxzdSsfaDao;
import cn.wangyanfsd.api.dao.impl.GxzdSsfaDaoImpl;
import cn.wangyanfsd.api.service.GxzdSsfaBiz;

public class GxzdSsfaBizImpl implements GxzdSsfaBiz {
	private GxzdSsfaDao GxzdSsfaDao = new GxzdSsfaDaoImpl();
	public List<GxzdSsfa> getGxzdSsfaList() {
		return GxzdSsfaDao.list();
	}
}
