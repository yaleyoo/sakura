package dataMapper;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.BookedRoom;
import domain.Room;
import utils.DBConnection;

public class BookedRoomMapper {
	public boolean insertBookedRoom(BookedRoom br) {
		String insertBookedRoom="INSERT INTO sakura.BookedRoom "
				+ "(bookedRoomId, checkInTime, checkOutTime, roomId, orderId)"
				+ " VALUES (?, ?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertBookedRoom);
			pStatement.setInt(1, br.getBookedRoomId());
			pStatement.setTimestamp(2, new Timestamp(br.getCheckInTime().getTime()));
			pStatement.setTimestamp(3, new Timestamp(br.getCheckOutTime().getTime()));
			pStatement.setInt(4, br.getRoom().getRoomId());
			pStatement.setInt(5, br.getOrderId());
			
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
	
	public boolean deleteBookedRoom(BookedRoom br) {
		String deleteBookedRoomById = "DELETE FROM sakura.BookedRoom WHERE bookedRoomId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteBookedRoomById);
			pStatement.setInt(1, br.getBookedRoomId());
			
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
	
	public boolean deleteBookedRoomByOrderId(BookedRoom br) {
		String deleteBookedRoomById = "DELETE FROM sakura.BookedRoom WHERE orderId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteBookedRoomById);
			pStatement.setInt(1, br.getOrderId());
			
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
	
	public boolean updateBookedRoom (BookedRoom br) {
		String updateBookedRoomById = "UPDATE sakura.BookedRoom SET "
				+ "checkInTime=?, checkOutTime=?, roomId=?, orderId=? "
				+ " WHERE bookedRoomId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateBookedRoomById);
			pStatement.setTimestamp(1, new Timestamp(br.getCheckInTime().getTime()));
			pStatement.setTimestamp(2, new Timestamp(br.getCheckOutTime().getTime()));
			pStatement.setInt(3, br.getRoom().getRoomId());
			pStatement.setInt(4, br.getOrderId());
			
			pStatement.setInt(5, br.getBookedRoomId());
			
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
	
	public List<BookedRoom> findAllBookedRoom(){
		String findAllBuilding = "SELECT * from sakura.BookedRoom";
		List<BookedRoom> result = new ArrayList<BookedRoom>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findAllBuilding);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
				b.setBookedRoomId(resultSet.getInt(1));
				b.setCheckInTime(resultSet.getTimestamp(2));
				b.setCheckOutTime(resultSet.getTimestamp(3));
				//set room
				int roomId = resultSet.getInt(4);
				Room r = new Room();
				r.setRoomId(roomId);
				RoomMapper rm = new RoomMapper();
				b.setRoom(rm.findRoomById(r).get(0));
				
				b.setOrderId(resultSet.getInt(5));
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<BookedRoom> findBookedRoomByRoomId(BookedRoom br){
		String findBookedRoomByRoomId = "SELECT * from sakura.BookedRoom WHERE roomId=?";
		List<BookedRoom> result = new ArrayList<BookedRoom>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBookedRoomByRoomId);

			pStatement.setInt(1, br.getRoom().getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
				b.setBookedRoomId(resultSet.getInt(1));
				b.setCheckInTime(resultSet.getTimestamp(2));
				b.setCheckOutTime(resultSet.getTimestamp(3));
				//set room
				int roomId = resultSet.getInt(4);
				Room r = new Room();
				r.setRoomId(roomId);
				RoomMapper rm = new RoomMapper();
				b.setRoom(rm.findRoomById(r).get(0));
				
				b.setOrderId(resultSet.getInt(5));
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
