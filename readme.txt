1.环境需要jdk1.8或以上

SpringBoot项目的Bean装配默认规则是根据Application类所在的包位置从上往下扫描！
"Application类"是指SpringBoot项目入口类。这个类的位置很关键：
	如果Application类所在的包为：com.yc.springboot,则只会扫描com.yc.springboot包及其所有子包，如果service或dao所在包不在com.yc.springboot及其子包下，则不会被扫描！
	即, 把Application类放到dao、service所在包的上级com.yc.springboot知道这一点非常关键，不知道spring文档里有没有给出说明，如果不知道还真是无从解决。
	
	
spring boot因为内嵌tomcat容器，所以可以通过打包为jar包的方法将项目发布，但是如何将spring boot项目打包成可发布到tomcat中的war包项目呢？
第 1 步：将这个 Spring Boot 项目的打包方式设置为 war。
第 2 步：修改pom.xml， SpringBoot 默认有内嵌的 tomcat 模块，因此，我们要把这一部分排除掉。 
 	即：我们在 spring-boot-starter-web 里面排除了 spring-boot-starter-tomcat ，但是我们为了在本机测试方便，我们还要引入它，所以我们这样写：
<dependencies>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
      <!-- 打包部署到tomcat上面时，不需要打包tmocat相关的jar包，否则会引起jar包冲突 -->
      <exclusions>
        <exclusion>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-tomcat</artifactId>
        </exclusion>
    </exclusions>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
</dependencies>
第 3 步：提供一个 SpringBootServletInitializer 子类，并覆盖它的 configure 方法。我们可以把应用的主类改为继承 SpringBootServletInitializer。或者另外写一个类。
注意：部署到 tomcat 以后，访问这个项目的时候，须要带上这个项目的 war 包名。 
 另外，我们还可以使用 war 插件来定义打包以后的 war 包名称，以免 maven 为我们默认地起了一个带版本号的 war 包名称。例如：
 <plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-war-plugin</artifactId>
    <configuration>
        <warName>SpringBoot02</warName>
    </configuration>
</plugin>


添加websocket实现单点登录
1、添加依赖包
	<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-websocket</artifactId>
    </dependency>

 2、启用websocket的支持
 