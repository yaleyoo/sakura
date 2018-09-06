package service;

import java.util.List;

import dataMapper.BookedRoomMapper;
import dataMapper.BuildingMapper;
import dataMapper.RoomMapper;
import domain.Room;

public class RoomService {
	private RoomMapper rm;
	private BuildingMapper bm;
	private BookedRoomMapper brm;
	public RoomService() {
		rm = new RoomMapper();
		bm = new BuildingMapper();
		brm = new BookedRoomMapper();
	}
	
	public List<Room> findAllRooms(){
		return rm.findAllRoom();
	}
}
