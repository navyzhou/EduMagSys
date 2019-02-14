package com.yc.edusys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.edusys.biz.IClassInfoBiz;

@RestController
@RequestMapping("/back/classInfo")
public class ClassInfoController extends BaseController{
	@Autowired
	@Qualifier("classInfoBizImpl")
	private IClassInfoBiz classInfoBiz;

	@RequestMapping("/findByPage")
	public String findByPage(int page, int rows) {
		return this.toJson(classInfoBiz.findByPage(this.toPageInfo(page, rows)));
	}
}

