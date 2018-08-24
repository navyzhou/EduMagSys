package com.yc.edusys.bean;

import java.io.Serializable;

/**
 * 班级信息表
 * @author navy
 */
public class ClassInfo implements Serializable{
	private static final long serialVersionUID = -3007702131582932149L;
	private int cid; // 班级id
	private String cname; // 班级名称
	private int tid; // 班级方向
	private String cdate; // 开班日期
	private int semester; // 学期 1,2,3
	private String edate; // 结课日期
	private int status; // 班级状态，已结课
	private String remark; // 备注	
	
	private String tname; // 培训方向名称  Java 大数据  前段

	@Override
	public String toString() {
		return "ClassInfo [cid=" + cid + ", cname=" + cname + ", tid=" + tid
				+ ", cdate=" + cdate + ", semester=" + semester + ", edate="
				+ edate + ", status=" + status + ", remark=" + remark
				+ ", tname=" + tname + "]";
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getCdate() {
		return cdate;
	}

	public void setCdate(String cdate) {
		this.cdate = cdate;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cdate == null) ? 0 : cdate.hashCode());
		result = prime * result + cid;
		result = prime * result + ((cname == null) ? 0 : cname.hashCode());
		result = prime * result + ((edate == null) ? 0 : edate.hashCode());
		result = prime * result + ((remark == null) ? 0 : remark.hashCode());
		result = prime * result + semester;
		result = prime * result + status;
		result = prime * result + tid;
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
		ClassInfo other = (ClassInfo) obj;
		if (cdate == null) {
			if (other.cdate != null)
				return false;
		} else if (!cdate.equals(other.cdate))
			return false;
		if (cid != other.cid)
			return false;
		if (cname == null) {
			if (other.cname != null)
				return false;
		} else if (!cname.equals(other.cname))
			return false;
		if (edate == null) {
			if (other.edate != null)
				return false;
		} else if (!edate.equals(other.edate))
			return false;
		if (remark == null) {
			if (other.remark != null)
				return false;
		} else if (!remark.equals(other.remark))
			return false;
		if (semester != other.semester)
			return false;
		if (status != other.status)
			return false;
		if (tid != other.tid)
			return false;
		return true;
	}

	public ClassInfo(int cid, String cname, int tid, String cdate,
			int semester, String edate, int status, String remark) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.tid = tid;
		this.cdate = cdate;
		this.semester = semester;
		this.edate = edate;
		this.status = status;
		this.remark = remark;
	}

	public ClassInfo() {
		super();
	}
}
