package com.yc.edusys.controller;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class BaseController {
	public String toJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	
	public Map<String, Integer> toPageInfo(int page, int rows) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("page", page);
		map.put("rows", rows);
		return map;
	}
}
