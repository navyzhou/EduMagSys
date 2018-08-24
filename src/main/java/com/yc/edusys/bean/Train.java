package com.yc.edusys.bean;

import java.io.Serializable;

/**
 * 培训课程方向
 * @author navy
 */
public class Train implements Serializable {
	private static final long serialVersionUID = -6567877719625736730L;
	private int tid;
	private String tname;
	private int status;
	
	@Override
	public String toString() {
		return "Train [tid=" + tid + ", tname=" + tname + ", status=" + status
				+ "]";
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTname() {
		return tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Train(int tid, String tname, int status) {
		super();
		this.tid = tid;
		this.tname = tname;
		this.status = status;
	}

	public Train() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + status;
		result = prime * result + tid;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
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
		Train other = (Train) obj;
		if (status != other.status)
			return false;
		if (tid != other.tid)
			return false;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		return true;
	}
}
