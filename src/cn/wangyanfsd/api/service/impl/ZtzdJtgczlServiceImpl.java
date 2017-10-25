package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdJtgczlServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdJtgczl> implements cn.wangyanfsd.api.service.ZtzdJtgczlService{

    private cn.wangyanfsd.api.dao.ZtzdJtgczlDao ztzdJtgczlDao = new cn.wangyanfsd.api.dao.impl.ZtzdJtgczlDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdJtgczl> list(){
        return ztzdJtgczlDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdJtgczl> list(String where,Object... params){
        return ztzdJtgczlDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdJtgczl t){
        ztzdJtgczlDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdJtgczl t){
        ztzdJtgczlDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdJtgczl find(java.io.Serializable id){
        return ztzdJtgczlDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdJtgczlDao.remove(id);
    }

    }