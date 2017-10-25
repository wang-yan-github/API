package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfqxJcsxServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZfqxJcsx> implements cn.wangyanfsd.api.service.ZfqxJcsxService{

    private cn.wangyanfsd.api.dao.ZfqxJcsxDao zfqxJcsxDao = new cn.wangyanfsd.api.dao.impl.ZfqxJcsxDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfqxJcsx> list(){
        return zfqxJcsxDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfqxJcsx> list(String where,Object... params){
        return zfqxJcsxDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZfqxJcsx t){
        zfqxJcsxDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZfqxJcsx t){
        zfqxJcsxDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZfqxJcsx find(java.io.Serializable id){
        return zfqxJcsxDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfqxJcsxDao.remove(id);
    }

    }