package dataMapper;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.BookedRoom;
import utils.DBConnection;

public class BookedRoomMapper {
	public boolean insertBookedRoom(BookedRoom br) {
		String insertBookedRoom="INSERT INTO sakura.BookedRoom "
				+ "(bookedRoomId, checkInTime, checkOutTime, roomId)"
				+ " VALUES (?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertBookedRoom);
			pStatement.setInt(1, br.getBookedRoomId());
			pStatement.setDate(2, new Date(br.getCheckInTime().getTime()));
			pStatement.setDate(3, new Date(br.getCheckOutTime().getTime()));
			pStatement.setInt(4, br.getRoomId());
			
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
	
	public boolean updateBookedRoom (BookedRoom br) {
		String updateBookedRoomById = "UPDATE sakura.BookedRoom SET "
				+ "checkInTime=?, checkOutTime=?, roomId=? "
				+ " WHERE bookedRoomId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateBookedRoomById);
			pStatement.setDate(1, new Date(br.getCheckInTime().getTime()));
			pStatement.setDate(2, new Date(br.getCheckOutTime().getTime()));
			pStatement.setInt(3, br.getRoomId());
			
			pStatement.setInt(4, br.getBookedRoomId());
			
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
	
	public List<BookedRoom> findAllBookedRoom(BookedRoom br){
		String findAllBuilding = "SELECT * from sakura.BookedRoom";
		List<BookedRoom> result = new ArrayList<BookedRoom>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findAllBuilding);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
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

			pStatement.setInt(1, br.getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
