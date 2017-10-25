package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class BslcCflcServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.BslcCflc> implements cn.wangyanfsd.api.service.BslcCflcService{

    private cn.wangyanfsd.api.dao.BslcCflcDao bslcCflcDao = new cn.wangyanfsd.api.dao.impl.BslcCflcDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcCflc> list(){
        return bslcCflcDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcCflc> list(String where,Object... params){
        return bslcCflcDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.BslcCflc t){
        bslcCflcDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.BslcCflc t){
        bslcCflcDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.BslcCflc find(java.io.Serializable id){
        return bslcCflcDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        bslcCflcDao.remove(id);
    }

    }