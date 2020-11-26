package com.ibm.cn.model;

public class Sex {
	private String sex;
	private String count;
	public Sex(String sex, String count) {
		super();
		this.sex = sex;
		this.count = count;
	}
	public Sex() {
		super();
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "Sex [sex=" + sex + ", count=" + count + "]";
	}
	
}
