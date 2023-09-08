package com.cjc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tutor {

	@Id
	private int tid;
	private String tname;
	private String tlastName;
	private String taddress;
	private String tcity;
	private String temailId;
	private String tpassword;
	private String tusername;
	private int tphoneNo;

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

	public String getTlastName() {
		return tlastName;
	}

	public void setTlastName(String tlastName) {
		this.tlastName = tlastName;
	}

	public String getTaddress() {
		return taddress;
	}

	public void setTaddress(String taddress) {
		this.taddress = taddress;
	}

	public String getTcity() {
		return tcity;
	}

	public void setTcity(String tcity) {
		this.tcity = tcity;
	}

	public String getTemailId() {
		return temailId;
	}

	public void setTemailId(String temailId) {
		this.temailId = temailId;
	}

	public String getTpassword() {
		return tpassword;
	}

	public void setTpassword(String tpassword) {
		this.tpassword = tpassword;
	}

	public String getTusername() {
		return tusername;
	}

	public void setTusername(String tusername) {
		this.tusername = tusername;
	}

	public int getTphoneNo() {
		return tphoneNo;
	}

	public void setTphoneNo(int tphoneNo) {
		this.tphoneNo = tphoneNo;
	}

	@Override
	public String toString() {
		return "Tutor [tid=" + tid + ", tname=" + tname + ", tlastName=" + tlastName + ", taddress=" + taddress
				+ ", tcity=" + tcity + ", temailId=" + temailId + ", tpassword=" + tpassword + ", tusername="
				+ tusername + ", tphoneNo=" + tphoneNo + "]";
	}

}
