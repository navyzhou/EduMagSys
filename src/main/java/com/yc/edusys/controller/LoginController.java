package com.yc.edusys.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.edusys.bean.AdminInfo;
import com.yc.edusys.bean.ClassInfo;
import com.yc.edusys.bean.RoleInfo;
import com.yc.edusys.bean.StuInfo;
import com.yc.edusys.biz.IAdminInfoBiz;
import com.yc.edusys.biz.IClassInfoBiz;
import com.yc.edusys.biz.IRoleInfoBiz;
import com.yc.edusys.biz.IStuInfoBiz;
import com.yc.edusys.util.RedisUtils;
import com.yc.edusys.util.SessionAttributeKey;
import com.yc.edusys.websocket.WebSocketServer;

@RestController
public class LoginController extends BaseController {
	@Autowired
	@Qualifier("adminInfoBizImpl")
	private IAdminInfoBiz adminInfoBiz;
	
	@Autowired
	@Qualifier("classInfoBizImpl")
	private IClassInfoBiz classInfoBiz;
	
	@Autowired
	@Qualifier("roleInfoBizImpl")
	private IRoleInfoBiz roleInfoBiz;
	
	@Autowired
	@Qualifier("stuInfoBizImpl")
	private IStuInfoBiz stuInfoBiz;
	
	@Autowired
	private RedisUtils redisUtils;
	
	/**
	 * 获取登录页面的角色信息和班级信息
	 * @return
	 */
	@RequestMapping("/getLoginInfo")
	public String getInfo() {
		List<RoleInfo> rfs = roleInfoBiz.findAll();
		List<ClassInfo> cfs = classInfoBiz.findByStatus(1);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("rf", rfs);
		map.put("cf", cfs);
		
		return this.toJson(map);
	}
	
	@RequestMapping("/userLogin")
	public int userLogin(HttpSession session, AdminInfo admin) {
		int result = 0;
		if ("学员".equals(admin.getRname())) { // 学生登录
			StuInfo stuInfo = stuInfoBiz.stuLogin(admin);
			if (stuInfo != null) {
				result = 1;
				session.setAttribute(SessionAttributeKey.CURRENTLOGINUSER, stuInfo);
			}
		} else { // 管理员登录
			AdminInfo adminInfo = adminInfoBiz.adminLogin(admin);
			if (adminInfo != null) {
				WebSocketServer wss = WebSocketServer.getWebSocket(String.valueOf(adminInfo.getAid()));
				if (wss != null) {  // 如果已经登录，则发送挤退信息
					try {
						wss.sendMessage("101");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				result = 1;
				session.setAttribute(SessionAttributeKey.CURRENTLOGINUSER, adminInfo);
			}
		}
		return result;
	}
	
	@RequestMapping("/back/getLoginAdminId")
	public int getLoginAdminId(HttpSession session) {
		Object obj = session.getAttribute(SessionAttributeKey.CURRENTLOGINUSER);
		if (obj == null) {
			return -1;
		} 
		return ((AdminInfo)obj).getAid();
	}
}
