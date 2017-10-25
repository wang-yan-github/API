package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZfqxQlsxServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZfqxQlsx> implements cn.wangyanfsd.api.service.ZfqxQlsxService{

    private cn.wangyanfsd.api.dao.ZfqxQlsxDao zfqxQlsxDao = new cn.wangyanfsd.api.dao.impl.ZfqxQlsxDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfqxQlsx> list(){
        return zfqxQlsxDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZfqxQlsx> list(String where,Object... params){
        return zfqxQlsxDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZfqxQlsx t){
        zfqxQlsxDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZfqxQlsx t){
        zfqxQlsxDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZfqxQlsx find(java.io.Serializable id){
        return zfqxQlsxDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        zfqxQlsxDao.remove(id);
    }

    }