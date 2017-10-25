package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjJtysglsServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjJtysgls> implements cn.wangyanfsd.api.service.ZtyjJtysglsService{

    private cn.wangyanfsd.api.dao.ZtyjJtysglsDao ztyjJtysglsDao = new cn.wangyanfsd.api.dao.impl.ZtyjJtysglsDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjJtysgls> list(){
        return ztyjJtysglsDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjJtysgls> list(String where,Object... params){
        return ztyjJtysglsDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjJtysgls t){
        ztyjJtysglsDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjJtysgls t){
        ztyjJtysglsDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjJtysgls find(java.io.Serializable id){
        return ztyjJtysglsDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjJtysglsDao.remove(id);
    }

    }