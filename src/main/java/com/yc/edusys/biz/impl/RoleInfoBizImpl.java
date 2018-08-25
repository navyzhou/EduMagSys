package com.yc.edusys.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.JsonObject;
import com.yc.edusys.bean.RoleInfo;
import com.yc.edusys.biz.IRoleInfoBiz;
import com.yc.edusys.dao.IBaseDao;
import com.yc.edusys.util.StringUtil;

/**
 * 角色信息业务模型层的实现
 * @author navy
 */
@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class RoleInfoBizImpl implements IRoleInfoBiz{
	@Autowired
	@Qualifier("baseDaoImpl")
	private IBaseDao baseDao;
	
	@Override
	public int add(RoleInfo rf) {
		if (rf == null || StringUtil.isNull(rf.getRname())) {
			return -1;
		}
		return baseDao.update(RoleInfo.class, "addRole", rf);
	}

	@Override
	public int update(RoleInfo rf) {
		if (rf == null || StringUtil.isNull(rf.getRname())) {
			return -1;
		}
		return baseDao.update(RoleInfo.class, "updateRole", rf);
	}

	@Override
	public List<RoleInfo> findAll() {
		return baseDao.findAll(RoleInfo.class,"findAll");
	}

	@Override
	public JsonObject findByPage(Map<String, Integer> map) {
		return (JsonObject) baseDao.find(RoleInfo.class,"findByPage", map);
	}
	
	@Override
	public List<RoleInfo> findByPageInfo(Map<String,Integer> map) {
		return baseDao.findAll(RoleInfo.class,"findByPageInfo", map);
	}
	
	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}
