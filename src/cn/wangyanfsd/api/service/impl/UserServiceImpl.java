package cn.wangyanfsd.api.service.impl;

/**
 * @author wangy(wangy@cnliren.com)
 * @date 2017-11-06
 */
public class UserServiceImpl extends cn.wangyanfsd.api.service.impl.AbstractBaseServiceImpl<cn.wangyanfsd.api.bean.User> implements cn.wangyanfsd.api.service.UserService{

    private cn.wangyanfsd.api.dao.UserDao userDao = new cn.wangyanfsd.api.dao.impl.UserDaoImpl();

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.User> list(){
        return userDao.list();
    }

    @Override
    public java.util.List<cn.wangyanfsd.api.bean.User> list(String where,Object... params){
        return userDao.list(where,params);
    }

    @Override
    public void save(cn.wangyanfsd.api.bean.User t){
        userDao.save(t);
    }

    @Override
    public void update(cn.wangyanfsd.api.bean.User t){
        userDao.update(t);
    }

    @Override
    public cn.wangyanfsd.api.bean.User find(java.io.Serializable id){
        return userDao.find(id);
    }

    @Override
    public void remove(java.io.Serializable id){
        userDao.remove(id);
    }

    }