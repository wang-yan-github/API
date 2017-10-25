package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjXzjtServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjXzjt> implements cn.wangyanfsd.api.service.ZtyjXzjtService{

    private cn.wangyanfsd.api.dao.ZtyjXzjtDao ztyjXzjtDao = new cn.wangyanfsd.api.dao.impl.ZtyjXzjtDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjXzjt> list(){
        return ztyjXzjtDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjXzjt> list(String where,Object... params){
        return ztyjXzjtDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjXzjt t){
        ztyjXzjtDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjXzjt t){
        ztyjXzjtDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjXzjt find(java.io.Serializable id){
        return ztyjXzjtDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjXzjtDao.remove(id);
    }

    }