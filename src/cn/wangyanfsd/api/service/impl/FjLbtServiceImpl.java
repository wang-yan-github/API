package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class FjLbtServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.FjLbt> implements cn.wangyanfsd.api.service.FjLbtService{

    private cn.wangyanfsd.api.dao.FjLbtDao fjLbtDao = new cn.wangyanfsd.api.dao.impl.FjLbtDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjLbt> list(){
        return fjLbtDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjLbt> list(String where,Object... params){
        return fjLbtDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.FjLbt t){
        fjLbtDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.FjLbt t){
        fjLbtDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.FjLbt find(java.io.Serializable id){
        return fjLbtDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        fjLbtDao.remove(id);
    }

    }