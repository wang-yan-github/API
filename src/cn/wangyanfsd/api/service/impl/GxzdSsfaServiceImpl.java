package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class GxzdSsfaServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.GxzdSsfa> implements cn.wangyanfsd.api.service.GxzdSsfaService{

    private cn.wangyanfsd.api.dao.GxzdSsfaDao gxzdSsfaDao = new cn.wangyanfsd.api.dao.impl.GxzdSsfaDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GxzdSsfa> list(){
        return gxzdSsfaDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GxzdSsfa> list(String where,Object... params){
        return gxzdSsfaDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.GxzdSsfa t){
        gxzdSsfaDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.GxzdSsfa t){
        gxzdSsfaDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.GxzdSsfa find(java.io.Serializable id){
        return gxzdSsfaDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        gxzdSsfaDao.remove(id);
    }

    }