package model;

/**
 * 用户类
 * @author kimix
 *
 */
public class User {
	private int uid;
	private String uName;
	private String uPwd;
	private int uType;
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuPwd() {
		return uPwd;
	}
	public void setuPwd(String uPwd) {
		this.uPwd = uPwd;
	}
	public int getuType() {
		return uType;
	}
	public void setuType(int uType) {
		this.uType = uType;
	}
	@Override
	public String toString() {
		return "User [用户ID:" + uid + ", \t用户名:" + uName + ", \t用户密码:" + uPwd + ", \t用户权限:" + uType + "]";
	}
	
}
