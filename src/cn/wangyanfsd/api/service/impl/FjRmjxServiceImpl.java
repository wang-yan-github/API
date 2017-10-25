package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class FjRmjxServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.FjRmjx> implements cn.wangyanfsd.api.service.FjRmjxService{

    private cn.wangyanfsd.api.dao.FjRmjxDao fjRmjxDao = new cn.wangyanfsd.api.dao.impl.FjRmjxDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjRmjx> list(){
        return fjRmjxDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FjRmjx> list(String where,Object... params){
        return fjRmjxDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.FjRmjx t){
        fjRmjxDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.FjRmjx t){
        fjRmjxDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.FjRmjx find(java.io.Serializable id){
        return fjRmjxDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        fjRmjxDao.remove(id);
    }

    }