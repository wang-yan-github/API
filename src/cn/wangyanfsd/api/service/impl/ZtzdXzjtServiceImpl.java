package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdXzjtServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdXzjt> implements cn.wangyanfsd.api.service.ZtzdXzjtService{

    private cn.wangyanfsd.api.dao.ZtzdXzjtDao ztzdXzjtDao = new cn.wangyanfsd.api.dao.impl.ZtzdXzjtDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdXzjt> list(){
        return ztzdXzjtDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdXzjt> list(String where,Object... params){
        return ztzdXzjtDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdXzjt t){
        ztzdXzjtDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdXzjt t){
        ztzdXzjtDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdXzjt find(java.io.Serializable id){
        return ztzdXzjtDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdXzjtDao.remove(id);
    }

    }