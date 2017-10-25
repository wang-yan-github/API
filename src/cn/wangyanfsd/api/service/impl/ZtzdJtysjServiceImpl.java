package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdJtysjServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdJtysj> implements cn.wangyanfsd.api.service.ZtzdJtysjService{

    private cn.wangyanfsd.api.dao.ZtzdJtysjDao ztzdJtysjDao = new cn.wangyanfsd.api.dao.impl.ZtzdJtysjDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdJtysj> list(){
        return ztzdJtysjDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdJtysj> list(String where,Object... params){
        return ztzdJtysjDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdJtysj t){
        ztzdJtysjDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdJtysj t){
        ztzdJtysjDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdJtysj find(java.io.Serializable id){
        return ztzdJtysjDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdJtysjDao.remove(id);
    }

    }