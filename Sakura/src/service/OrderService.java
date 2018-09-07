package service;

import java.util.List;

import dataMapper.BookedRoomMapper;
import dataMapper.OrderMapper;
import domain.BookedRoom;
import domain.Order;

public class OrderService {
	private OrderMapper om;
	private BookedRoomMapper rm;
	public OrderService() {
		om = new OrderMapper();
		rm = new BookedRoomMapper();
	}
	
	public boolean insertOrder(Order order) {
		boolean result = true;
		BookedRoom br = new BookedRoom();
		br.setCheckInTime(order.getTimerange().getCheckInTime());
		br.setCheckOutTime(order.getTimerange().getCheckOutTime());
		br.setRoom(order.getRoom());
		
		result = rm.insertBookedRoom(br);
		if (!result)
			return result;
		result = om.insertOrder(order);
		
		return result;
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
		else if (order.getRoom().getRoomId() != 0)
			return om.findOrderByRoomId(order);
		else if (order.getCustomer().getCustomerId() != 0)
			return om.findOrderByCustomerId(order);
		else
			return null;
	}
	
}
