package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class FjQdymServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.FjQdym> implements cn.wangyanfsd.api.service.FjQdymService{

    private cn.wangyanfsd.api.dao.FjQdymDao fjQdymDao = new cn.wangyanfsd.api.dao.impl.FjQdymDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjQdym> list(){
        return fjQdymDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjQdym> list(String where,Object... params){
        return fjQdymDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.FjQdym t){
        fjQdymDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.FjQdym t){
        fjQdymDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.FjQdym find(java.io.Serializable id){
        return fjQdymDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        fjQdymDao.remove(id);
    }

    }