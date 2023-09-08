package com.cjc.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
	@Id
	private int bId;
	private String bName;
	private String bAuthorName;
	private double price;

	public int getbId() {
		return bId;
	}

	public void setbId(int bId) {
		this.bId = bId;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public String getbAuthorName() {
		return bAuthorName;
	}

	public void setbAuthorName(String bAuthorName) {
		this.bAuthorName = bAuthorName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [bId=" + bId + ", bName=" + bName + ", bAuthorName=" + bAuthorName + ", price=" + price + "]";
	}

}
