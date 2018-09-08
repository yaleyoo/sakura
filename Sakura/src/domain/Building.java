package domain;

import java.util.List;

public class Building extends DomainObject{
	private int buildingId;
	private String address;
	private String buildingName;
	private List<Room> roomList;
	
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
	public List<Room> getRoomList() {
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
	}
	
	
}
