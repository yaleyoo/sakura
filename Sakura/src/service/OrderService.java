package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.BookedRoomMapper;
import dataMapper.OrderMapper;
import domain.BookedRoom;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import utils.ExclusiveWriteLockManager;
import utils.LockManager;
import utils.UnitOfWork;

public class OrderService {
	private OrderMapper om;
	private BookedRoomMapper brm;
	public OrderService() {
		om = new OrderMapper();
		brm = new BookedRoomMapper();
	}
	
	/**
	 * insert order information
	 * @param order - an order object which need to be wrote into db
	 * @param sessionId - the id for the session who performs this update
	 * @return
	 */
	public boolean insertOrder(Order order, String sessionId) {
		boolean result = true;
		
		TimeRange tr = order.getTimerange();
		Room room = order.getRoom();
		long orderId = order.getOrderId();
		BookedRoom br = new BookedRoom(tr, room, orderId);
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(br);
		UnitOfWork.getCurrent().registerNew(order);
		
		result = UnitOfWork.getCurrent().commit(sessionId);
		return result;
	}
	
	/**
	 * update a order information, set its status to 'cancel', 
	 * and delete the relevant bookedRoom record.  
	 * @param order - an order object which need to be canceled from db
	 * @param sessionId - the id for the session who performs this cancel performance
	 * @return
	 */
	public boolean cancelOrder(Order order, String sessionId) {
		boolean result = true;
		BookedRoom temp = new BookedRoom();
		temp.setOrderId(order.getOrderId());
		BookedRoom br = brm.findBookedRoomByOrderId(temp).get(0);
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(br);
				
		order.setStatus(utils.Parameters.CANCEL);
		UnitOfWork.getCurrent().registerDirty(order);
		
		result = UnitOfWork.getCurrent().commit(sessionId);
		return result;
	}
	
	/**
	 * update order information
	 * @param order - an order object which need to be update in db
	 * @param sessionId - the id for the session who performs this update
	 * @return
	 */
	public boolean updateOrder(Order order, String sessionId) {
		BookedRoom temp = new BookedRoom();
		temp.setOrderId(order.getOrderId());
		BookedRoom br = brm.findBookedRoomByOrderId(temp).get(0);
		UnitOfWork.newCurrent();
		if (br.getRoom().getRoomId() != order.getRoom().getRoomId()
				||br.getTimeRange().getCheckInTime()!=order.getTimerange().getCheckInTime()
				||br.getTimeRange().getCheckOutTime()!=order.getTimerange().getCheckOutTime()) {
			br.setTimeRange(order.getTimerange());
			br.setRoom(order.getRoom());
			UnitOfWork.getCurrent().registerDirty(br);
		}
		UnitOfWork.getCurrent().registerDirty(order);
		
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	
	/**
	 * find building by buildingId, it would search the identity map first,
	 * if not in identity map, search database
	 * @param building
	 * @return a list of building objects
	 */
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
	
	/**
	 * Implemented for potential further usage. This function should not be invoked
	 * for now.
	 * @param order - an order object which need to be deleted in db
	 * @param sessionId - the id for the session who performs this delete
	 * @return
	 */
	public boolean deleteOrder(Order order, String sessionId) {
		boolean result = true;
		BookedRoom br = new BookedRoom();
		br.setOrderId(order.getOrderId());
		
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(br);
		UnitOfWork.getCurrent().registerDeleted(order);
		
		result = UnitOfWork.getCurrent().commit(sessionId);
		return result;
	}
	
	/**
	 * check the availability of the booked room, and if the room is available,
	 * place the order, would only be invoked by placeOrderCommand.
	 * --------------------------
	 * Lock the records in table BookedRoom with given roomId when 
	 * performing the search available rooms action.
	 * --------------------------
	 * And release the lock when the order has been placed (no matter success or not).
	 * 
	 * @param order
	 * @param sessionId
	 * @return
	 */
	public boolean validateOrder(Order order, String sessionId) {
		LockManager lm = ExclusiveWriteLockManager.getInstance();
		boolean result = false;
		try {
			if (lm.acquireLock("BookedRoom", order.getRoom().getId(), sessionId)) {
				RoomService rs = new RoomService();
				// if ordered room is now available
				List<Room> list = rs.findAvailableRooms(order.getTimerange().getCheckInTime(), 
						order.getTimerange().getCheckOutTime(), 
						order.getRoom().getBuilding().getBuildingId());
				boolean isContain = false;
				for (Room r:list) {
					if (r.getRoomId() == order.getRoom().getRoomId()) {
						isContain = true;
						break;
					}
				}
				if (isContain) {
					result = insertOrder(order, sessionId);
				}
				lm.releaseLock("BookedRoom", order.getRoom().getId(), sessionId);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
}
