package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjDfhscServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjDfhsc> implements cn.wangyanfsd.api.service.ZtyjDfhscService{

    private cn.wangyanfsd.api.dao.ZtyjDfhscDao ztyjDfhscDao = new cn.wangyanfsd.api.dao.impl.ZtyjDfhscDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjDfhsc> list(){
        return ztyjDfhscDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjDfhsc> list(String where,Object... params){
        return ztyjDfhscDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjDfhsc t){
        ztyjDfhscDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjDfhsc t){
        ztyjDfhscDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjDfhsc find(java.io.Serializable id){
        return ztyjDfhscDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjDfhscDao.remove(id);
    }

    }