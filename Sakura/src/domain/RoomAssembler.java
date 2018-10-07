package domain;

public class RoomAssembler {
	
	/**
	 * write a roomDTO based on a room object
	 * @param room
	 * @return
	 */
	public RoomDTO writeDTO(Room room) {
		RoomDTO result = new RoomDTO();
		result.setName(room.getName());
		result.setPrice(room.getPrice());
		result.setRoomId(room.getRoomId());
		result.setType(room.getType());
		writeBuilding(result, room);
		
		return result;
	}
	
	/**
	 * fill the building field in roomDTO object
	 * @param roomDTO
	 * @param room
	 */
	private void writeBuilding(RoomDTO roomDTO, Room room) {
		BuildingDTO building = new BuildingDTO();
		building.setAddress(room.getBuilding().getAddress());
		building.setBuildingId(room.getBuilding().getBuildingId());
		building.setBuildingName(room.getBuilding().getBuildingName());
		
		roomDTO.setBuildingDTO(building);
	}
}
