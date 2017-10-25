package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjJtgczlServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjJtgczl> implements cn.wangyanfsd.api.service.ZtyjJtgczlService{

    private cn.wangyanfsd.api.dao.ZtyjJtgczlDao ztyjJtgczlDao = new cn.wangyanfsd.api.dao.impl.ZtyjJtgczlDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjJtgczl> list(){
        return ztyjJtgczlDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjJtgczl> list(String where,Object... params){
        return ztyjJtgczlDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjJtgczl t){
        ztyjJtgczlDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjJtgczl t){
        ztyjJtgczlDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjJtgczl find(java.io.Serializable id){
        return ztyjJtgczlDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjJtgczlDao.remove(id);
    }

    }