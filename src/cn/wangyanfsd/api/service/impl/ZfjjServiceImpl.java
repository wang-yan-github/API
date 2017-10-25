package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfjjServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.Zfjj> implements cn.wangyanfsd.api.service.ZfjjService{

    private cn.wangyanfsd.api.dao.ZfjjDao zfjj1Dao = new cn.wangyanfsd.api.dao.impl.ZfjjDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.Zfjj> list(){
        return zfjj1Dao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.Zfjj> list(String where,Object... params){
        return zfjj1Dao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.Zfjj t){
        zfjj1Dao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.Zfjj t){
        zfjj1Dao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.Zfjj find(java.io.Serializable id){
        return zfjj1Dao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfjj1Dao.remove(id);
    }

    }