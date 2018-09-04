package utils;

import java.util.Date;

import domain.Order;
import service.OrderService;

public class Test {

	public static void main(String[] args) {
		
		Order o = new Order();
		o.setRoomId(1);
		o.setCheckIn(new Date());
		o.setCheckOut(new Date());
		o.setCreateTime(new Date());
		o.setStatus("ssss");
		
		OrderService os = new OrderService();
		os.insertOrder(o);
	}

}
