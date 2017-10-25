package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjGlglzServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjGlglz> implements cn.wangyanfsd.api.service.ZtyjGlglzService{

    private cn.wangyanfsd.api.dao.ZtyjGlglzDao ztyjGlglzDao = new cn.wangyanfsd.api.dao.impl.ZtyjGlglzDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjGlglz> list(){
        return ztyjGlglzDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjGlglz> list(String where,Object... params){
        return ztyjGlglzDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjGlglz t){
        ztyjGlglzDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjGlglz t){
        ztyjGlglzDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjGlglz find(java.io.Serializable id){
        return ztyjGlglzDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjGlglzDao.remove(id);
    }

    }