package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjJtysjServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjJtysj> implements cn.wangyanfsd.api.service.ZtyjJtysjService{

    private cn.wangyanfsd.api.dao.ZtyjJtysjDao ztyjJtysjDao = new cn.wangyanfsd.api.dao.impl.ZtyjJtysjDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjJtysj> list(){
        return ztyjJtysjDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjJtysj> list(String where,Object... params){
        return ztyjJtysjDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjJtysj t){
        ztyjJtysjDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjJtysj t){
        ztyjJtysjDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjJtysj find(java.io.Serializable id){
        return ztyjJtysjDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjJtysjDao.remove(id);
    }

    }