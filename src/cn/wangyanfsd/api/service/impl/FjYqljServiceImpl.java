package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class FjYqljServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.FjYqlj> implements cn.wangyanfsd.api.service.FjYqljService{

    private cn.wangyanfsd.api.dao.FjYqljDao fjYqljDao = new cn.wangyanfsd.api.dao.impl.FjYqljDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjYqlj> list(){
        return fjYqljDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjYqlj> list(String where,Object... params){
        return fjYqljDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.FjYqlj t){
        fjYqljDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.FjYqlj t){
        fjYqljDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.FjYqlj find(java.io.Serializable id){
        return fjYqljDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        fjYqljDao.remove(id);
    }

    }