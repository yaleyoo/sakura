package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.BookedRoomMapper;
import dataMapper.OrderMapper;
import domain.BookedRoom;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import utils.UnitOfWork;

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
		br.setOrderId(order.getOrderId());
		
		result = rm.insertBookedRoom(br);
		if (!result)
			return result;
		result = om.insertOrder(order);
		
		return result;
	}
	
	public boolean cancelOrder(Order order) {
		boolean result = true;
		BookedRoom br = new BookedRoom();
		br.setOrderId(order.getOrderId());
		result = rm.deleteBookedRoomByOrderId(br);
		
		if (!result)
			return result;
		
		order.setStatus(utils.Parameters.CANCEL);
		return om.updateOrder(order);
	}
	
	public boolean updateOrder(Order order) {
		return om.updateOrder(order);
	}
	
	public List<Order> findOrder(Order order){
		if (order.getOrderId() != 0) {
			//search identity map first
			utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(order);
			Order order_inMap = identityMap.get(order.getOrderId());
			//if object is found
			if (order_inMap != null) {
				List<Order> result = new ArrayList<Order>();
				result.add(order_inMap);
				return result;
			}
			//if object is not found in identity map, fetch from DB
			return om.findOrderByOrderId(order);
		}
		else if (order.getRoom() != null)
			return om.findOrderByRoomId(order);
		else if (order.getCustomer() != null)
			return om.findOrderByCustomerId(order);
		else
			return null;
	}
	
	public boolean deleteOrder(Order order) {
		boolean result = true;
		BookedRoom br = new BookedRoom();
		br.setOrderId(order.getOrderId());
		result = rm.deleteBookedRoomByOrderId(br);
		
		if (!result)
			return result;
		
		return om.deleteOrder(order);
	}
	
}
