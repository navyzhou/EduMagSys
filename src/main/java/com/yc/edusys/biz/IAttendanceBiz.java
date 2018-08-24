package com.yc.edusys.biz;

import java.util.List;
import java.util.Map;

import com.yc.edusys.bean.Attendance;

public interface IAttendanceBiz {
	/**
	 * 添加考勤信息
	 * @param aid 管理员编号
	 * @param cid 班级编号
	 * @param adate 考勤日期
	 * @param timeslot 考勤时间段
	 * @param content 考勤记录
	 * @return
	 */
	public int add(int aid, String cid, String adate, String timeslot, String content);
	
	/**
	 * 根据班级编号查询考勤信息
	 * @param cid 班级编号
	 * @return
	 */
	public Map<String, Object> findByCid(String cid, int page, int rows);
	
	/**
	 * 分页查询
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> findByPage(int page, int row);
	
	/**
	 * 根据考勤编号查询考勤信息
	 * @param atid
	 * @return
	 */
	public Attendance findByAid(String atid);
	
	/**
	 * 根据班级编号、考勤日期和考勤时间段组合查询考勤信息
	 * @param cid 考勤班级
	 * @param adate 考勤日期
	 * @param time 考勤时间段
	 * @return
	 */
	public List<Attendance> findByCondition(String cid, String adate, String time);
	
	/**
	 * 根据考勤编号修改考勤信息
	 * @param adate 考勤日期
	 * @param timeslot 考勤时间段
	 * @param content 考勤内容
	 * @param atid 考勤编号
	 * @return
	 */
	public int update(String adate, String timeslot, String content, String atid);
	
	/**
	 * 获取总记录数
	 * @return
	 */
	public int getTotal();
	
	public int getTotal(String cid);
	
	/**
	 * 条件查询
	 * @param cid 班级
	 * @param sdate 开始时间
	 * @param edate 结束时间
	 * @param time 时间段
	 * @return
	 */
	public List<Attendance> findByCondition(String cid, String sdate, String edate, String time);
	
	public int getTotal(String cid, String sdate, String edate, String time);
}
