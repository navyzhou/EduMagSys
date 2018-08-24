package com.yc.edusys.bean;

import java.io.Serializable;

/**
 * 角色信息表
 * @author navy
 */
public class RoleInfo implements Serializable{
	private static final long serialVersionUID = -2315907763321311280L;
	private int rid;  // 角色编号
	private String rname;  //角色名称
	private String remark; // 角色备注
	
	@Override
	public String toString() {
		return "RoleInfo [rid=" + rid + ", rname=" + rname + ", remark="
				+ remark + "]";
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + rid;
		result = prime * result + ((rname == null) ? 0 : rname.hashCode());
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
		RoleInfo other = (RoleInfo) obj;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (rid != other.rid)
			return false;
		if (rname == null) {
			if (other.rname != null)
				return false;
		} else if (!rname.equals(other.rname))
			return false;
		return true;
	}

	public RoleInfo(int rid, String rname, String remark) {
		super();
		this.rid = rid;
		this.rname = rname;
		this.remark = remark;
	}

	public RoleInfo() {
		super();
	}
}
