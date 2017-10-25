package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdHdglzServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdHdglz> implements cn.wangyanfsd.api.service.ZtzdHdglzService{

    private cn.wangyanfsd.api.dao.ZtzdHdglzDao ztzdHdglzDao = new cn.wangyanfsd.api.dao.impl.ZtzdHdglzDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdHdglz> list(){
        return ztzdHdglzDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdHdglz> list(String where,Object... params){
        return ztzdHdglzDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdHdglz t){
        ztzdHdglzDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdHdglz t){
        ztzdHdglzDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdHdglz find(java.io.Serializable id){
        return ztzdHdglzDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdHdglzDao.remove(id);
    }

    }