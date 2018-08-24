package com.yc.edusys.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.AdminInfo;
import com.yc.edusys.bean.StuInfo;
import com.yc.edusys.biz.IStuInfoBiz;
import com.yc.edusys.dao.IBaseDao;
import com.yc.edusys.util.MD5Encryption;
import com.yc.edusys.util.StringUtil;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class StuInfoBizImpl implements IStuInfoBiz{
	@Autowired
	@Qualifier("baseDaoImpl")
	private IBaseDao baseDao;
	
	@Override
	public int add(StuInfo stu) {
		return 0;
	}

	@Override
	public Map<String, Object> findByPage(int page, int rows) {
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StuInfo findBySid(String sid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StuInfo stuLogin(AdminInfo admin) {
		if (StringUtil.isNull(admin.getAname(), admin.getPwd())) {
			return null;
		}
		admin.setPwd(MD5Encryption.createPassword(admin.getPwd()));
		return (StuInfo) baseDao.find(StuInfo.class, "stuLogin", admin);
	}

	@Override
	public List<StuInfo> findByCid(String cid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> findByCondition(int page, int rows, String sname, String tid, String cid, String status,
			String tel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addStuInfos(List<List<String>> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(StuInfo stu) {
		// TODO Auto-generated method stub
		return 0;
	}

}
