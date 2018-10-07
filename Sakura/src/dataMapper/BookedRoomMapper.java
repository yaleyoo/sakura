package dataMapper;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.BookedRoom;
import domain.DomainObject;
import domain.Room;
import domain.TimeRange;
import utils.DBConnection;
import utils.IdentityMap;

public class BookedRoomMapper extends DataMapper {
	
	@Override
	public boolean insert(DomainObject obj) {
		BookedRoom br = (BookedRoom)obj;
		String insertBookedRoom="INSERT INTO fuhnw47e9sr8fzla.BookedRoom "
				+ "(bookedRoomId, checkInTime, checkOutTime, roomId, orderId)"
				+ " VALUES (?, ?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertBookedRoom);
			pStatement.setInt(1, br.getBookedRoomId());
			pStatement.setTimestamp(2, new Timestamp(br.getTimeRange().getCheckInTime().getTime()));
			pStatement.setTimestamp(3, new Timestamp(br.getTimeRange().getCheckOutTime().getTime()));
			pStatement.setInt(4, br.getRoom().getRoomId());
			pStatement.setLong(5, br.getOrderId());
			
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
	
	@Override
	public boolean delete(DomainObject obj) {
		BookedRoom br = (BookedRoom)obj;
		String deleteBookedRoomById = "DELETE FROM fuhnw47e9sr8fzla.BookedRoom WHERE bookedRoomId = ?";
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
		String deleteBookedRoomById = "DELETE FROM fuhnw47e9sr8fzla.BookedRoom WHERE orderId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteBookedRoomById);
			pStatement.setLong(1, br.getOrderId());
			
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
	
	@Override
	public boolean update (DomainObject obj) {
		BookedRoom br = (BookedRoom)obj;
		String updateBookedRoomById = "UPDATE fuhnw47e9sr8fzla.BookedRoom SET "
				+ "checkInTime=?, checkOutTime=?, roomId=?, orderId=? "
				+ " WHERE bookedRoomId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateBookedRoomById);
			pStatement.setTimestamp(1, new Timestamp(br.getTimeRange().getCheckInTime().getTime()));
			pStatement.setTimestamp(2, new Timestamp(br.getTimeRange().getCheckOutTime().getTime()));
			pStatement.setInt(3, br.getRoom().getRoomId());
			pStatement.setLong(4, br.getOrderId());
			
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
		String findAllBuilding = "SELECT * from fuhnw47e9sr8fzla.BookedRoom";
		List<BookedRoom> result = new ArrayList<BookedRoom>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findAllBuilding);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
				
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<BookedRoom> identityMap = IdentityMap.getInstance(b);
				
				b.setBookedRoomId(resultSet.getInt(1));
				TimeRange tr = new TimeRange(resultSet.getTimestamp(2),resultSet.getTimestamp(3));
				b.setTimeRange(tr);
				//set room
				int roomId = resultSet.getInt(4);
				Room r = new Room();
				r.setRoomId(roomId);
				RoomMapper rm = new RoomMapper();
				b.setRoom(rm.findRoomById(r).get(0));
				
				b.setOrderId(resultSet.getLong(5));
				//put Room Object b in the identity map
				identityMap.put(b.getBookedRoomId(), b);
				
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<BookedRoom> findBookedRoomByRoomId(BookedRoom br){
		String findBookedRoomByRoomId = "SELECT * from fuhnw47e9sr8fzla.BookedRoom WHERE roomId=?";
		List<BookedRoom> result = new ArrayList<BookedRoom>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBookedRoomByRoomId);

			pStatement.setInt(1, br.getRoom().getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<BookedRoom> identityMap = IdentityMap.getInstance(b);
				
				b.setBookedRoomId(resultSet.getInt(1));
				TimeRange tr = new TimeRange(resultSet.getTimestamp(2),resultSet.getTimestamp(3));
				b.setTimeRange(tr);
				//set room
				int roomId = resultSet.getInt(4);
				Room r = new Room();
				r.setRoomId(roomId);
				RoomMapper rm = new RoomMapper();
				b.setRoom(rm.findRoomById(r).get(0));
				
				b.setOrderId(resultSet.getLong(5));
				//put Room Object b in the identity map
				identityMap.put(b.getBookedRoomId(), b);
				
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<BookedRoom> findBookedRoomByOrderId(BookedRoom br){
		String findBookedRoomByRoomId = "SELECT * from fuhnw47e9sr8fzla.BookedRoom WHERE orderId=?";
		List<BookedRoom> result = new ArrayList<BookedRoom>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBookedRoomByRoomId);

			pStatement.setLong(1, br.getOrderId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				BookedRoom b = new BookedRoom();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<BookedRoom> identityMap = IdentityMap.getInstance(b);
				
				b.setBookedRoomId(resultSet.getInt(1));
				TimeRange tr = new TimeRange(resultSet.getTimestamp(2),resultSet.getTimestamp(3));
				b.setTimeRange(tr);
				//set room
				int roomId = resultSet.getInt(4);
				Room r = new Room();
				r.setRoomId(roomId);
				RoomMapper rm = new RoomMapper();
				b.setRoom(rm.findRoomById(r).get(0));
				
				b.setOrderId(resultSet.getLong(5));
				//put Room Object b in the identity map
				identityMap.put(b.getBookedRoomId(), b);
				
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
