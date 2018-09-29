package facade;

import dataMapper.RoomMapper;
import domain.Room;
import domain.RoomAssembler;
import domain.RoomDTO;

public class RoomServiceBean {
	public RoomDTO getRoom(int id) {
		Room br = new Room();
		br.setRoomId(id);
		
		return new RoomAssembler().writeDTO(
				new RoomMapper().findRoomById(br).get(0));
	}
	
	public String getBookedRoomString(int id) {
		 return getRoom(id).toString();
	}
}
