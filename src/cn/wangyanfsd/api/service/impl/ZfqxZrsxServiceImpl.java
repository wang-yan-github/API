package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfqxZrsxServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZfqxZrsx> implements cn.wangyanfsd.api.service.ZfqxZrsxService{

    private cn.wangyanfsd.api.dao.ZfqxZrsxDao zfqxZrsxDao = new cn.wangyanfsd.api.dao.impl.ZfqxZrsxDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfqxZrsx> list(){
        return zfqxZrsxDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfqxZrsx> list(String where,Object... params){
        return zfqxZrsxDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZfqxZrsx t){
        zfqxZrsxDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZfqxZrsx t){
        zfqxZrsxDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZfqxZrsx find(java.io.Serializable id){
        return zfqxZrsxDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfqxZrsxDao.remove(id);
    }

    }