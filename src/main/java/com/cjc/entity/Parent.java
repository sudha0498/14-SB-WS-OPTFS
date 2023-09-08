package com.cjc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Parent {
	@Id
	private int pid;
	private String username;
	private String password;
	private String pname;
	private String plastname;
	private long pmobileno;
	private String address;
	private String city;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {

		this.pid = pid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPlastname() {
		return plastname;
	}

	public void setPlastname(String plastname) {
		this.plastname = plastname;
	}

	public long getPmobileno() {
		return pmobileno;
	}

	public void setPmobileno(long pmobileno) {
		this.pmobileno = pmobileno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Parent [pid=" + pid + ", username=" + username + ", password=" + password + ", pname=" + pname
				+ ", plastname=" + plastname + ", pmobileno=" + pmobileno + ", address=" + address + ", city=" + city
				+ "]";
	}

}
