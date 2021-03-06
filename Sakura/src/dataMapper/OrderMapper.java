package dataMapper;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Customer;
import domain.DomainObject;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import utils.DBConnection;

public class OrderMapper extends DataMapper {
	
	/**
	 * function to insert record to table Order
	 * @param Order obj
	 * @return success or failed
	 */
	@Override
	public boolean insert(DomainObject obj) {
		Order order = (Order) obj;
		String insertOrder="INSERT INTO fuhnw47e9sr8fzla.Order "
				+ "(orderId, roomId, customerId, checkIn, checkOut, createTime, sum, status)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertOrder);
			pStatement.setLong(1, order.getOrderId());
			pStatement.setInt(2, order.getRoom().getRoomId());
			pStatement.setInt(3, order.getCustomer().getCustomerId());
			pStatement.setTimestamp(4, new Timestamp(order.getTimerange().getCheckInTime().getTime()));
			pStatement.setTimestamp(5, new Timestamp(order.getTimerange().getCheckOutTime().getTime()));
			pStatement.setTimestamp(6, new Timestamp(order.getCreateTime().getTime()));
			pStatement.setFloat(7, order.getSum());
			pStatement.setString(8, order.getStatus());
			
			result = pStatement.executeUpdate();
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}

	/**
	 * function to delete record by orderId to table Order
	 * @param Order obj
	 * @return success or failed
	 */
	@Override
	public boolean delete(DomainObject obj) {
		Order order = (Order) obj;
		String deleteOrderById = "DELETE FROM fuhnw47e9sr8fzla.Order WHERE orderId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteOrderById);
			pStatement.setLong(1, order.getOrderId());
			
			result = pStatement.executeUpdate();
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}
	
	/**
	 * function to update record by orderId to table Order
	 * @param Order obj
	 * @return success or failed
	 */
	@Override
	public boolean update (DomainObject obj) {
		Order order = (Order)obj;
		String updateOrderById = "UPDATE fuhnw47e9sr8fzla.Order SET "
				+ "roomId=?, customerId=?, checkIn=?, checkOut=?, createTime=?, sum=?, status=? "
				+ "WHERE orderId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateOrderById);
			pStatement.setInt(1, order.getRoom().getRoomId());
			pStatement.setInt(2, order.getCustomer().getCustomerId());
			pStatement.setTimestamp(3, new Timestamp(order.getTimerange().getCheckInTime().getTime()));
			pStatement.setTimestamp(4, new Timestamp(order.getTimerange().getCheckOutTime().getTime()));
			pStatement.setTimestamp(5, new Timestamp(order.getCreateTime().getTime()));
			pStatement.setFloat(6, order.getSum());
			pStatement.setString(7, order.getStatus());
			
			pStatement.setLong(8, order.getOrderId());
			
			result = pStatement.executeUpdate();
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 0)
			return false;
		else 
			return true;
	}
	
	/**
	 * function to find record by orderId from table Order
	 * @param order
	 * @return list of order objects
	 */
	public List<Order> findOrderByOrderId(Order order){
		String findOrderByOrderId = "SELECT * from fuhnw47e9sr8fzla.Order WHERE orderId = ?";
		List<Order> result = new ArrayList<Order>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findOrderByOrderId);
			pStatement.setLong(1, order.getOrderId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Order o = new Order();
				//get Identity Map for Order
				utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(o);
				
				o.setOrderId(resultSet.getLong(1));
				//set room
				Room tempRoom = new Room();
				tempRoom.setRoomId(resultSet.getInt(2));
				RoomMapper rm = new RoomMapper();
				o.setRoom(rm.findRoomById(tempRoom).get(0));
				//set Customer
				Customer tempCustomer = new Customer();
				tempCustomer.setCustomerId(resultSet.getInt(3));
				CustomerMapper cm = new CustomerMapper();
				o.setCustomer(cm.findCustomerById(tempCustomer).get(0));
				//set Timerange
				TimeRange tempTR = new TimeRange();
				tempTR.setCheckInTime(resultSet.getTimestamp(4));
				tempTR.setCheckOutTime(resultSet.getTimestamp(5));
				o.setTimerange(tempTR);
				
				o.setCreateTime(resultSet.getTimestamp(6));
				o.setSum(resultSet.getFloat(7));
				o.setStatus(resultSet.getString(8));
				
				//put order into identity map
				identityMap.put(o.getOrderId(), o);
				
				result.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * function to find record by roomId from table Order
	 * @param order
	 * @return list of order objects
	 */
	public List<Order> findOrderByRoomId(Order order){
		String findOrderByRoomId = "SELECT * from fuhnw47e9sr8fzla.Order WHERE roomId = ?";
		List<Order> result = new ArrayList<Order>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findOrderByRoomId);
			pStatement.setInt(1, order.getRoom().getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Order o = new Order();
				//get Identity Map for Order
				utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(o);
				
				o.setOrderId(resultSet.getLong(1));
				//set room
				Room tempRoom = new Room();
				tempRoom.setRoomId(resultSet.getInt(2));
				RoomMapper rm = new RoomMapper();
				o.setRoom(rm.findRoomById(tempRoom).get(0));
				//set Customer
				Customer tempCustomer = new Customer();
				tempCustomer.setCustomerId(resultSet.getInt(3));
				CustomerMapper cm = new CustomerMapper();
				o.setCustomer(cm.findCustomerById(tempCustomer).get(0));
				//set Timerange
				TimeRange tempTR = new TimeRange();
				tempTR.setCheckInTime(resultSet.getTimestamp(4));
				tempTR.setCheckOutTime(resultSet.getTimestamp(5));
				o.setTimerange(tempTR);
				
				o.setCreateTime(resultSet.getTimestamp(6));
				o.setSum(resultSet.getFloat(7));
				o.setStatus(resultSet.getString(8));
				
				//put order into identity map
				identityMap.put(o.getOrderId(), o);
				
				result.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * function to find record by customerId from table Order
	 * @param order
	 * @return list of order objects
	 */
	public List<Order> findOrderByCustomerId(Order order){
		String findOrderByCustomerId = "SELECT * from fuhnw47e9sr8fzla.Order WHERE customerId = ?";
		List<Order> result = new ArrayList<Order>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findOrderByCustomerId);
			pStatement.setInt(1, order.getCustomer().getCustomerId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Order o = new Order();
				//get Identity Map for Order
				utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(o);
				
				o.setOrderId(resultSet.getLong(1));
				//set room
				Room tempRoom = new Room();
				tempRoom.setRoomId(resultSet.getInt(2));
				RoomMapper rm = new RoomMapper();
				o.setRoom(rm.findRoomById(tempRoom).get(0));
				//set Customer
				Customer tempCustomer = new Customer();
				tempCustomer.setCustomerId(resultSet.getInt(3));
				CustomerMapper cm = new CustomerMapper();
				o.setCustomer(cm.findCustomerById(tempCustomer).get(0));
				//set Timerange
				TimeRange tempTR = new TimeRange();
				tempTR.setCheckInTime(resultSet.getTimestamp(4));
				tempTR.setCheckOutTime(resultSet.getTimestamp(5));
				o.setTimerange(tempTR);
				
				o.setCreateTime(resultSet.getTimestamp(6));
				o.setSum(resultSet.getFloat(7));
				o.setStatus(resultSet.getString(8));
				
				//put order into identity map
				identityMap.put(o.getOrderId(), o);
				
				result.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
