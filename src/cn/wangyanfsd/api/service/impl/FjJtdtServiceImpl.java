package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class FjJtdtServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.FjJtdt> implements cn.wangyanfsd.api.service.FjJtdtService{

    private cn.wangyanfsd.api.dao.FjJtdtDao fjJtdtDao = new cn.wangyanfsd.api.dao.impl.FjJtdtDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjJtdt> list(){
        return fjJtdtDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjJtdt> list(String where,Object... params){
        return fjJtdtDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.FjJtdt t){
        fjJtdtDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.FjJtdt t){
        fjJtdtDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.FjJtdt find(java.io.Serializable id){
        return fjJtdtDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        fjJtdtDao.remove(id);
    }

    }