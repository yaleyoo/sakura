package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class BookedRoomDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int bookedRoomId;
	private TimeRange timeRange;
	private RoomDTO room;
	private long orderId;
	
	public int getBookedRoomId() {
		return bookedRoomId;
	}
	public void setBookedRoomId(int bookedRoomId) {
		this.bookedRoomId = bookedRoomId;
	}
	public TimeRange getTimeRange() {
		return timeRange;
	}
	public void setTimeRange(TimeRange timeRange) {
		this.timeRange = timeRange;
	}
	public RoomDTO getRoomDTO() {
		return room;
	}
	public void setRoomDTO(RoomDTO room) {
		this.room = room;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	
	@Override
	public String toString() {
		/*return "BookedRoom{"+
				"bookedRoomId=" + bookedRoomId +
				"timeRange=" + timeRange+
				"room=" + room +
				"orderId=" + orderId +
				"}";*/
		return JSONObject.fromObject(this).toString();
		
	}
	
	/**
	 * convert a string to BookedRoomDTO object
	 * @param a String which contain
	 * @return BookedRoomDTO object
	 */
	public static BookedRoomDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (BookedRoomDTO) JSONObject.toBean(json, BookedRoomDTO.class);
	}
	
}
