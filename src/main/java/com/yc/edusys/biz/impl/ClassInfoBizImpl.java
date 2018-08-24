package com.yc.edusys.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.ClassInfo;
import com.yc.edusys.biz.IClassInfoBiz;
import com.yc.edusys.dao.IBaseDao;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class ClassInfoBizImpl implements IClassInfoBiz{
	@Autowired
	@Qualifier("baseDaoImpl")
	private IBaseDao baseDao;
	
	@Override
	public int add(String cname, String tid, String cdate, String remark) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ClassInfo> findAll() {
		return null;
	}

	@Override
	public List<ClassInfo> findByStatus(int status) {
		return baseDao.findAll(ClassInfo.class,"findByStatus", status);
	}

	@Override
	public Map<String, Object> findByPage(int page, int row) {
		return null;
	}

	@Override
	public Map<String, Object> findByCondition(String cname, String tid, String sdate, String edate, String status,
			int page, int row) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotal(String cname, String tid, String sdate, String edate, String status) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String cname, String tid, String cdate, String semester, String edate, String status,
			String remark, String cid) {
		// TODO Auto-generated method stub
		return 0;
	}

}
