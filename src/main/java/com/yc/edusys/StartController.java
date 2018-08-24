package com.yc.edusys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;
/*
 * @SpringBootApplication。 由于大量项目都会在主要的配置类上添加@Configuration,@EnableAutoConfiguration,@ComponentScan三个注解。
 * 因此Spring Boot提供了@SpringBootApplication注解，该注解可以替代上面三个注解（使用Spring注解继承实现）。
 * 
 * @RestController注解相当于@ResponseBody ＋ @Controller合在一起的作用。
 */
@RestController
@SpringBootApplication
public class StartController extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(StartController.class);
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(StartController.class, args);
	}
}
