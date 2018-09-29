package utils;

import java.util.Date;

public class DateValidator {
	//TODO: datevalidator
	public static boolean validateCheckInOutDate(Date checkInDate, Date checkOutDate) {
		//if checkinDate has past
		if (checkInDate.before(new Date())) {
			return false;
		}
		// if checkOutDate is earlier than checkInDate
		if (checkOutDate.before(checkInDate)) {
			return false;
		}
		return true;
	}
	
	public static int calculateDateGap(Date checkinDate, Date checkOutDate) {
		return (int) ((checkOutDate.getTime()-checkinDate.getTime())/1000/60/60/24);

	}
}
