package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class ZtzdGkglcServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.ZtzdGkglc> implements cn.wangyanfsd.api.service.ZtzdGkglcService{

    private cn.wangyanfsd.api.dao.ZtzdGkglcDao ztzdGkglcDao = new cn.wangyanfsd.api.dao.impl.ZtzdGkglcDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdGkglc> list(){
        return ztzdGkglcDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.ZtzdGkglc> list(String where,Object... params){
        return ztzdGkglcDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.ZtzdGkglc t){
        ztzdGkglcDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.ZtzdGkglc t){
        ztzdGkglcDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.ZtzdGkglc find(java.io.Serializable id){
        return ztzdGkglcDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        ztzdGkglcDao.remove(id);
    }

    }