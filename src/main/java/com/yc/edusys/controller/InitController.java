package com.yc.edusys.controller;

import java.io.File;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Component //被spring容器管理
//@PropertySource("classpath:application.properties")
//@ConfigurationProperties(prefix = "uploadload")
//@Order(1) //如果多个自定义ApplicationRunner，用来标明执行顺序
public class InitController implements ApplicationRunner{
	private String filePath ="files";
	private String photoPath = "photos";
	private String adminPhotoPath = "adminHeads";

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("==================");
		System.out.println(args.getNonOptionArgs());
		/*String temp = config.getServletContext().getInitParameter("uploadPath");
		if (temp != null) { // 说明用户指定了上传路径
			photoPath= temp;
		}
		
		// 判断此路径是否存在
		String path = config.getServletContext().getRealPath("/");
		File fl = new File(path,"../"+photoPath);
		if (!fl.exists()) {
			fl.mkdirs();
		}
		
		temp = config.getServletContext().getInitParameter("filePath");
		if (temp != null) { // 说明用户指定了上传路径
			filePath= temp;
		}
		
		// 判断此路径是否存在
		path = config.getServletContext().getRealPath("/");
		fl = new File(path,"../"+filePath);
		if (!fl.exists()) {
			fl.mkdirs();
		}
		
		temp = config.getServletContext().getInitParameter("adminPhotoPath");
		if (temp != null) { // 说明用户指定了上传路径
			adminPhotoPath= temp;
		}
		
		// 判断此路径是否存在
		path = config.getServletContext().getRealPath("/");
		fl = new File(path,"../"+adminPhotoPath);
		if (!fl.exists()) {
			fl.mkdirs();
		}*/
	}
}
