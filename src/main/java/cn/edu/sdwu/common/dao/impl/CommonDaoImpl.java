package cn.edu.sdwu.common.dao.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import cn.edu.sdwu.common.dao.CommonDao;


/**
 * CommonDaoImpl 通用Dao实现类
 */
@Repository
public class CommonDaoImpl implements CommonDao  {

	private SessionFactory sessionFactory;
	
	@Resource(name="sessionFactory")
	public void setSupperSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	protected Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public Serializable save(Object object) {
		//强制转换String是个坑，返回的值是主键的Serializable对象，有些主键类型不能够强制转换为String
//		return (String)getSession().save(object);
		return getSession().save(object);
		
	}

	public void update(Object object) {
		getSession().update(object);

	}

	public void delete(Object object) {
		getSession().delete(object);

	}

	public void delete(Class<?> clazz, Serializable id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);

	}

	@SuppressWarnings("unchecked")
	public <T> T get(Class<T> clazz, Serializable id) {
		return (T) getSession().get(clazz, id);
	}

	public Object get(String hql, HashMap<String, Object> params) {
		Query q = createQuery(hql, params);
		List<?> l = q.list();
		if (l != null && l.size() == 1) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public List<?> list(String hql, HashMap<String, Object> params) {
		Query q = createQuery(hql, params);
		List<?> l = q.list();
		return l;
	}
	
	public int excuteUpdate(String hql, HashMap<String, Object> params) {
		Query q = createQuery(hql, params);
		return q.executeUpdate();
	}

	public Object getBySql(String sql, HashMap<String, Object> params, HashMap<String, Object> fieldTypes, Class<?> clazz) {
		SQLQuery q = createSQLQuery(sql, params);
		if(fieldTypes != null){
	        for (String key : fieldTypes.keySet()) {
	            org.hibernate.type.Type value = (org.hibernate.type.Type)fieldTypes.get(key);
	            q.addScalar(key, value);
	        }
		}
		List<?> l = null;
	    if (clazz == null) {
	    	l = q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	    } else {
	    	l = q.setResultTransformer(Transformers.aliasToBean(clazz)).list();
	    }
		if (l != null && l.size() == 1) {
			return l.get(0);
		} else {
			return null;
		}
	}

	public List<?> listBySql(String sql, HashMap<String, Object> params, HashMap<String, Object> fieldTypes, Class<?> clazz) {
		SQLQuery q = createSQLQuery(sql, params);
        if(fieldTypes != null){
            for (String key : fieldTypes.keySet()) {
            	org.hibernate.type.Type value = (org.hibernate.type.Type)fieldTypes.get(key);
                q.addScalar(key, value);
            }
        }
        List<?> l = null;
        if (clazz == null) {
        	l = q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
        } else {
        	l = q.setResultTransformer(Transformers.aliasToBean(clazz)).list();
        }
		return l;
	}

	public void excuteUpdateBySql(String sql, HashMap<String, Object> params) {
		SQLQuery q = createSQLQuery(sql, params);
		q.executeUpdate();
	}

	/**
	 * 创建Query
	 * @param hql
	 * @param params
	 * @return
	 */
	private Query createQuery(final String hql, final HashMap<String, Object> params){
		Query q = getSession().createQuery(hql);
		String[] keys = q.getNamedParameters();
		if(null != keys && null != params){
			for(String key : keys){
				if(!params.containsKey(key)){
					throw new RuntimeException("没有设置参数"+key+"的值");
				}
				Object v = params.get(key);
				if(v instanceof Collection<?>){
					q.setParameterList(key, (Collection<?>)v);
				}else if(v instanceof Object[]){
					q.setParameterList(key, (Object[])v);
				}else{
					q.setParameter(key, v);
				}
			}
		}
		return q;
	}
	
	/**
	 * 创建SQLQuery
	 * @param sql
	 * @param params
	 * @return
	 */
	private SQLQuery createSQLQuery(final String sql, final HashMap<String, Object> params){
		SQLQuery q = getSession().createSQLQuery(sql);
		String[] keys = q.getNamedParameters();
		if(null != keys && null != params){
			for(String key : keys){
				if(!params.containsKey(key)){
					throw new RuntimeException("没有设置参数"+key+"的值");
				}
				Object v = params.get(key);
				q.setParameter(key, v);
			}
		}
		return q;
	}

}
