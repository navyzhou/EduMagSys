package com.yc.edusys.dao;

import java.util.List;
import java.util.Map;

/**
 * 数据模型接口层
 * @author navy
 * @param <T>
 */
public interface IBaseDao<T> {
	public List<T> findAll(Class<?> c,String sqlId);
	
	public List<T> findAll(Class<?> c,String sqlId,Map<String,Object> map);
	
	public List<T> findAll(Class<?> c,String sqlId,Object obj);
	
	public T find(Class<?> c,String sqlId,Map<String,Object> map);
	
	public T find(Class<?> c,String sqlId,Object obj);
	
	public T find(Class<?> c,String sqlId);
	
	public Integer add(Class<?> c,String sqlId,Map<String,Object> map);
	
	public Integer add(Class<?> c,String sqlId,Object obj);
	
	public Integer delete(Class<?> c,String sqlId,Map<String,Object> map);
	
	public Integer delete(Class<?> c,String sqlId,Object obj);
	
	public Integer update(Class<?> c,String sqlId,Map<String,Object> map);
	
	public Integer update(Class<?> c,String sqlId,Object obj);
	
	public Double findFunc(Class<?> c,String sqlId);
	
	public Double findFunc(Class<?> c,String sqlId,Map<String,Object> map);
	
	public Double findFunc(Class<?> c,String sqlId,Object obj);
	
	public Integer getTotal(Class<?> c,String sqlId);
	
	public Integer getTotal(Class<?> c,String sqlId,Object obj);
	
	public Integer getTotal(Class<?> c,String sqlId,Map<String,Object> map);
}
