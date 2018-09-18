package domain;

import java.util.Date;

public class Order extends DomainObject{
	private long orderId;
	private Room room;
	private Customer customer;
	private TimeRange timerange;
	private Date createTime;
	private float sum;
	private String status;
	
	public Order() {
		
	}
	
	public Order(Room room, Customer customer, TimeRange timerange,  float sum, String status) {
		super();
		this.room = room;
		this.customer = customer;
		this.timerange = timerange;
		this.sum = sum;
		this.status = status;
	}
	
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
		
	}
	public Date getCreateTime() {
		if (this.createTime == null)
			load();
		
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
		if (this.status == null)
			load();
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
		if (this.timerange == null)
			load();
		return timerange;
	}
	public void setTimerange(TimeRange timerage) {
		this.timerange = timerage;
		
	}
	
	/*
	 * Using lazy load to reduce the amount of data that read to the memory
	 */
	private void load() {
		dataMapper.OrderMapper  om = new dataMapper.OrderMapper();
		Order record = om.findOrderByOrderId(this).get(0);
		
		if (this.createTime == null) {
			this.createTime = record.getCreateTime();
		}
		if (this.status == null) {
			this.status = record.getStatus();
		}
		if (this.timerange == null) {
			this.timerange = record.getTimerange();
		}
		
	}
	
	
	
}
