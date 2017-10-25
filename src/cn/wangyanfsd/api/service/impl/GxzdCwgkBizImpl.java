package cn.wangyanfsd.api.service.impl;

import java.util.List;

import cn.wangyanfsd.api.bean.GxzdCwgk;
import cn.wangyanfsd.api.dao.GxzdCwgkDao;
import cn.wangyanfsd.api.dao.impl.GxzdCwgkDaoImpl;
import cn.wangyanfsd.api.service.GxzdCwgkBiz;

public class GxzdCwgkBizImpl implements GxzdCwgkBiz {
	private GxzdCwgkDao GxzdCwgkDao = new GxzdCwgkDaoImpl();
	public List<GxzdCwgk> getGxzdCwgkList() {
		return GxzdCwgkDao.list();
	}
}
