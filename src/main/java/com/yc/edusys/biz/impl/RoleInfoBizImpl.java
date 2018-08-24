package com.yc.edusys.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.RoleInfo;
import com.yc.edusys.biz.IRoleInfoBiz;
import com.yc.edusys.dao.IBaseDao;

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
	public int add(String rname, String remark) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String rname, String remark, String rid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<RoleInfo> findAll() {
		return baseDao.findAll(RoleInfo.class,"findAll");
	}

	@Override
	public Map<String, Object> findByPage(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}
}