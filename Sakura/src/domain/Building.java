package domain;

import java.util.List;

public class Building extends DomainObject{
	private int buildingId;
	private String address;
	private String buildingName;
	
	public Building() {
		
	}
	
	@Override
	public String getId() {
		return ""+this.buildingId;
	}
	
	public Building(String address, String buildingName, List<Room> roomList) {
		super();
		this.address = address;
		this.buildingName = buildingName;
	}
	
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
	
	
}
