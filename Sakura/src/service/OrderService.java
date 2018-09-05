package service;

import java.util.List;

import dataMapper.OrderMapper;
import domain.Order;

public class OrderService {
	private OrderMapper om;
	public OrderService() {
		om = new OrderMapper();
	}
	
	public boolean insertOrder(Order order) {
		return om.insertOrder(order);
	}
	
	public boolean deleteOrder(Order order) {
		return om.deleteOrder(order);
	}
	
	public boolean updateOrder(Order order) {
		return om.updateOrder(order);
	}
	
	public List<Order> findOrder(Order order){
		if (order.getOrderId() != 0)
			return om.findOrderByOrderId(order);
		else if (order.getRoomId() != 0)
			return om.findOrderByRoomId(order);
		else if (order.getCustomerId() != 0)
			return om.findOrderByCustomerId(order);
		else
			return null;
	}
	
}
