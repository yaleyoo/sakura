package domain;

public class BookedRoom extends DomainObject{
	private int bookedRoomId;
	private TimeRange timeRange;
	private Room room;
	private int orderId;
	
	public BookedRoom() {
		
	}
	
	public BookedRoom(int bookedRoomId, TimeRange timeRange, Room room) {
		this.bookedRoomId = bookedRoomId;
		this.setTimeRange(timeRange);
		this.room = room;
	}
	
	public BookedRoom(TimeRange timeRange, Room room, int orderId) {
		this.setTimeRange(timeRange);
		this.room = room;
		this.orderId = orderId;
	}
	
	public int getBookedRoomId() {
		return bookedRoomId;
	}
	public void setBookedRoomId(int bookedRoomId) {
		this.bookedRoomId = bookedRoomId;
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

	public TimeRange getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}
	
	
}
