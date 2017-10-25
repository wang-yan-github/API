package cn.wangyanfsd.api.service.impl;

import com.cdzg.pagination.DefaultPagination;
import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.JHPT;
import cn.wangyanfsd.api.dao.JHPTDao;
import cn.wangyanfsd.api.dao.impl.JHPTDaoImpl;
import cn.wangyanfsd.api.service.JHPTBiz;

public class JHPTBizImpl implements JHPTBiz {
	private JHPTDao JHPTDao = new JHPTDaoImpl();
	//开启事务
	public boolean addJHPT(JHPT JHPT) {
		try {
			JHPTDao.save(JHPT);
			return true;
		} catch (Exception e) {
			return false;
		} 
	}
	//提交或回滚事务

	public boolean deleteJHPT(Integer JHPTId) {
		try {
			JHPTDao.remove(JHPTId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public JHPT getJHPTById(Integer JHPTId) {
		return JHPTDao.find(JHPTId);
	}

	public JHPT getJHPTByName(String name) {
		return JHPTDao.find("o.yxt = ?", name);
	}

	public void updateJHPT(JHPT JHPT) {
		JHPTDao.update(JHPT);
	}

	public Pagination<JHPT> getJHPTList(Integer pageIndex,
			Integer pageSize) {
		return new DefaultPagination<JHPT>(JHPTDao.queryResult(pageIndex, pageSize), pageIndex, pageSize);
	}

}
