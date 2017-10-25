package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfjgCfjgServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZfjgCfjg> implements cn.wangyanfsd.api.service.ZfjgCfjgService{

    private cn.wangyanfsd.api.dao.ZfjgCfjgDao zfjgCfjgDao = new cn.wangyanfsd.api.dao.impl.ZfjgCfjgDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfjgCfjg> list(){
        return zfjgCfjgDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfjgCfjg> list(String where,Object... params){
        return zfjgCfjgDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZfjgCfjg t){
        zfjgCfjgDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZfjgCfjg t){
        zfjgCfjgDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZfjgCfjg find(java.io.Serializable id){
        return zfjgCfjgDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfjgCfjgDao.remove(id);
    }

    }