package domain;

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
	
	@Override
	public String getId() {
		return ""+this.roomId;
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
		if (this.building == null)
			load();
		return building;
	}
	public void setBuilding(Building building) {
		this.building = building;
		
	}
	/*
	 * Using lazy load to reduce the amount of data that read to the memory
	 */
	private void load() {
		dataMapper.RoomMapper  rm = new dataMapper.RoomMapper();
		Room record = rm.findRoomById(this).get(0);
		
		if (this.building == null) {
			this.building = record.getBuilding();
		}
		
	}
	
	
	
}
