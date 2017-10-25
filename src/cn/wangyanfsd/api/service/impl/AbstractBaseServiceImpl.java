package cn.wangyanfsd.api.service.impl;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.cdzg.pagination.QueryResult;

import cn.wangyanfsd.api.service.BaseService;

public class AbstractBaseServiceImpl<T> implements BaseService<T>{

	public void save(T t) {
		// TODO Auto-generated method stub
		
	}

	public void remove(Serializable id) {
		// TODO Auto-generated method stub
		
	}

	public void update(T t) {
		// TODO Auto-generated method stub
		
	}

	public T find(Serializable id) {
		// TODO Auto-generated method stub
		return null;
	}

	public T find(String where, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public T find(String where, LinkedHashMap<String, String> orderBy, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> list() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> list(String where, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize, String where, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize, LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize, LinkedHashMap<String, String> orderBy, String where,
			Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize, String where, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize, LinkedHashMap<String, String> orderBy) {
		// TODO Auto-generated method stub
		return null;
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize, LinkedHashMap<String, String> orderBy,
			String where, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCount() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getCount(String where, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

}
