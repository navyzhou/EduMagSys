package com.yc.edusys.biz;

import java.util.List;
import java.util.Map;

import com.yc.edusys.bean.ClassInfo;
import com.yc.edusys.bean.JsonObject;

public interface IClassInfoBiz{
	/**
	 * 添加班级信息
	 * @param cname
	 * @param tid
	 * @param cdate
	 * @param remark
	 * @return
	 */
	public int add(String cname, String tid, String cdate, String remark);
	
	/**
	 * 查询所有班级信息
	 * @return
	 */
	public List<ClassInfo> findAll();
	
	/**
	 * 根据状态查询班级信息
	 * @param status
	 * @return
	 */
	public List<ClassInfo> findByStatus(int status);
	
	/**
	 * 分页查询班级信息
	 * @param page
	 * @param row
	 * @return
	 */
	public JsonObject findByPage(Map<String, Integer> map);
	
	/**
	 * 多条件组合查询
	 * @param cname
	 * @param tid
	 * @param sdate
	 * @param edate
	 * @param status
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> findByCondition(String cname, String tid, String sdate, String edate, String status, int page, int row);

	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotal();
	
	/**
	 * 根据条件获取总记录数
	 * @param cname
	 * @param tid
	 * @param sdate
	 * @param edate
	 * @param status
	 * @return
	 */
	public int getTotal(String cname, String tid, String sdate, String edate, String status);
	
	/**
	 * 修改班级信息
	 * @param cname
	 * @param tid
	 * @param cdate
	 * @param semester
	 * @param edate
	 * @param status
	 * @param remark
	 * @param cid
	 * @return
	 */
	public int update(String cname, String tid, String cdate, String semester, String edate, String status, String remark, String cid);
}
