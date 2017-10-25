package cn.wangyanfsd.api.service.impl;

import java.util.LinkedHashMap;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-07
 */
public class LiuLiangServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.LiuLiang> implements cn.wangyanfsd.api.service.LiuLiangService{

    private cn.wangyanfsd.api.dao.LiuLiangDao liuLiangDao = new cn.wangyanfsd.api.dao.impl.LiuLiangDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.LiuLiang> list(){
        return liuLiangDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.LiuLiang> list(String where,Object... params){
        return liuLiangDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.LiuLiang t){
        liuLiangDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.LiuLiang t){
        liuLiangDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.LiuLiang find(java.io.Serializable id){
        return liuLiangDao.find(id);
    }
    
    @Override
    public cn.wangyanfsd.api.bean.LiuLiang find(String where, LinkedHashMap<String, String> orderBy, Object... params) {
    	return liuLiangDao.find(where, orderBy, params);
    }
    
    @Override
    public cn.wangyanfsd.api.bean.LiuLiang find(String where,Object... params){
    	return liuLiangDao.find(where, params);
    }

    @Override
    public void remove(java.io.Serializable id){
        liuLiangDao.remove(id);
    }
    
    @Override
    public Integer getCount(){
    	return liuLiangDao.getCount();
    }
    
    @Override
	public Integer getCount(String where,Object...params){
    	return liuLiangDao.getCount(where, params);
    }

    }