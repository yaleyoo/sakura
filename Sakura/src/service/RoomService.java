package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dataMapper.BookedRoomMapper;
import dataMapper.RoomMapper;
import domain.BookedRoom;
import domain.Building;
import domain.Room;
import utils.UnitOfWork;

public class RoomService {
	private RoomMapper rm;
	private BookedRoomMapper brm;
	public RoomService() {
		rm = new RoomMapper();
		brm = new BookedRoomMapper();
	}
	
	/**
	 * find all rooms
	 * @return a list of room objects
	 */
	public List<Room> findAllRooms(){
		return rm.findAllRoom();
	}
	
	/**
	 * Given the time period and the building id, find out all of the available rooms 
	 * in this building.
	 * @param checkInTime - the check in Date object
	 * @param checkOutTime - the check out Date object
	 * @param buildingId
	 * @return a list of available rooms during this period in this building.
	 */
	public List<Room> findAvailableRooms(Date checkInTime, Date checkOutTime, int buildingId){
		List<BookedRoom> allBookedRooms = brm.findAllBookedRoom();
		// a list for unavailable room id
		List<Integer> unavailableRoomId = new ArrayList<Integer>();;
		
		for (int i=0;i<allBookedRooms.size();i++) {
			BookedRoom temp = allBookedRooms.get(i);
			// if customer's intended check-in time earlier than booked room's check-out time
			// or customer's intended check-out time after booked room's check-in time
			if (!(temp.getTimeRange().getCheckInTime().after(checkOutTime) 
					||temp.getTimeRange().getCheckOutTime().before(checkInTime))) {
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
	
	/**
	 * find room by roomId, it would search the identity map first,
	 * if not in identity map, search database
	 * @param room
	 * @return a list of room objects
	 */
	public List<Room> findRoomById(Room room){
		//search Identity Map first
		utils.IdentityMap<Room> identityMap = utils.IdentityMap.getInstance(room);
		Room room_inMap = identityMap.get(room.getRoomId());
		//if object in identity map
		if (room_inMap != null) {
			List<Room> result = new ArrayList<Room>();
			result.add(room_inMap);
			return result;
		}
		return rm.findRoomById(room);
	}
	
	/**
	 * find room by buildingId
	 * @param room
	 * @return a list of room objects
	 */
	public List<Room> findRoomByBuildingId(Room room){
		
		return rm.findRoomByBuildingId(room);
	}
	
	/**
	 * insert BookedRoom information
	 * @param br - a bookedRoom object which need to be inserted into BookedRoom table
	 * @param sessionId -  the id for the session who performs this insert
	 * @return
	 */
	public boolean insertBookedRoom(BookedRoom br, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(br);
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	/**
	 * delete room information
	 * @param room - a room object which need to be deleted from db
	 * @param sessionId - the id for the session who performs this insert
	 * @return
	 */
	public boolean deleteRoom(Room room, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(room);
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	/**
	 * insert Room information
	 * @param room - a room object which need to be inserted into db
	 * @param sessionId -  the id for the session who performs this insert
	 * @return
	 */
	public boolean insertRoom(Room room, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(room);
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	/**
	 * update room information
	 * @param room - a room object which need to be updated into db
	 * @param sessionId - the id for the session who performs this insert
	 * @return
	 */
	public boolean updateRoom(Room room, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(room);
		return UnitOfWork.getCurrent().commit(sessionId);
	}
}
