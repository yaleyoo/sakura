package domain;

import java.util.Date;

public class TimeRange extends DomainObject{
	private Date checkInTime;
	private Date checkOutTime;
	
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
	
	
}
