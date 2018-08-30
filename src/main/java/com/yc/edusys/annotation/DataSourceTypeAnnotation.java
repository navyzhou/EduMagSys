package com.yc.edusys.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yc.edusys.datasource.DataSourceType;

/**
 * 数据源类型注解
 * @author navy
 * @company 源辰信息
 */
@Retention(RetentionPolicy.RUNTIME) // 在运行时可见
@Target(ElementType.METHOD) // 注解可以用在方法上
public @interface DataSourceTypeAnnotation {
	DataSourceType value() default DataSourceType.edusys;
}
