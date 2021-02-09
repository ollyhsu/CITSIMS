package model;

public class Course {
	private int courseId;
	private String courseName;
	private double courseScore;
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getCourseScore() {
		return courseScore;
	}
	public void setCourseScore(double courseScore) {
		this.courseScore = courseScore;
	}
	@Override
	public String toString() {
		return "Course [课程ID:" + courseId + ",\t课程名:" + courseName + ",\t学分:" + courseScore + "]";
	}
	
}
