package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfjgXkjgServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZfjgXkjg> implements cn.wangyanfsd.api.service.ZfjgXkjgService{

    private cn.wangyanfsd.api.dao.ZfjgXkjgDao zfjgXkjgDao = new cn.wangyanfsd.api.dao.impl.ZfjgXkjgDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfjgXkjg> list(){
        return zfjgXkjgDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfjgXkjg> list(String where,Object... params){
        return zfjgXkjgDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZfjgXkjg t){
        zfjgXkjgDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZfjgXkjg t){
        zfjgXkjgDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZfjgXkjg find(java.io.Serializable id){
        return zfjgXkjgDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfjgXkjgDao.remove(id);
    }

    }