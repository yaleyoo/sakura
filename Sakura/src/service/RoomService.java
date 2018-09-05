package service;

import java.util.List;

import dataMapper.RoomMapper;
import domain.Room;

public class RoomService {
	private RoomMapper rm;
	public RoomService() {
		rm = new RoomMapper();
	}
	
	public List<Room> findAllRooms(){
		return rm.findAllRoom();
	}
}
