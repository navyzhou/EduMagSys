package com.yc.edusys.controller;

import java.io.File;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

//@WebServlet(value="",initParams={@WebInitParam(name="uploadPath",value="photos"),@WebInitParam(name="filePath",value="files"),@WebInitParam(name="adminPhotoPath",value="adminHeads")},loadOnStartup=1)
@WebServlet(value="",loadOnStartup=1)
public class InitController extends HttpServlet{
	private static final long serialVersionUID = 2069037483125273141L;
	private String filePath ="files";
	private String photoPath = "photos";
	private String adminPhotoPath = "adminHeads";
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		String temp = config.getServletContext().getInitParameter("uploadPath");
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
		}
	}
}
