package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import domain.Customer;

public class OrderIdGenerator {

	/**
	 * Based on customer's information generate an unique orderId.
	 * @param customer
	 * @return an unique orderId
	 */
	public static long getOrderId(Customer customer) {
		SimpleDateFormat sdf =   new SimpleDateFormat("yyMMddHHmmss");
		Date current = new Date();
		String orderId_str = sdf.format(current) + customer.getCustomerId();
		
		return Long.parseLong(orderId_str);
	}
	
}
