package model;

public class Classes {
	private int departId;
	private String departName;
	private int specId;
	private String specName;
	private int classId;
	private String className;
	public int getDepartId() {
		return departId;
	}
	public void setDepartId(int departId) {
		this.departId = departId;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public int getSpecId() {
		return specId;
	}
	public void setSpecId(int specId) {
		this.specId = specId;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
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
		return "Class [院系ID:" + departId + ", \t院系名:" + departName + ", \t专业ID:" + specId + ", \t专业名:"
				+ specName + ", \t班级ID:" + classId + ", \t班级名:" + className + "]";
	}
	
}
