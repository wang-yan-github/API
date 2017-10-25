package cn.wangyanfsd.api.service;

import com.cdzg.pagination.Pagination;

import cn.wangyanfsd.api.bean.JHPT;

public interface JHPTBiz {
	public boolean addJHPT(JHPT JHPT);
	public boolean deleteJHPT(Integer JHPTId);
	public void updateJHPT(JHPT JHPT);
	public JHPT getJHPTById(Integer JHPTId);
	public JHPT getJHPTByName(String name);
	public Pagination<JHPT> getJHPTList(Integer pageIndex,Integer pageSize);
}
