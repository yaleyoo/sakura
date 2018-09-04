package service;

import java.util.Date;

import dataMapper.OrderMapper;
import domain.Order;

public class OrderService {
	private OrderMapper om;
	public OrderService() {
		om = new OrderMapper();
	}
	
	public void insertOrder(Order order) {
		om.insertOrder(order);
	}
	
}
