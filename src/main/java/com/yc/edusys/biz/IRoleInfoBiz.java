package com.yc.edusys.biz;

import java.util.List;
import java.util.Map;

import com.yc.edusys.bean.JsonObject;
import com.yc.edusys.bean.RoleInfo;

/**
 * 用户角色业务模型层接口定义
 * @author navy
 */
public interface IRoleInfoBiz {
	/**
	 * 添加角色信息 
	 * @param rname 角色名称
	 * @param remark 角色备注
	 * @return 成功返回大于0的数
	 */
	public int add(String rname, String remark) ;

	/**
	 * 修改角色信息
	 * @param rname 角色名称
	 * @param remark 角色备注
	 * @param rid 要修改的角色编号
	 * @return 成功返回大于0的数
	 */
	public int update(String rname, String remark, String rid);

	/**
	 * 查询所有角色信息
	 * @return
	 */
	public List<RoleInfo> findAll();
	
	/**
	 * 分页查询角色信息
	 * @param page 查第几页
	 * @param rows 每页多少条
	 * @return 满足条件的角色信息
	 */
	public JsonObject findByPage(Map<String,Integer> map);
	
	public List<RoleInfo> findByPageInfo(Map<String,Integer> map);
	
	/**
	 * 获取角色信息的总记录数
	 * @return 角色信息总记录条数
	 */
	public int getTotal();
}
