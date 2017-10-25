package cn.wangyanfsd.api.dao.impl;

import java.util.List;

import cn.wangyanfsd.api.bean.JHPT;
import cn.wangyanfsd.api.dao.JHPTDao;

public class JHPTDaoImpl extends BaseDaoSupport<JHPT> implements
		JHPTDao {
	public void batchSave(List<JHPT> JHPTs) {
		for (JHPT JHPT : JHPTs) {
			save(JHPT);
		}
	}
}
