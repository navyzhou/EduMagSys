package com.yc.edusys.biz.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.yc.edusys.bean.Train;
import com.yc.edusys.biz.ITrainBiz;
import com.yc.edusys.dao.IBaseDao;

@Service
@SuppressWarnings({"rawtypes","unchecked"})
public class TrainInfoBizImpl implements ITrainBiz{
	@Autowired
	@Qualifier("baseDaoImpl")
	private IBaseDao baseDao;

	@Override
	public int add(String tname) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String tname, String status, String tid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Train> findAll() {
		return baseDao.findAll(Train.class, "findAll");
	}

	@Override
	public int getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Object> findByPage(int page, int rows) {
		// TODO Auto-generated method stub
		return null;
	}

}
