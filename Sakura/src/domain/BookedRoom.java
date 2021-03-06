package domain;

public class BookedRoom extends DomainObject{
	private int bookedRoomId;
	private TimeRange timeRange;
	private Room room;
	private long orderId;
	
	public BookedRoom() {
		
	}
	
	@Override
	public String getId() {
		return this.room.getId();
	}
	
	public BookedRoom(int bookedRoomId, TimeRange timeRange, Room room) {
		this.bookedRoomId = bookedRoomId;
		this.setTimeRange(timeRange);
		this.room = room;
	}
	
	public BookedRoom(TimeRange timeRange, Room room, long orderId) {
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public TimeRange getTimeRange() {
		return timeRange;
	}

	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}
	
	
}
