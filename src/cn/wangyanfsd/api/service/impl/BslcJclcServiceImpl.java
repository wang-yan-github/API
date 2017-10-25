package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-02
 */
public class BslcJclcServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.BslcJclc> implements cn.wangyanfsd.api.service.BslcJclcService{

    private cn.wangyanfsd.api.dao.BslcJclcDao bslcJclcDao = new cn.wangyanfsd.api.dao.impl.BslcJclcDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcJclc> list(){
        return bslcJclcDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.BslcJclc> list(String where,Object... params){
        return bslcJclcDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.BslcJclc t){
        bslcJclcDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.BslcJclc t){
        bslcJclcDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.BslcJclc find(java.io.Serializable id){
        return bslcJclcDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        bslcJclcDao.remove(id);
    }

    }