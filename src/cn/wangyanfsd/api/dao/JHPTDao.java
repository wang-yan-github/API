package cn.wangyanfsd.api.dao;

import java.util.List;

import cn.wangyanfsd.api.bean.JHPT;

public interface JHPTDao extends BaseDao<JHPT> {
	public void batchSave(List<JHPT> students);
}
