package com.yc.edusys.bean;

import java.io.Serializable;

public class StatisticsInfo implements Serializable{
	private static final long serialVersionUID = 2628776444401447184L;
	private String sid;
	private String sname;
	
	private int normal;
	private int late;
	private int absenteeism;
	private int sleave;
	private int cleave;
	private int total;
	
	private int rate;
	
	@Override
	public String toString() {
		return "StatisticsInfo [sid=" + sid + ", sname=" + sname + ", normal="
				+ normal + ", late=" + late + ", absenteeism=" + absenteeism
				+ ", sleave=" + sleave + ", cleave=" + cleave + ", total="
				+ total + ", rate=" + rate + "]";
	}

	public void setStatus(String str) {
		if ("1".equals(str)) {
			normal++;
		} else if ("2".equals(str)) {
			late++;
		} else if ("3".equals(str)) {
			absenteeism++;
		} else if ("4".equals(str)) {
			sleave++;
		} else if ("5".equals(str)) {
			cleave++;
		} 
		total++;
		getRate();
	}

	public int getRate() {
		rate = (int)((normal+late)/(float)total*100);
		return rate;
	}
	
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getNormal() {
		return normal;
	}

	public int getLate() {
		return late;
	}

	public int getAbsenteeism() {
		return absenteeism;
	}

	public int getSleave() {
		return sleave;
	}

	public int getCleave() {
		return cleave;
	}

	public int getTotal() {
		return total;
	}

	public StatisticsInfo(String sid, String sname) {
		super();
		this.sid = sid;
		this.sname = sname;
	}
	
	public StatisticsInfo(String sid) {
		super();
		this.sid = sid;
	}

	public StatisticsInfo() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + absenteeism;
		result = prime * result + cleave;
		result = prime * result + late;
		result = prime * result + normal;
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + sleave;
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		result = prime * result + total;
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
		StatisticsInfo other = (StatisticsInfo) obj;
		if (absenteeism != other.absenteeism)
			return false;
		if (cleave != other.cleave)
			return false;
		if (late != other.late)
			return false;
		if (normal != other.normal)
			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (sleave != other.sleave)
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		if (total != other.total)
			return false;
		return true;
	}
}
