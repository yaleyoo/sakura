package utils;

import java.util.Date;

public class DateValidator {
	
	/**
	 * Used for validate the check-in and check-out date.
	 * 1. check-in date should be a future date
	 * 2. check-out date should after check-in date
	 * @param checkInDate
	 * @param checkOutDate
	 * @return
	 */
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
	
	/**
	 * Used for calculate the number of days between two Date objects.
	 * Result will take the result of its ceil value.
	 * e.g. calculateDateGap(2018-10-10 10:00:00, 2018-10-10 11:00:00) = 1
	 * @param checkinDate
	 * @param checkOutDate
	 * @return the days between checkinDate and checkOutDate
	 */
	public static int calculateDateGap(Date checkinDate, Date checkOutDate) {
		return (int) Math.ceil(
				(double)(checkOutDate.getTime()-checkinDate.getTime())
				/1000/60/60/24);

	}
}
