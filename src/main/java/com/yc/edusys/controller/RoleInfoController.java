package com.yc.edusys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.edusys.biz.IRoleInfoBiz;

@RestController
public class RoleInfoController extends BaseController{
	@Autowired
	@Qualifier("roleInfoBizImpl")
	private IRoleInfoBiz roleInfoBiz;
	
	@RequestMapping("/back/findAllRoleInfo")
	public String findAll() {
		return this.toJson(roleInfoBiz.findAll());
	}
	
	@RequestMapping("/back/findRoleInfoByPage")
	public String findRoleInfoByPage(int page, int rows) {
		return this.toJson( roleInfoBiz.findByPage(this.toPageInfo(page, rows)) );
	}
}
