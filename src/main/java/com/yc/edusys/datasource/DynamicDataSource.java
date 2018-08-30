package com.yc.edusys.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 使用DatabaseContextHolder获取当前线程的DatabaseType
 * 动态数据源,需要继承AbstractRoutingDataSource
 * @author navy
 * @company 源辰信息
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();

	public static void setDatabaseType(DataSourceType type){
		contextHolder.set(type);
	}

	protected Object determineCurrentLookupKey() {  // determine: 决定、限定  CurrentLookupKey : 当前查找关键字
		return contextHolder.get();
	}
	
	public static void resetDataSourceType(){
		contextHolder.set(DataSourceType.edusys);
	}
}
