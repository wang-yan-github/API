package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class BslcXklcServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.BslcXklc> implements cn.wangyanfsd.api.service.BslcXklcService{

    private cn.wangyanfsd.api.dao.BslcXklcDao bslcXklcDao = new cn.wangyanfsd.api.dao.impl.BslcXklcDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcXklc> list(){
        return bslcXklcDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcXklc> list(String where,Object... params){
        return bslcXklcDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.BslcXklc t){
        bslcXklcDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.BslcXklc t){
        bslcXklcDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.BslcXklc find(java.io.Serializable id){
        return bslcXklcDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        bslcXklcDao.remove(id);
    }

    }