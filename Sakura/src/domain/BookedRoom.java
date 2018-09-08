package domain;

import java.util.Date;

public class BookedRoom extends DomainObject{
	private int bookedRoomId;
	private Date checkInTime;
	private Date checkOutTime;
	private Room room;
	private int orderId;
	
	public BookedRoom() {
		
	}
	
	public BookedRoom(int bookedRoomId, Date checkInTime, Date checkOutTime, Room room) {
		this.bookedRoomId = bookedRoomId;
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
		this.room = room;
	}
	
	public int getBookedRoomId() {
		return bookedRoomId;
	}
	public void setBookedRoomId(int bookedRoomId) {
		this.bookedRoomId = bookedRoomId;
	}
	public Date getCheckInTime() {
		return checkInTime;
	}
	public void setCheckInTime(Date checkInTime) {
		this.checkInTime = checkInTime;
	}
	public Date getCheckOutTime() {
		return checkOutTime;
	}
	public void setCheckOutTime(Date checkOutTime) {
		this.checkOutTime = checkOutTime;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
}
