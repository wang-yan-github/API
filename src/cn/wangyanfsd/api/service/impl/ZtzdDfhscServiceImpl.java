package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdDfhscServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdDfhsc> implements cn.wangyanfsd.api.service.ZtzdDfhscService{

    private cn.wangyanfsd.api.dao.ZtzdDfhscDao ztzdDfhscDao = new cn.wangyanfsd.api.dao.impl.ZtzdDfhscDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdDfhsc> list(){
        return ztzdDfhscDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdDfhsc> list(String where,Object... params){
        return ztzdDfhscDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdDfhsc t){
        ztzdDfhscDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdDfhsc t){
        ztzdDfhscDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdDfhsc find(java.io.Serializable id){
        return ztzdDfhscDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdDfhscDao.remove(id);
    }

    }