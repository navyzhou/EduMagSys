package com.yc.edusys.bean;

import java.io.Serializable;

/**
 * 学生信息
 * @author navy
 */
public class StuInfo implements Serializable{
	private static final long serialVersionUID = 6339394529710844771L;
	private int sid; // 学号
	private String sname; // 姓名
	private int cid; // 所在班级
	private String pwd; // 密码
	private String tel; // 联系方式
	private String cardId; // 身份证号码
	private String addr; // 家庭住址
	private String parentName; // 父母姓名
	private String parentTel; // 父母的联系方式
	private String photo; // 照片
	private String cardPositive; // 身份证正面照
	private String cardNegative; // 身份证背面照
	private String remark; // 描述
	private String spare1; // 备用字段1
	private String spare2 ; // 备用字段2
	private int status; // 状态
	
	private String cname; // 所在班级名称

	@Override
	public String toString() {
		return "StuInfo [sid=" + sid + ", sname=" + sname + ", cid=" + cid
				+ ", pwd=" + pwd + ", tel=" + tel + ", cardId=" + cardId
				+ ", addr=" + addr + ", parentName=" + parentName
				+ ", parentTel=" + parentTel + ", photo=" + photo
				+ ", cardPositive=" + cardPositive + ", cardNegative="
				+ cardNegative + ", remark=" + remark + ", spare1=" + spare1
				+ ", spare2=" + spare2 + ", status=" + status + ", cname="
				+ cname + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentTel() {
		return parentTel;
	}

	public void setParentTel(String parentTel) {
		this.parentTel = parentTel;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCardPositive() {
		return cardPositive;
	}

	public void setCardPositive(String cardPositive) {
		this.cardPositive = cardPositive;
	}

	public String getCardNegative() {
		return cardNegative;
	}

	public void setCardNegative(String cardNegative) {
		this.cardNegative = cardNegative;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSpare1() {
		return spare1;
	}

	public void setSpare1(String spare1) {
		this.spare1 = spare1;
	}

	public String getSpare2() {
		return spare2;
	}

	public void setSpare2(String spare2) {
		this.spare2 = spare2;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public StuInfo(int sid, String sname, int cid, String pwd, String tel,
			String cardId, String addr, String parentName, String parentTel,
			String photo, String cardPositive, String cardNegative,
			String remark, String spare1, String spare2, int status) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.cid = cid;
		this.pwd = pwd;
		this.tel = tel;
		this.cardId = cardId;
		this.addr = addr;
		this.parentName = parentName;
		this.parentTel = parentTel;
		this.photo = photo;
		this.cardPositive = cardPositive;
		this.cardNegative = cardNegative;
		this.remark = remark;
		this.spare1 = spare1;
		this.spare2 = spare2;
		this.status = status;
	}

	public StuInfo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addr == null) ? 0 : addr.hashCode());
		result = prime * result + ((cardId == null) ? 0 : cardId.hashCode());
		result = prime * result
				+ ((cardNegative == null) ? 0 : cardNegative.hashCode());
		result = prime * result
				+ ((cardPositive == null) ? 0 : cardPositive.hashCode());
		result = prime * result + cid;
		result = prime * result
				+ ((parentName == null) ? 0 : parentName.hashCode());
		result = prime * result
				+ ((parentTel == null) ? 0 : parentTel.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + sid;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + ((spare1 == null) ? 0 : spare1.hashCode());
		result = prime * result + ((spare2 == null) ? 0 : spare2.hashCode());
		result = prime * result + status;
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
		StuInfo other = (StuInfo) obj;
		if (addr == null) {
			if (other.addr != null)
				return false;
		} else if (!addr.equals(other.addr))
			return false;
		if (cardId == null) {
			if (other.cardId != null)
				return false;
		} else if (!cardId.equals(other.cardId))
			return false;
		if (cardNegative == null) {
			if (other.cardNegative != null)
				return false;
		} else if (!cardNegative.equals(other.cardNegative))
			return false;
		if (cardPositive == null) {
			if (other.cardPositive != null)
				return false;
		} else if (!cardPositive.equals(other.cardPositive))
			return false;
		if (cid != other.cid)
			return false;
		if (parentName == null) {
			if (other.parentName != null)
				return false;
		} else if (!parentName.equals(other.parentName))
			return false;
		if (parentTel == null) {
			if (other.parentTel != null)
				return false;
		} else if (!parentTel.equals(other.parentTel))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sid != other.sid)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (spare1 == null) {
			if (other.spare1 != null)
				return false;
		} else if (!spare1.equals(other.spare1))
			return false;
		if (spare2 == null) {
			if (other.spare2 != null)
				return false;
		} else if (!spare2.equals(other.spare2))
			return false;
		if (status != other.status)
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
}
