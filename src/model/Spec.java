package model;

/**
 * 专业类
 * 
 * @author kimix
 *
 */
public class Spec {
	private int dpId;
	private String dpName;
	private int spId;
	private String spName;

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

	@Override
	public String toString() {
		return "Spec [院系ID:" + dpId + ", \t院系名称:" + dpName + ", \t专业ID:" + spId + ", \t专业名称:" + spName + "]";
	}
}
