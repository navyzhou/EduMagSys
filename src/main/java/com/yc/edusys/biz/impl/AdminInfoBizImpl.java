package com.yc.edusys.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.AdminInfo;
import com.yc.edusys.bean.JsonObject;
import com.yc.edusys.biz.IAdminInfoBiz;
import com.yc.edusys.dao.IBaseDao;
import com.yc.edusys.util.MD5Encryption;
import com.yc.edusys.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class AdminInfoBizImpl implements IAdminInfoBiz{
	@Autowired
	@Qualifier("baseDaoImpl")
	private IBaseDao baseDao;

	@Override
	public List<AdminInfo> findAll() {
		return baseDao.findAll(AdminInfo.class,"findAllAdminInfo");
	}

	@Override
	public AdminInfo adminLogin(AdminInfo admin) {
		if (StringUtil.isNull(admin.getAname(), admin.getPwd())) {
			return null;
		}
		admin.setPwd(MD5Encryption.createPassword(admin.getPwd()));
		return (AdminInfo) baseDao.find(AdminInfo.class, "adminLogin", admin);
	}

	@Override
	public int add(AdminInfo admin) {
		if (StringUtil.isNull(admin.getAname(), admin.getPwd())) {
			return -1;
		}
		admin.setPwd(MD5Encryption.createPassword(admin.getPwd()));
		return baseDao.update(AdminInfo.class, "addAdmin", admin);
		
	}

	@Override
	public int update(AdminInfo admin) {
		if (StringUtil.isNull(admin.getAname(), admin.getPwd())) {
			return -1;
		}
		admin.setPwd(MD5Encryption.createPassword(admin.getPwd()));
		return baseDao.update(AdminInfo.class, "updateAdmin", admin);
	}

	@Override
	public int updatePwd(int aid, String oldPwd, String newPwd) {
		if (StringUtil.isNull(oldPwd, newPwd)) {
			return -1;
		} 
		oldPwd = MD5Encryption.createPassword(oldPwd); // 使用MD5加密密码
		newPwd = MD5Encryption.createPassword(newPwd); // 使用MD5加密密码
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("oldPwd", oldPwd);
		map.put("newPwd", newPwd);
		map.put("aid", aid);
		
		return baseDao.update(AdminInfo.class, "updatePwd", map);
		
	}

	@Override
	public int updatePhoto(int aid, String photo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aid", aid);
		map.put("photo", photo);
		return baseDao.update(AdminInfo.class, "updatePhoto", map);
	}

	@Override
	public JsonObject findByPage(Map<String, Integer> map) {
		return (JsonObject) baseDao.find(AdminInfo.class,"findByPage", map);
	}

	@Override
	public Map<String, Object> findByCondition(int page, int rows, String rid, String status, String aname) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("page", (page-1)*rows);
		map.put("rows", rows);
		map.put("rid", rid);
		map.put("status", status);
		map.put("aname", aname);
		
		
		int total = baseDao.getTotal(AdminInfo.class, "getTotalByCondition", map);
		List<AdminInfo> admins = baseDao.findAll(AdminInfo.class, "findByCondition", map);
		map.clear();
		map.put("total", total);
		map.put("rows", admins);
		return map;
	}
}
