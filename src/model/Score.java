package model;

public class Score {
	private int scoreId;
	private String departName;
	private String specName;
	private String className;
	private int stuId;
	private String stuName;
	private int stuSex;
	private String courseName;
	private double score;
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
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
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Score [成绩单ID:" + scoreId + ",\t学院:" + departName + ",\t专业:" + specName + ",\t班级:"
				+ className + ",\t学生ID:" + stuId + ",\t姓名:" + stuName + ",\t性别:" + stuSex + ",\t课程名:"
				+ courseName + ",\t成绩:" + score + "]";
	}
	
}
