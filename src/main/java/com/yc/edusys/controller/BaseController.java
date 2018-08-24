package com.yc.edusys.controller;

import com.google.gson.Gson;

public class BaseController {
	public String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
}
