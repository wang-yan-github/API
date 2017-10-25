package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdJtysglsServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdJtysgls> implements cn.wangyanfsd.api.service.ZtzdJtysglsService{

    private cn.wangyanfsd.api.dao.ZtzdJtysglsDao ztzdJtysglsDao = new cn.wangyanfsd.api.dao.impl.ZtzdJtysglsDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdJtysgls> list(){
        return ztzdJtysglsDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdJtysgls> list(String where,Object... params){
        return ztzdJtysglsDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdJtysgls t){
        ztzdJtysglsDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdJtysgls t){
        ztzdJtysglsDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdJtysgls find(java.io.Serializable id){
        return ztzdJtysglsDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdJtysglsDao.remove(id);
    }

    }