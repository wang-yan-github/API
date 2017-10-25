package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class BslcZzlcServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.BslcZzlc> implements cn.wangyanfsd.api.service.BslcZzlcService{

    private cn.wangyanfsd.api.dao.BslcZzlcDao bslcZzlcDao = new cn.wangyanfsd.api.dao.impl.BslcZzlcDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcZzlc> list(){
        return bslcZzlcDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcZzlc> list(String where,Object... params){
        return bslcZzlcDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.BslcZzlc t){
        bslcZzlcDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.BslcZzlc t){
        bslcZzlcDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.BslcZzlc find(java.io.Serializable id){
        return bslcZzlcDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        bslcZzlcDao.remove(id);
    }

    }