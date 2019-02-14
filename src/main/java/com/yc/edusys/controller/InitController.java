package com.yc.edusys.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

@Component //被spring容器管理
@PropertySource("classpath:config.yml")
@ConfigurationProperties(prefix = "uploadload")
@Order(1) //如果多个自定义ApplicationRunner，用来标明执行顺序
public class InitController implements ApplicationRunner{
	@Value("${filesPath}")
	private String filesPath;

	@Value("${photoPath}")
	private String photoPath;

	@Value("${adminPhotoPath}")
	private String adminPhotoPath;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 判断此路径是否存在
		String path = ClassUtils.getDefaultClassLoader().getResource("").getPath().substring(1).replace("WEB-INF/classes/", "");
		
		File fl = new File(path,"../"+photoPath);
		if (!fl.exists()) {
			fl.mkdirs();
		}

		// 判断此路径是否存在
		fl = new File(path,"../"+filesPath);
		if (!fl.exists()) {
			fl.mkdirs();
		}

		// 判断此路径是否存在
		fl = new File(path,"../"+adminPhotoPath);
		if (!fl.exists()) {
			fl.mkdirs();
		}
	}
}
