package cn.wangyanfsd.api.service.impl;

import java.util.List;

import cn.wangyanfsd.api.bean.GxzdZfgs;
import cn.wangyanfsd.api.dao.GxzdZfgsDao;
import cn.wangyanfsd.api.dao.impl.GxzdZfgsDaoImpl;
import cn.wangyanfsd.api.service.GxzdZfgsBiz;

public class GxzdZfgsBizImpl implements GxzdZfgsBiz {
	private GxzdZfgsDao GxzdZfgsDao = new GxzdZfgsDaoImpl();
	public List<GxzdZfgs> getGxzdZfgsList() {
		return GxzdZfgsDao.list();
	}
}
