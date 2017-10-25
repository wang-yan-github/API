package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfjgJcjgServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZfjgJcjg> implements cn.wangyanfsd.api.service.ZfjgJcjgService{

    private cn.wangyanfsd.api.dao.ZfjgJcjgDao zfjgJcjgDao = new cn.wangyanfsd.api.dao.impl.ZfjgJcjgDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfjgJcjg> list(){
        return zfjgJcjgDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfjgJcjg> list(String where,Object... params){
        return zfjgJcjgDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZfjgJcjg t){
        zfjgJcjgDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZfjgJcjg t){
        zfjgJcjgDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZfjgJcjg find(java.io.Serializable id){
        return zfjgJcjgDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfjgJcjgDao.remove(id);
    }

    }