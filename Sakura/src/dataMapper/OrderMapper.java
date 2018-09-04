package dataMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Order;
import utils.DBConnection;

public class OrderMapper {
	private final String insertOrder="INSERT INTO sakura.Order "
			+ "(orderId, roomId, customerId, checkIn, checkOut, createTime, sum, status)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	public boolean insertOrder(Order order) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertOrder);
			pStatement.setInt(1, order.getOrderId());
			pStatement.setInt(2, order.getRoomId());
			pStatement.setInt(3, order.getCustomerId());
			pStatement.setDate(4, new Date(order.getCheckIn().getTime()));
			pStatement.setDate(5, new Date(order.getCheckOut().getTime()));
			pStatement.setDate(6, new Date(order.getCreateTime().getTime()));
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

	private final String deleteOrderById = "DELETE FROM sakura.Order WHERE orderId = ?";
	public boolean deleteOrder(Order order) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteOrderById);
			pStatement.setInt(1, order.getOrderId());
			
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

	private final String updateOrderById = "UPDATE sakura.Order SET "
			+ "roomId=?, customerId=?, checkIn=?, checkOut=?, createTime=?, sum=?, status=? "
			+ "WHERE orderId=?";
	public boolean updateOrder (Order order) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateOrderById);
			pStatement.setInt(1, order.getRoomId());
			pStatement.setInt(2, order.getCustomerId());
			pStatement.setDate(3, new Date(order.getCheckIn().getTime()));
			pStatement.setDate(4, new Date(order.getCheckOut().getTime()));
			pStatement.setDate(5, new Date(order.getCreateTime().getTime()));
			pStatement.setFloat(6, order.getSum());
			pStatement.setString(7, order.getStatus());
			
			pStatement.setInt(8, order.getOrderId());
			
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
	
	private final String findOrderByOrderId = "SELECT * from sakura.Order WHERE orderId = ?";
	public List<Order> findOrderByOrderId(Order order){
		List<Order> result = new ArrayList<Order>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findOrderByOrderId);
			pStatement.setInt(1, order.getOrderId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Order o = new Order();
				o.setOrderId(resultSet.getInt(1));
				o.setRoomId(resultSet.getInt(2));
				o.setCustomerId(resultSet.getInt(3));
				o.setCheckIn(resultSet.getDate(4));
				o.setCheckOut(resultSet.getDate(5));
				o.setCreateTime(resultSet.getDate(6));
				o.setSum(resultSet.getFloat(7));
				o.setStatus(resultSet.getString(8));
				
				result.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private final String findOrderByRoomId = "SELECT * from sakura.Order WHERE roomId = ?";
	public List<Order> findOrderByRoomId(Order order){
		List<Order> result = new ArrayList<Order>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findOrderByRoomId);
			pStatement.setInt(1, order.getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Order o = new Order();
				o.setOrderId(resultSet.getInt(1));
				o.setRoomId(resultSet.getInt(2));
				o.setCustomerId(resultSet.getInt(3));
				o.setCheckIn(resultSet.getDate(4));
				o.setCheckOut(resultSet.getDate(5));
				o.setCreateTime(resultSet.getDate(6));
				o.setSum(resultSet.getFloat(7));
				o.setStatus(resultSet.getString(8));
				
				result.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private final String findOrderByCustomerId = "SELECT * from sakura.Order WHERE customerId = ?";
	public List<Order> findOrderByCustomerId(Order order){
		List<Order> result = new ArrayList<Order>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findOrderByCustomerId);
			pStatement.setInt(1, order.getCustomerId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Order o = new Order();
				o.setOrderId(resultSet.getInt(1));
				o.setRoomId(resultSet.getInt(2));
				o.setCustomerId(resultSet.getInt(3));
				o.setCheckIn(resultSet.getDate(4));
				o.setCheckOut(resultSet.getDate(5));
				o.setCreateTime(resultSet.getDate(6));
				o.setSum(resultSet.getFloat(7));
				o.setStatus(resultSet.getString(8));
				
				result.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
