package domain;

public class BookedRoomAssembler {

	/**
	 * create a bookedRoom DTO based on a bookedRoom object
	 * @param bookedRoom
	 * @return
	 */
	public BookedRoomDTO writeDTO(BookedRoom bookedRoom) {
		BookedRoomDTO result = new BookedRoomDTO();
		result.setBookedRoomId(bookedRoom.getBookedRoomId());
		result.setOrderId(bookedRoom.getOrderId());
		result.setTimeRange(bookedRoom.getTimeRange());
		writeRoom(result, bookedRoom);
		
		return result;
	}
	
	/**
	 * fill the room property in bookRoomDTO
	 * @param bookedRoomDTO
	 * @param bookedRoom
	 */
	private void writeRoom(BookedRoomDTO bookedRoomDTO, BookedRoom bookedRoom) {
		RoomDTO room = new RoomDTO();
		room.setName(bookedRoom.getRoom().getName());
		room.setPrice(bookedRoom.getRoom().getPrice());
		room.setRoomId(bookedRoom.getRoom().getRoomId());
		room.setType(bookedRoom.getRoom().getType());
		writeBuilding(room, bookedRoom.getRoom());
		
		bookedRoomDTO.setRoomDTO(room);
		
	}
	/**
	 * fill the building property in roomDTO
	 * @param bookedRoomDTO
	 * @param room
	 */
	private void writeBuilding(RoomDTO bookedRoomDTO, Room room) {
		BuildingDTO building = new BuildingDTO();
		building.setAddress(room.getBuilding().getAddress());
		building.setBuildingId(room.getBuilding().getBuildingId());
		building.setBuildingName(room.getBuilding().getBuildingName());
		
		bookedRoomDTO.setBuildingDTO(building);
	}
}
