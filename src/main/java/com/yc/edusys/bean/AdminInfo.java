package com.yc.edusys.bean;

import java.io.Serializable;

/**
 * 管理员信息表
 * @author navy
 */
public class AdminInfo implements Serializable {
	private static final long serialVersionUID = -3535662842140788940L;
	private int aid; // 管理员编号
	private String aname; // 管理员
	private String pwd; //  管理员密码
	private int rid; //  管理员角色
	private String photo; //  管理员图片
	private String remark; // 描述	
	private int status; // 管理员账号状态 
	
	private String rname; // 角色名称
	
	@Override
	public String toString() {
		return "AdminInfo [aid=" + aid + ", aname=" + aname + ", pwd="
				+ pwd + ", rid=" + rid + ", photo=" + photo + ", remark="
				+ remark + ", status=" + status + "]";
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public AdminInfo(int aid, String aname, String pwd, int rid,
			String photo, String remark, int status) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.pwd = pwd;
		this.rid = rid;
		this.photo = photo;
		this.remark = remark;
		this.status = status;
	}

	public AdminInfo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aid;
		result = prime * result + ((aname == null) ? 0 : aname.hashCode());
		result = prime * result
				+ ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + rid;
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AdminInfo other = (AdminInfo) obj;
		if (aid != other.aid)
			return false;
		if (aname == null) {
			if (other.aname != null)
				return false;
		} else if (!aname.equals(other.aname))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (rid != other.rid)
			return false;
		if (status != other.status)
			return false;
		return true;
	}
}
