package com.yc.edusys.datasource;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * springboot集成mybatis的基本入口 
 * 1、创建数据源(如果采用的是默认的tomcat-jdbc数据源，则不需要)
 * 2、创建SqlSessionFactory 
 * 3、配置事务管理器，除非需要使用事务，否则不用配置
 * 
 * 通过读取application.properties文件生成两个数据源（eduSysDataSource、userSysDataSource）
 * 使用以上生成的两个数据源构造动态数据源dataSource
 * @Primary：指定在同一个接口有多个实现类可以注入的时候，默认选择哪一个，而不是让@Autowire注解报错（一般用于多数据源的情况下）
 * @Qualifier：指定名称的注入，当一个接口有多个实现类的时候使用（在本例中，有两个DataSource类型的实例，需要指定名称注入）
 * @Bean：生成的bean实例的名称是方法名（例如上边的@Qualifier注解中使用的名称是前边两个数据源的方法名，而这两个数据源也是使用@Bean注解进行注入的
 * 通过动态数据源构造SqlSessionFactory和事务管理器（如果不需要事务，后者可以去掉）
 */
@Configuration // 该注解类似于spring配置文件
// 指定需要扫描的包（mapper.xml文件存放的包路径）
// @MapperScan(basePackages = "mapper")
public class MyBatisConfig {
    @Autowired
    private Environment env;

    /**
     * 创建数据源(数据源的名称：方法名可以取为XXXDataSource(),XXX为数据库名称,该名称也就是数据源的名称)
     * 
     * @Bean： 方法级别上的注解，相当于
     * <beans>
     * 		<bean id="方法名" class="此方法返回的对象"/>
     * </beans>
     */
    @Bean
    public DataSource eduSysDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc1.driverClassName"));
        props.put("url", env.getProperty("jdbc1.url"));
        props.put("username", env.getProperty("jdbc1.username"));
        props.put("password", env.getProperty("jdbc1.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

    @Bean
    public DataSource userSysDataSource() throws Exception {
        Properties props = new Properties();
        props.put("driverClassName", env.getProperty("jdbc2.driverClassName"));
        props.put("url", env.getProperty("jdbc2.url"));
        props.put("username", env.getProperty("jdbc2.username"));
        props.put("password", env.getProperty("jdbc2.password"));
        return DruidDataSourceFactory.createDataSource(props);
    }

  
    @Bean
    @Primary
    public DynamicDataSource dataSource(@Qualifier("eduSysDataSource") DataSource eduSysDataSource, @Qualifier("userSysDataSource") DataSource userSysDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<Object, Object>();
        targetDataSources.put(DataSourceType.edusys, eduSysDataSource);
        targetDataSources.put(DataSourceType.usersys, userSysDataSource);

        DynamicDataSource dataSource = new DynamicDataSource();
        dataSource.setTargetDataSources(targetDataSources); // 该方法是AbstractRoutingDataSource的方法
        dataSource.setDefaultTargetDataSource(eduSysDataSource);// 默认的datasource设置为eduSysDataSource
        return dataSource;
    }

    /**
     * 根据数据源创建SqlSessionFactory
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory(DynamicDataSource ds) throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean();
        sessionFactoryBean.setDataSource(ds); // 指定数据源(这个必须有，否则报错)
        
        // 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则可以不加
        sessionFactoryBean.setTypeAliasesPackage(env.getProperty("mybatis.type-aliases-package"));// 指定基包
        sessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(env.getProperty("mybatis.mapper-locations")));
        return sessionFactoryBean.getObject();
    }

    /**
     * 配置事务管理器
     */
    @Bean
    public DataSourceTransactionManager transactionManager(DynamicDataSource dataSource) throws Exception {
        return new DataSourceTransactionManager(dataSource);
    }
}