package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class GxzdCwgkServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.GxzdCwgk> implements cn.wangyanfsd.api.service.GxzdCwgkService{

    private cn.wangyanfsd.api.dao.GxzdCwgkDao gxzdCwgkDao = new cn.wangyanfsd.api.dao.impl.GxzdCwgkDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GxzdCwgk> list(){
        return gxzdCwgkDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GxzdCwgk> list(String where,Object... params){
        return gxzdCwgkDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.GxzdCwgk t){
        gxzdCwgkDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.GxzdCwgk t){
        gxzdCwgkDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.GxzdCwgk find(java.io.Serializable id){
        return gxzdCwgkDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        gxzdCwgkDao.remove(id);
    }

    }