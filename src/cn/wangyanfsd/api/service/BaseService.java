package cn.wangyanfsd.api.service;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import com.cdzg.pagination.QueryResult;

public interface BaseService<T> {

	public void save(T t);
	public void remove(Serializable id);
	public void update(T t);
	
	public T find(Serializable id);
	public T find(String where,Object... params);
	
	public List<T> list();
	public List<T> list(String where,Object... params);
	
	public List<T> queryList(Integer pageIndex,Integer pageSize);
	public List<T> queryList(Integer pageIndex,Integer pageSize,String where,Object...params);
	public List<T> queryList(Integer pageIndex,Integer pageSize,LinkedHashMap<String, String> orderBy);
	public List<T> queryList(Integer pageIndex,Integer pageSize,LinkedHashMap<String, String> orderBy,String where,Object...params);
	
	public QueryResult<T> queryResult(Integer pageIndex,Integer pageSize);
	public QueryResult<T> queryResult(Integer pageIndex,Integer pageSize,String where,Object...params);
	public QueryResult<T> queryResult(Integer pageIndex,Integer pageSize,LinkedHashMap<String, String> orderBy);
	public QueryResult<T> queryResult(Integer pageIndex,Integer pageSize,LinkedHashMap<String, String> orderBy,String where,Object...params);
	
	public Integer getCount();
	public Integer getCount(String where,Object...params);
}
