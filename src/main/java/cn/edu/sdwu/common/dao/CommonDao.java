package cn.edu.sdwu.common.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import org.hibernate.SessionFactory;

/**
 * CommonDao 通用Dao
 * @author jiangjh 2014年10月15日
 */
public interface CommonDao {

	public void setSupperSessionFactory(SessionFactory sessionFactory);
	
	/**
	 * 保存实体
	 * @param object
	 * @return
	 */
	public Serializable save(Object object);
	
	/**
	 * 更新实体
	 * @param object
	 */
	public void update(Object object);
	
	/**
	 * 删除实体
	 * @param object
	 */
	public void delete(Object object);
	
	/**
	 * 删除实体
	 * @param clazz
	 * @param id
	 */
	public void delete(Class<?> clazz, Serializable id);
	
	/**
	 * 获取实体
	 * @param clazz
	 * @param id
	 * @return
	 */
	public <T> T get(Class<T> clazz, Serializable id);
	
	/**
	 * 获取实体
	 * @param hql
	 * @param params
	 * @return
	 */
	public Object get(String hql, HashMap<String, Object> params);
	
	/**
	 * 查询实体列表
	 * @param hql
	 * @param params
	 * @return
	 */
	public List<?> list(String hql, HashMap<String, Object> params);
	
	/**
	 * 执行（删除、更新语句）
	 * @param hql
	 * @param params
	 */
	public int excuteUpdate(String hql, HashMap<String, Object> params);
	
	/**
	 * 获取实体 BySql
	 * @param sql
	 * @param params
	 * @return
	 */
	public Object getBySql(String sql, HashMap<String, Object> params, HashMap<String, Object> fieldTypes, Class<?> clazz);
	
	/**
	 * 查询实体列表 BySql
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<?> listBySql(String sql, HashMap<String, Object> params, HashMap<String, Object> fieldTypes, Class<?> clazz);
	
	/**
	 * 执行（删除、更新语句）BySql
	 * @param sql
	 * @param params
	 */
	public void excuteUpdateBySql(String sql, HashMap<String, Object> params);
	
}
