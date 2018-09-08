package domain;

import java.util.Date;

public class Order extends DomainObject{
	private int orderId;
	private Room room;
	private Customer customer;
	private TimeRange timerange;
	private Date createTime;
	private float sum;
	private String status;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public TimeRange getTimerange() {
		return timerange;
	}
	public void setTimerange(TimeRange timerage) {
		this.timerange = timerage;
	}
	
	
	
}
