package model;

import java.sql.Date;

public class Student {
	private int stuId;
	private String stuName;
	private int stuSex;
	private Date stuBirth;
	private int dpId;
	private String dpName;
	private int spId;
	private String spName;
	private int classId;
	private String className;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public int getStuSex() {
		return stuSex;
	}
	public void setStuSex(int stuSex) {
		this.stuSex = stuSex;
	}
	public Date getStuBirth() {
		return stuBirth;
	}
	public void setStuBirth(Date stuBirth) {
		this.stuBirth = stuBirth;
	}
	public int getDpId() {
		return dpId;
	}
	public void setDpId(int dpId) {
		this.dpId = dpId;
	}
	public String getDpName() {
		return dpName;
	}
	public void setDpName(String dpName) {
		this.dpName = dpName;
	}
	public int getSpId() {
		return spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	@Override
	public String toString() {
		return "Student [学生ID:" + stuId + ",\t姓名:" + stuName + ",\t性别:" + stuSex + ",\t出生日期:" + stuBirth
				+ ",\t院系ID:" + dpId + ", 院系名:" + dpName + ",\t专业ID:" + spId + ", 专业:" + spName + ",\t班级ID:"
				+ classId + ", 班级名:" + className + "]";
	}
	
}
