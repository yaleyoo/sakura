package domain;

import java.util.List;

public class Building extends DomainObject{
	private int buildingId;
	private String address;
	private String buildingName;
	private List<Room> roomList;
	
	public Building() {
		
	}
	
	public Building(String address, String buildingName, List<Room> roomList) {
		super();
		this.address = address;
		this.buildingName = buildingName;
		this.roomList = roomList;
		
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
	public List<Room> getRoomList() {
		if (this.roomList == null)
			load();
		return roomList;
	}
	public void setRoomList(List<Room> roomList) {
		this.roomList = roomList;
		
	}
	/*
	 * Using lazy load to reduce the amount of data that read to the memory
	 */
	private void load() {
		dataMapper.BuildingMapper  bm = new dataMapper.BuildingMapper();
		Building record = bm.findBuildingById(this).get(0);
		
		if (this.roomList == null) {
			this.roomList = record.getRoomList();
		}
		
	}
	
	
}
