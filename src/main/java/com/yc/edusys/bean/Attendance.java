package com.yc.edusys.bean;

import java.io.Serializable;

/**
 * 考勤记录信息
 * @author navy
 */
public class Attendance implements Serializable{
	private static final long serialVersionUID = -6738229407746819060L;
	private int atid; // 考勤编号
	private int aid; // 管理员编号
	private int cid; // 班级编号
	private String adate; // 考勤日期
	private int timeslot; // 考勤时间段 1.上午     2.下午  3.晚上
	private String content; // 考勤记录         学号-状态-备注;学号-状态-备注;学号-状态-备注
	private String remark; // 备注
	private String spare1; // 备用字段1
	private String spare2; // 备用字段2
	
	private String cname; // 班级名称
	private String aname; // 管理员姓名
	
	@Override
	public String toString() {
		return "Attendance [atid=" + atid + ", aid=" + aid + ", cid=" + cid
				+ ", adate=" + adate + ", timeslot=" + timeslot + ", content="
				+ content + ", remark=" + remark + ", spare1=" + spare1
				+ ", spare2=" + spare2 + ", cname=" + cname + ", aname="
				+ aname + "]";
	}

	public int getAtid() {
		return atid;
	}

	public void setAtid(int atid) {
		this.atid = atid;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getAdate() {
		return adate;
	}

	public void setAdate(String adate) {
		this.adate = adate;
	}

	public int getTimeslot() {
		return timeslot;
	}

	public void setTimeslot(int timeslot) {
		this.timeslot = timeslot;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public Attendance(int atid, int aid, int cid, String adate, int timeslot,
			String content, String remark, String spare1, String spare2) {
		super();
		this.atid = atid;
		this.aid = aid;
		this.cid = cid;
		this.adate = adate;
		this.timeslot = timeslot;
		this.content = content;
		this.remark = remark;
		this.spare1 = spare1;
		this.spare2 = spare2;
	}

	public Attendance() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adate == null) ? 0 : adate.hashCode());
		result = prime * result + aid;
		result = prime * result + atid;
		result = prime * result + cid;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((spare1 == null) ? 0 : spare1.hashCode());
		result = prime * result + ((spare2 == null) ? 0 : spare2.hashCode());
		result = prime * result + timeslot;
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
		Attendance other = (Attendance) obj;
		if (adate == null) {
			if (other.adate != null)
				return false;
		} else if (!adate.equals(other.adate))
			return false;
		if (aid != other.aid)
			return false;
		if (atid != other.atid)
			return false;
		if (cid != other.cid)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
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
		if (timeslot != other.timeslot)
			return false;
		return true;
	}
}
