package domain;

import java.io.Serializable;
import java.util.Date;

/**
 * This class is embedded value for order object and bookedroom object 
 *
 */
public class TimeRange extends DomainObject implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date checkInTime;
	private Date checkOutTime;
	
	public TimeRange(Date checkInTime, Date checkOutTime) {
		super();
		this.checkInTime = checkInTime;
		this.checkOutTime = checkOutTime;
	}

	public TimeRange() {
		
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
	
	
}
