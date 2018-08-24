package com.yc.edusys.biz;

import java.util.List;
import java.util.Map;

import com.yc.edusys.bean.AdminInfo;
import com.yc.edusys.bean.StuInfo;

public interface IStuInfoBiz {
	/**
	 * 添加学生信息
	 * @return
	 */
	public int add(StuInfo stu);

	/**
	 * 分页查询
	 * @param page
	 * @param rows
	 * @return
	 */
	public Map<String, Object> findByPage(int page, int rows);

	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotal();
	
	/**
	 * 查看个人详细信息
	 * @param sid
	 * @return
	 */
	public StuInfo findBySid(String sid);
	
	/**
	 * 学生登录
	 * @param sname 姓名
	 * @param pwd 密码
	 * @param cid 班级编号
	 * @return
	 */
	public StuInfo stuLogin(AdminInfo admin);
	
	/**
	 * 根据班级编号查询所有班级信息
	 * @param cid 班级编号
	 * @return
	 */
	public List<StuInfo> findByCid(String cid);
	
	/**
	 * 多条件组合查询
	 * @param sname
	 * @param tid
	 * @param cid
	 * @param status
	 * @param tel
	 * @return
	 */
	public Map<String, Object> findByCondition(int page, int rows, String sname, String tid, String cid, String status, String tel);
	
	public int addStuInfos(List<List<String>> list);
	
	public int update(StuInfo stu);
}
