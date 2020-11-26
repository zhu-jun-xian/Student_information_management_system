package com.ibm.cn.model;

public class Messages {
	private int stuNum;
	private String stuID;
	private String stuName;
	private String stuBirth;
	private String stuSex;
	private String stuTel;
	private String stuClass;
	private String stuDep;
	private String stuAddTimed;
	private String stuImgUrl;
	private String stu;
	
	private String totalClass;
	 private String totalSex;
	 private String totalDep;
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getStuBirth() {
		return stuBirth;
	}
	public void setStuBirth(String stuBirth) {
		this.stuBirth = stuBirth;
	}
	public String getStuSex() {
		return stuSex;
	}
	public void setStuSex(String stuSex) {
		this.stuSex = stuSex;
	}
	public String getStuTel() {
		return stuTel;
	}
	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}
	public String getStuClass() {
		return stuClass;
	}
	public void setStuClass(String stuClass) {
		this.stuClass = stuClass;
	}
	public String getStuDep() {
		return stuDep;
	}
	public void setStuDep(String stuDep) {
		this.stuDep = stuDep;
	}
	public String getStuAddTimed() {
		return stuAddTimed;
	}
	public void setStuAddTimed(String stuAddTimed) {
		this.stuAddTimed = stuAddTimed;
	}
	public String getStuImgUrl() {
		return stuImgUrl;
	}
	public void setStuImgUrl(String stuImgUrl) {
		this.stuImgUrl = stuImgUrl;
	}
	public Messages(int stuNum, String stuID, String stuName, String stuBirth, String stuSex, String stuTel,
			String stuClass, String stuDep, String stuAddTimed, String stuImgUrl) {
		super();
		this.stuNum = stuNum;
		this.stuID = stuID;
		this.stuName = stuName;
		this.stuBirth = stuBirth;
		this.stuSex = stuSex;
		this.stuTel = stuTel;
		this.stuClass = stuClass;
		this.stuDep = stuDep;
		this.stuAddTimed = stuAddTimed;
		this.stuImgUrl = stuImgUrl;
	}
	public Messages() {
		super();
	}
	@Override
	public String toString() {
		return "Messages [stuNum=" + stuNum + ", stuID=" + stuID + ", stuName=" + stuName + ", stuBirth=" + stuBirth
				+ ", stuSex=" + stuSex + ", stuTel=" + stuTel + ", stuClass=" + stuClass + ", stuDep=" + stuDep
				+ ", stuAddTimed=" + stuAddTimed + ", stuImgUrl=" + stuImgUrl + "]";
	}
	public String getStu() {
		return stu;
	}
	public void setStu(String stu) {
		this.stu = stu;
	}
	public String getTotalClass() {
		return totalClass;
	}
	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}
	public String getTotalSex() {
		return totalSex;
	}
	public void setTotalSex(String totalSex) {
		this.totalSex = totalSex;
	}
	public String getTotalDep() {
		return totalDep;
	}
	public void setTotalDep(String totalDep) {
		this.totalDep = totalDep;
	}
	
	
}
