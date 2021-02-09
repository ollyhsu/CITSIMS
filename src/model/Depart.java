package model;
/**
 * 院系类
 * @author kimix
 *
 */

public class Depart {
	private int dpId;
	private String dpName;
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
	@Override
	public String toString() {
		return "Depart [院系ID:" + dpId + ", \t院系名称：" + dpName + "]";
	}
	
}
