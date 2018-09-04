package utils;

import java.util.Date;

import domain.Order;
import service.OrderService;

public class Test {

	public static void main(String[] args) {
		
		Order o = new Order();
		
		OrderService os = new OrderService();
		System.out.println(o.getOrderId());
	}

}
