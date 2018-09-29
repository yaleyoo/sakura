package domain;

import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

import net.sf.json.JSONObject;

public class OrderDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long orderId;
	private RoomDTO room;
	private CustomerDTO customer;
	private TimeRange timerange;
	private Date createTime;
	private float sum;
	private String status;
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public RoomDTO getRoom() {
		return room;
	}
	public void setRoom(RoomDTO room) {
		this.room = room;
	}
	public CustomerDTO getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDTO customer) {
		this.customer = customer;
	}
	public TimeRange getTimerange() {
		return timerange;
	}
	public void setTimerange(TimeRange timerange) {
		this.timerange = timerange;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public float getSum() {
		return sum;
	}
	public void setSum(float sum) {
		this.sum = sum;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		/*return "Order{"+
				"orderId=" + orderId +
				"room=" + room.toString() +
				"customer=" + customer.toString() +
				"timeRange=" + timerange.toString() +
				"createTime=" + createTime.toString() + 
				"sum=" + sum +
				"status=" + status +
				"}";*/
		return JSONObject.fromObject(this).toString();
		
	}
	
	public static OrderDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (OrderDTO) JSONObject.toBean(json, OrderDTO.class);
	}
	
	
}
