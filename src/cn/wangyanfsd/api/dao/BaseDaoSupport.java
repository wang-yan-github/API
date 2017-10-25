package cn.wangyanfsd.api.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

import org.hibernate.Query;

import com.cdzg.pagination.QueryResult;

@SuppressWarnings("unchecked")
public abstract class BaseDaoSupport<T> implements BaseDao<T> {
	
	//在程序运行期取得泛型实际类型
	private Class entityClass = (Class)(((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0]);

	public T find(Serializable id) {
		return (T)HibernateUtil.getSession().get(entityClass, id);
	}
	
//	public static void main(String[] args) {
//		BaseDaoSupport<String> bd = new BaseDaoSupport<String>();
//		LinkedHashMap<String, String> hm = new LinkedHashMap<String, String>();
//		hm.put("userName", "desc");
//		hm.put("age", "asc");
//		System.out.println(bd.buildOrderBy(hm));
//	}

	public T find(String where, Object... params) {
		String hql = "select o from " + entityClass.getSimpleName() + " o" + buildWhere(where);
		Query query = HibernateUtil.getSession().createQuery(hql);
		buildQuery(query,params);
		return (T)query.uniqueResult();
	}
	
	public T find(String where, LinkedHashMap<String, String> orderBy, Object... params) {
		String hql = "select o from " + entityClass.getSimpleName() + " o" + buildWhere(where) + buildOrderBy(orderBy);
		Query query = HibernateUtil.getSession().createQuery(hql);
		buildQuery(query,params);
		return (T)query.uniqueResult();
	}

	public Integer getCount() {
		return getCount(null);
	}

	public Integer getCount(String where, Object... params) {
		String hql = "select count(o) from " + entityClass.getSimpleName() + " o" + buildWhere(where);
		Query query = HibernateUtil.getSession().createQuery(hql);
		buildQuery(query, params);
		return Integer.parseInt(String.valueOf(query.uniqueResult()));
	}

	public List<T> list() {
		return list(null);
	}

	public List<T> list(String where, Object... params) {
		String hql = "select o from " + entityClass.getSimpleName() + " o" + buildWhere(where);
		Query query = HibernateUtil.getSession().createQuery(hql);
		buildQuery(query, params);
		return query.list();
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize) {
		return queryList(pageIndex, pageSize,null);
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize, String where,
			Object... params) {
		return queryList(pageIndex, pageSize,null,where,params);
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize,
			LinkedHashMap<String, String> orderBy) {
		return queryList(pageIndex, pageSize,orderBy,null);
	}

	public List<T> queryList(Integer pageIndex, Integer pageSize,
			LinkedHashMap<String, String> orderBy, String where,
			Object... params) {
		String hql = "select o from " + entityClass.getSimpleName() + " o" + buildWhere(where) + buildOrderBy(orderBy);
		Query query = HibernateUtil.getSession().createQuery(hql);
		buildQuery(query, params);
		buildScrollParam(query,pageIndex,pageSize);
		return query.list();
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize) {
		return queryResult(pageIndex,pageSize,null);
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize,
			String where, Object... params) {
		return queryResult(pageIndex,pageSize,null,where,params);
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize,
			LinkedHashMap<String, String> orderBy) {
		return queryResult(pageIndex,pageSize,orderBy,null);
	}

	public QueryResult<T> queryResult(Integer pageIndex, Integer pageSize,
			LinkedHashMap<String, String> orderBy, String where,
			Object... params) {
		QueryResult<T> queryResult = new QueryResult<T>();
		queryResult.setPageList(queryList(pageIndex,pageSize,orderBy,where,params));
		queryResult.setTotalElements(getCount(where,params));
		return queryResult;
	}

	public void remove(Serializable id) {
		HibernateUtil.getSession().delete(find(id));
	}

	public void save(T t) {//没有开启事务，没有提交事务，没有回滚事务，等待业务逻辑层来做这些事情。
		HibernateUtil.getSession().save(t);
	}

	public void update(T t) {
		HibernateUtil.getSession().update(t);
	}
	
	private String buildWhere(String where) {
		return (where == null || "".equals(where)) ? "" : " where " + where;
	}
	
	private void buildQuery(Query query,Object...params) {
		if (params != null) {
			for(int i = 0; i < params.length; i++){
				query.setParameter(i, params[i]);
			}
		}
	}
	
	private String buildOrderBy(LinkedHashMap<String, String> orderBy) {
		if (orderBy != null && orderBy.size() > 0) {
			StringBuilder builder = new StringBuilder();
			builder.append(" order by");
			for (Entry<String, String> kv : orderBy.entrySet()) {
				builder.append(" ").append("o.").append(kv.getKey()).append(" ").append(kv.getValue()).append(",");
			}
			System.out.println("builder ------------ " + builder.toString());
			builder.deleteCharAt(builder.length() - 1);
			return builder.toString();
		}
		return "";
	}
	
	private void buildScrollParam(Query query, Integer pageIndex, Integer pageSize) {
		if (pageIndex > 0 && pageSize > 0) {
			query.setFirstResult(pageSize * (pageIndex - 1));
			query.setMaxResults(pageSize);		
		}
	}
}
