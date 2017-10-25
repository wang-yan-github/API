package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class GxzdZfgsServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.GxzdZfgs> implements cn.wangyanfsd.api.service.GxzdZfgsService{

    private cn.wangyanfsd.api.dao.GxzdZfgsDao gxzdZfgsDao = new cn.wangyanfsd.api.dao.impl.GxzdZfgsDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GxzdZfgs> list(){
        return gxzdZfgsDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GxzdZfgs> list(String where,Object... params){
        return gxzdZfgsDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.GxzdZfgs t){
        gxzdZfgsDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.GxzdZfgs t){
        gxzdZfgsDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.GxzdZfgs find(java.io.Serializable id){
        return gxzdZfgsDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        gxzdZfgsDao.remove(id);
    }

    }