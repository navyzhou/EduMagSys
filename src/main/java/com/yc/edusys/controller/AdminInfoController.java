package com.yc.edusys.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yc.edusys.bean.AdminInfo;
import com.yc.edusys.biz.IAdminInfoBiz;
import com.yc.edusys.util.LogUtil;
import com.yc.edusys.util.SessionAttributeKey;
import com.yc.edusys.util.StringUtil;

import sun.misc.BASE64Decoder;

@RestController
@RequestMapping("/back")
public class AdminInfoController extends BaseController {
	@Autowired
	@Qualifier("adminInfoBizImpl")
	private IAdminInfoBiz adminInfoBiz;

	@RequestMapping("/findAdminInfoByPage")
	public String findRoleInfoByPage(int page, int rows) {
		return this.toJson( adminInfoBiz.findByPage(this.toPageInfo(page, rows)) );
	}

	@RequestMapping("/addAdmin")
	public int addRole(AdminInfo af) {
		return adminInfoBiz.add(af);
	}

	@RequestMapping("/updateAdmin")
	public int updateRole(AdminInfo af) {
		return adminInfoBiz.update(af);
	}

	@RequestMapping("/findAdminByCondition")
	public String findAdminByCondition(int page, int rows, String rid, String status, String aname) {
		return this.toJson(adminInfoBiz.findByCondition(page, rows, rid, status, aname));
	}

	@RequestMapping("/updateAdminHead")
	public String updateAdminHead(HttpServletRequest request, HttpSession session, String imageData) {
		Object obj = session.getAttribute(SessionAttributeKey.CURRENTLOGINUSER);

		if (obj == null) { // 说明没有登录
			return "0";
		} 
		String result = "-1";
		BASE64Decoder base64=new BASE64Decoder(); 
		FileOutputStream fos = null;
		try {
			//64位解码  
			byte[] buffer=base64.decodeBuffer(imageData);

			//写进文件  
			String filePath="../"+request.getServletContext().getInitParameter("adminPhotoPath")+"/"+new Date().getTime() + "" + new Random().nextInt(100000) + ".png";
			String path=request.getServletContext().getRealPath("/") + filePath;

			fos =new FileOutputStream(path);  
			fos.write(buffer);  
			fos.flush(); 

			AdminInfo adminInfo = (AdminInfo) obj;
			if ( adminInfoBiz.updatePhoto(adminInfo.getAid(), filePath) > 0) {
				result = filePath;  // 修改成功

				// 获取原照片信息
				String photo = adminInfo.getPhoto();
				if (!StringUtil.isNull(photo)) {  // 如果存在，则删除原图片
					File file = new File(request.getServletContext().getRealPath("/") + photo);
					if (file.exists()){
						file.delete();
					}
				}
				adminInfo.setPhoto(filePath); // 修改session中的图片信息
			} else {
				result = "2";  // 修改失败
			}

		} catch (IOException e) { // 上传图片失败
			result = "1";
			LogUtil.log.error(e);
		}  finally {
			if (fos != null){
				try {
					fos.close();
				} catch (IOException e) {
				}  
			}
		}
		return result;
	}

	@RequestMapping("/updateAdminPwd")
	public int updateAdminPwd(HttpSession session, String oldpwd, String newpwd) {
		Object obj = session.getAttribute(SessionAttributeKey.CURRENTLOGINUSER);
		if (obj == null) { // 说明没有登录
			return 0;
		} 

		if (StringUtil.isNull(oldpwd, newpwd )) { // 信息不完整
			return 1;
		} 
		
		AdminInfo adminInfo = (AdminInfo) obj;
		if (adminInfoBiz.updatePwd(adminInfo.getAid(), oldpwd, newpwd) > 0){
			return 2;
		}
		return -1;
	}
	
	@RequestMapping("/admingSignOut")
	public int admingSignOut(HttpSession session) {
		session.removeAttribute(SessionAttributeKey.CURRENTLOGINUSER);
		session.invalidate();
		return 1;
	}
}
