package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataMapper.BookedRoomMapper;
import dataMapper.BuildingMapper;
import dataMapper.RoomMapper;
import domain.BookedRoom;
import domain.Building;
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
	
	public List<Room> findAvailableRooms(Date checkInTime, Date checkOutTime, int buildingId){
		List<BookedRoom> allBookedRooms = brm.findAllBookedRoom();
		// a list for unavilable room id
		List<Integer> unavailableRoomId = new ArrayList<Integer>();;
		
		for (int i=0;i<allBookedRooms.size();i++) {
			BookedRoom temp = allBookedRooms.get(i);
			// if customer's intended check-in time earlier than booked room's check-out time
			// or customer's intended check-out time after booked room's check-in time
			if (!(temp.getCheckInTime().after(checkOutTime) 
					||temp.getCheckOutTime().before(checkInTime))) {
				unavailableRoomId.add(temp.getRoom().getRoomId());
			}
		}
		
		Room room = new Room();
		Building building = new Building();
		building.setBuildingId(buildingId);
		room.setBuilding(building);
		List<Room> availableRooms = rm.findRoomByBuildingId(room);
		for (int i=0;i<availableRooms.size();i++) {
			// if item is in unavailableRoom list, get rid of it
			if (unavailableRoomId.contains(availableRooms.get(i).getRoomId())) {
				availableRooms.remove(i);
			}
		}
		
		return availableRooms;
	}
	
	public List<Room> findRoomById(Room room){
		return rm.findRoomById(room);
	}
	
	public boolean insertBookedRoom(BookedRoom br) {
		return brm.insertBookedRoom(br);
	}
}
