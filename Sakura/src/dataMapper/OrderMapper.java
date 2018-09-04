package dataMapper;

import java.sql.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Order;
import utils.DBConnection;

public class OrderMapper {
	private final String insertOrder="INSERT INTO sakura.Order "
			+ "(orderId, roomId, customerId, checkIn, checkOut, createTime, sum, status)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
	public void insertOrder(Order order) {
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
			
			pStatement.executeUpdate();
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
