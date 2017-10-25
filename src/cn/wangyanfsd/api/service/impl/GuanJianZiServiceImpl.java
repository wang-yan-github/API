package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-07
 */
public class GuanJianZiServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.GuanJianZi> implements cn.wangyanfsd.api.service.GuanJianZiService{

    private cn.wangyanfsd.api.dao.GuanJianZiDao guanJianZiDao = new cn.wangyanfsd.api.dao.impl.GuanJianZiDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GuanJianZi> list(){
        return guanJianZiDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.GuanJianZi> list(String where,Object... params){
        return guanJianZiDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.GuanJianZi t){
        guanJianZiDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.GuanJianZi t){
        guanJianZiDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.GuanJianZi find(java.io.Serializable id){
        return guanJianZiDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        guanJianZiDao.remove(id);
    }

    }