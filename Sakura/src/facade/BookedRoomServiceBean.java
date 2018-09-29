package facade;

import dataMapper.BookedRoomMapper;
import domain.BookedRoom;
import domain.BookedRoomAssembler;
import domain.BookedRoomDTO;

public class BookedRoomServiceBean {
	
	public BookedRoomDTO getBookedRoom(int id) {
		BookedRoom br = new BookedRoom();
		br.setBookedRoomId(id);
		
		return new BookedRoomAssembler().writeDTO(
				new BookedRoomMapper().findBookedRoomByRoomId(br).get(0));
	}
	
	public String getBookedRoomString(int id) {
		 return getBookedRoom(id).toString();
	}
}
