package com.yc.edusys.biz;

import java.util.List;
import java.util.Map;
import com.yc.edusys.bean.Train;

/**
 * 课程方向业务模型层接口定义
 * @author navy
 */
public interface ITrainBiz {
	/**
	 * 添加课程方向信息 
	 * @param tname 课程方向名称
	 * @return 成功返回大于0的数
	 */
	public int add(String tname) ;

	/**
	 * 修改课程方向信息
	 * @param tname 课程方向名称
	 * @param status 课程方向状态
	 * @param tid 要修改的课程方向编号
	 * @return 成功返回大于0的数
	 */
	public int update(String tname, String status, String tid);

	/**
	 * 查询所有课程方向信息
	 * @return
	 */
	public List<Train> findAll();
	
	/**
	 * 获取课程方向信息的总记录数
	 * @return 课程方向信息总记录条数
	 */
	public int getTotal();
	
	/**
	 * 分页查询课程方向信息
	 * @param page 查第几页
	 * @param rows 每页多少条
	 * @return 满足条件的课程方向信息
	 */
	public Map<String, Object> findByPage(int page, int rows);
}
