package cn.wangyanfsd.api.service;

import cn.wangyanfsd.api.dao.BaseDao;

public interface BaseService<T> {

	BaseDao<T> getBaseDao();

}
