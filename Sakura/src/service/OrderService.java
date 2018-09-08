package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.OrderMapper;
import domain.BookedRoom;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import utils.UnitOfWork;

public class OrderService {
	private OrderMapper om;
	public OrderService() {
		om = new OrderMapper();
	}
	
	public boolean insertOrder(Order order) {
		boolean result = true;
		
		TimeRange tr = order.getTimerange();
		Room room = order.getRoom();
		int orderId = order.getOrderId();
		BookedRoom br = new BookedRoom(tr, room, orderId);
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(br);
		UnitOfWork.getCurrent().registerNew(order);
		
		result = UnitOfWork.getCurrent().commit();
		return result;
	}
	
	public boolean cancelOrder(Order order) {
		boolean result = true;
		BookedRoom br = new BookedRoom();
		br.setOrderId(order.getOrderId());
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(br);
				
		order.setStatus(utils.Parameters.CANCEL);
		UnitOfWork.getCurrent().registerDirty(order);
		
		result = UnitOfWork.getCurrent().commit();
		return result;
	}
	
	public boolean updateOrder(Order order) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(order);
		return UnitOfWork.getCurrent().commit();
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
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(br);
		UnitOfWork.getCurrent().registerDeleted(order);
		
		result = UnitOfWork.getCurrent().commit();
		return result;
	}
	
}
