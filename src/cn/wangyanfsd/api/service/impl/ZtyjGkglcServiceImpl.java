package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtyjGkglcServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtyjGkglc> implements cn.wangyanfsd.api.service.ZtyjGkglcService{

    private cn.wangyanfsd.api.dao.ZtyjGkglcDao ztyjGkglcDao = new cn.wangyanfsd.api.dao.impl.ZtyjGkglcDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjGkglc> list(){
        return ztyjGkglcDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtyjGkglc> list(String where,Object... params){
        return ztyjGkglcDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtyjGkglc t){
        ztyjGkglcDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtyjGkglc t){
        ztyjGkglcDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtyjGkglc find(java.io.Serializable id){
        return ztyjGkglcDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztyjGkglcDao.remove(id);
    }

    }