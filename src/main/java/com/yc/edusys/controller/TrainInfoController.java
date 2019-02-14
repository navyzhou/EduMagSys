package com.yc.edusys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.edusys.biz.ITrainBiz;

@RestController
@RequestMapping("/back/trainInfo")
public class TrainInfoController extends BaseController{
	@Autowired
	@Qualifier("trainInfoBizImpl")
	private ITrainBiz trainInfoBiz;

	@RequestMapping("/findAll")
	public String findAll() {
		return this.toJson(trainInfoBiz.findAll());
	}
}