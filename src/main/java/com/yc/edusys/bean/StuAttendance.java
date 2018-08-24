package com.yc.edusys.bean;

import java.io.Serializable;

public class StuAttendance implements Serializable {
	private static final long serialVersionUID = -2458424156555725421L;
	private String sid; // 学号
	private int status; // 考勤状态
	private String sdate; // 考勤日期
	private int time; // 时间段
	private String remark; // 备注
	
	@Override
	public String toString() {
		return "StuAttendance [sid=" + sid + ", status=" + status + ", sdate="
				+ sdate + ", time=" + time + ", remark=" + remark + "]";
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public StuAttendance() {
		super();
	}
	public StuAttendance(String sid, int status, String sdate) {
		super();
		this.sid = sid;
		this.status = status;
		this.sdate = sdate;
	}

	public StuAttendance(String sid, int status, String sdate, int time, String remark) {
		super();
		this.sid = sid;
		this.status = status;
		this.sdate = sdate;
		this.time = time;
		this.remark = remark;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + ((sdate == null) ? 0 : sdate.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + status;
		result = prime * result + time;
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
		StuAttendance other = (StuAttendance) obj;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (sdate == null) {
			if (other.sdate != null)
				return false;
		} else if (!sdate.equals(other.sdate))
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (status != other.status)
			return false;
		if (time != other.time)
			return false;
		return true;
	}
}
