package com.yc.edusys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.edusys.biz.IAdminInfoBiz;

@RestController
@RequestMapping("/back")
public class AdminInfoController extends BaseController {
	@Autowired
	@Qualifier("adminInfoBizImpl")
	private IAdminInfoBiz adminInfoBiz;
	
}
