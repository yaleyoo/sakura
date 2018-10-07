package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class RoomDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int roomId;
	private String name;
	private String type;
	private float price;
	private BuildingDTO buildingDTO;
	
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
	public BuildingDTO getBuilding() {
		return buildingDTO;
	}
	public void setBuildingDTO(BuildingDTO building) {
		this.buildingDTO = building;
	}
	
	@Override
	public String toString() {
		/*return "Room{"+
				"roomId=" + roomId +
				"name=" + name +
				"type=" + type +
				"price=" + price +
				"building=" + building.toString() + 
				"}";*/
		return JSONObject.fromObject(this).toString();
		
	}
	
	/**
	 * convert a string into a roomDTO object
	 * @param s
	 * @return
	 */
	public static RoomDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (RoomDTO) JSONObject.toBean(json, RoomDTO.class);
	}
}
