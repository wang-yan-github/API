package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjHdglzServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjHdglz> implements cn.wangyanfsd.api.service.ZtyjHdglzService{

    private cn.wangyanfsd.api.dao.ZtyjHdglzDao ztyjHdglzDao = new cn.wangyanfsd.api.dao.impl.ZtyjHdglzDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjHdglz> list(){
        return ztyjHdglzDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjHdglz> list(String where,Object... params){
        return ztyjHdglzDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjHdglz t){
        ztyjHdglzDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjHdglz t){
        ztyjHdglzDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjHdglz find(java.io.Serializable id){
        return ztyjHdglzDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjHdglzDao.remove(id);
    }

    }