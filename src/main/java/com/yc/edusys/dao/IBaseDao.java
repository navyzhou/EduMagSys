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
	
	public List<T> findAll(Class<?> c,Map<String,Object> map,String sqlId);
	
	public List<T> findAll(Class<?> c,String sqlId,Object obj);
	
	public T find(Class<?> c,Map<String,Object> map,String sqlId);
	
	public T find(Class<?> c,String sqlId,Object obj);
	
	public T find(Class<?> c,String sqlId);
	
	public Integer add(Class<?> c,Map<String,Object> map,String sqlId);
	
	public Integer add(Class<?> c,Object obj,String sqlId);
	
	public Integer delete(Class<?> c,Map<String,Object> map,String sqlId);
	
	public Integer delete(Class<?> c,Object obj,String sqlId);
	
	public Integer update(Class<?> c,Map<String,Object> map,String sqlId);
	
	public Integer update(Class<?> c,Object obj,String sqlId);
	
	public Double findFunc(Class<?> c,String sqlId);
	
	public Double findFunc(Class<?> c,Map<String,Object> map,String sqlId);
	
	public Double findFunc(Class<?> c,Object obj,String sqlId);
}
