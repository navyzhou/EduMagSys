package com.yc.edusys.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.yc.edusys.annotation.DataSourceTypeAnnotation;
import com.yc.edusys.datasource.DataSourceType;
import com.yc.edusys.datasource.DynamicDataSource;
 
/**
 * 切换数据源的切面
 * @author navy
 * @company 源辰信息
 */
@Component
@Aspect
@Order(-10)  // 让它在事务注解前面起作用
public class DataSourceAspect {
	/**
	 * 第一个*表示返回值类型
	 * 包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.yc.edusys.dao包、子孙包下所有类的方法
	 * 第二个*号：表示类名，*号表示所有的类
	 * *(..) : 最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数
	 */
	//@Pointcut("execution(* com.yc.edusys.dao..*.*(..)) && @annotation(com.yc.edusys.annotation.DataSourceTypeAnnotation)")
	//@Pointcut("execution(* com.yc.edusys.biz.impl.*.*(..)) && @annotation(com.yc.edusys.annotation.DataSourceTypeAnnotation)")
	@Pointcut("execution(* com.yc.edusys.biz.impl.*.*(..))")
    public void dataSourcePointcut() {
    }
 
    @Before("dataSourcePointcut()")
    public void doBefore(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        
        DataSourceTypeAnnotation typeAnnotation = method.getAnnotation(DataSourceTypeAnnotation.class);
        if (typeAnnotation == null) { // 如果没有这个注解，则默认访问edusys数据库
        	DynamicDataSource.setDatabaseType(DataSourceType.edusys);
        	return;
        }
        
        DataSourceType sourceType = typeAnnotation.value();
        if (sourceType == DataSourceType.usersys) {
        	DynamicDataSource.setDatabaseType(DataSourceType.usersys);
        }else {
        	DynamicDataSource.setDatabaseType(DataSourceType.edusys);
        }
    }
}
