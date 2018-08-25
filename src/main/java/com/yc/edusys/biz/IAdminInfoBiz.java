package com.yc.edusys.biz;

import java.util.List;
import java.util.Map;

import com.yc.edusys.bean.AdminInfo;
import com.yc.edusys.bean.JsonObject;

/**
 * 管理员信息业务模型层接口定义
 * @author navy
 */
public interface IAdminInfoBiz {
	/**
	 * 管理员登录
	 * @return 符合条件的管理员对象
	 */
	public AdminInfo adminLogin(AdminInfo admin);
	
	/**
	 * 添加管理员信息 
	 * @return 成功返回大于0的数
	 */
	public int add(AdminInfo admin);

	/**
	 * 修改管理员角色和状态信息
	 * @return 成功返回大于0的数
	 */
	public int update(AdminInfo admin);
	
	/**
	 * 修改管理员密码
	 * @param aid 要修改的管理员编号
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 * @return 成功返回大于0的数
	 */
	public int updatePwd(int aid, String oldPwd, String newPwd);
	
	/**
	 * 修改管理员图像
	 * @param aid 要修改的管理员编号
	 * @param photo 新图像路径
	 * @return 成功返回大于0的数
	 */
	public int updatePhoto(int aid, String photo);

	/**
	 * 查询所有管理员信息
	 * @return
	 */
	public List<AdminInfo> findAll();
	
	/**
	 * 分页查询管理员信息
	 * @return 满足条件的管理员信息
	 */
	public JsonObject findByPage(Map<String, Integer> map);
	
	/**
	 * 多条件分页组合查询
	 * @param page 查第几页
	 * @param rows 每页多少条
	 * @param rid 管理员角色
	 * @param status 管理员状态
	 * @return 满足条件的管理员信息
	 */
	public Map<String, Object> findByCondition(int page, int rows, String rid, String status, String aname);
}
