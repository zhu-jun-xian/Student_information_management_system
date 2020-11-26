package com.ibm.cn.model;

public class Student {
	 private String id;
	 private String name;
	 private String password;
	 private String tel;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Student(String id, String name, String password, String tel) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.tel = tel;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", password=" + password + ", tel=" + tel + "]";
	}

}