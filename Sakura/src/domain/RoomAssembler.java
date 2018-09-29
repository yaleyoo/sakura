package domain;

public class RoomAssembler {
	
	public RoomDTO writeDTO(Room room) {
		RoomDTO result = new RoomDTO();
		result.setName(room.getName());
		result.setPrice(room.getPrice());
		result.setRoomId(room.getRoomId());
		result.setType(room.getType());
		writeBuilding(result, room);
		
		return result;
	}
	
	public void writeBuilding(RoomDTO roomDTO, Room room) {
		BuildingDTO building = new BuildingDTO();
		building.setAddress(room.getBuilding().getAddress());
		building.setBuildingId(room.getBuilding().getBuildingId());
		building.setBuildingName(room.getBuilding().getBuildingName());
		
		roomDTO.setBuildingDTO(building);
	}
}
