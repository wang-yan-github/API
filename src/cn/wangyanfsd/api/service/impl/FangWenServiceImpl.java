package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-07
 */
public class FangWenServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.FangWen> implements cn.wangyanfsd.api.service.FangWenService{

    private cn.wangyanfsd.api.dao.FangWenDao fangWenDao = new cn.wangyanfsd.api.dao.impl.FangWenDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FangWen> list(){
        return fangWenDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.FangWen> list(String where,Object... params){
        return fangWenDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.FangWen t){
        fangWenDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.FangWen t){
        fangWenDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.FangWen find(java.io.Serializable id){
        return fangWenDao.find(id);
    }
    
    @Override
    public cn.wangyanfsd.api.bean.FangWen find(String where,Object... params){
    	return fangWenDao.find(where, params);
    }

    @Override
    public void remove(java.io.Serializable id){
        fangWenDao.remove(id);
    }
    
    @Override
    public Integer getCount(){
    	return fangWenDao.getCount();
    };
    
    @Override
	public Integer getCount(String where,Object...params){
    	return fangWenDao.getCount(where, params);
    }
    
    }