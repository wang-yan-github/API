package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdGlglzServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdGlglz> implements cn.wangyanfsd.api.service.ZtzdGlglzService{

    private cn.wangyanfsd.api.dao.ZtzdGlglzDao ztzdGlglzDao = new cn.wangyanfsd.api.dao.impl.ZtzdGlglzDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdGlglz> list(){
        return ztzdGlglzDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdGlglz> list(String where,Object... params){
        return ztzdGlglzDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdGlglz t){
        ztzdGlglzDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdGlglz t){
        ztzdGlglzDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdGlglz find(java.io.Serializable id){
        return ztzdGlglzDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdGlglzDao.remove(id);
    }

    }