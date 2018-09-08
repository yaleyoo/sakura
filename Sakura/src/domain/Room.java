package domain;

import utils.UnitOfWork;

public class Room extends DomainObject{
	private int roomId;
	private String name;
	private String type;
	private float price;
	private Building building;
	
	public Room() {
		
	}
	
	public Room(String name, String type, float price, Building building) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.building = building;
		
		
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
		
	}
	public Building getBuilding() {
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
		
	}
	
	
	
	
}
