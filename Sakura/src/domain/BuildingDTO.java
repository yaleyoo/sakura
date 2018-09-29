package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class BuildingDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int buildingId;
	private String address;
	private String buildingName;
	public int getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(int buildingId) {
		this.buildingId = buildingId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	

	@Override
	public String toString() {
		/*return "Building{"+
				"buildingId=" + buildingId +
				"address=" + address+
				"buildingName=" + buildingName +
				"}";*/
		return JSONObject.fromObject(this).toString();
		
	}
	
	public static BuildingDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (BuildingDTO) JSONObject.toBean(json, BuildingDTO.class);
	}
	
	
}
