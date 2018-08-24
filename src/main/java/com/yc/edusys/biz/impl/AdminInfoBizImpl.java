package com.yc.edusys.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.AdminInfo;
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
	public int add(String aname, String pwd, String rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String rid, String status, String aid, String pwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePwd(String aid, String oldPwd, String newPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePhoto(String photo, String aid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> findByPage(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findByCondition(int page, int rows, String rid, String status, String sname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotal(String rid, String status, String sname) {
		// TODO Auto-generated method stub
		return 0;
	}

}
