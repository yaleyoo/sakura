package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Room;
import utils.DBConnection;

public class RoomMapper {
	private final String insertRoom="INSERT INTO sakura.Room "
			+ "(roomId, name, type, price, buildingId, available)"
			+ " VALUES (?, ?, ?, ?, ?, ?);";
	public boolean insertRoom(Room room) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertRoom);
			pStatement.setInt(1, room.getRoomId());
			pStatement.setString(2, room.getName());
			pStatement.setString(3, room.getType());
			pStatement.setFloat(4, room.getPrice());
			pStatement.setInt(5, room.getBuildingId());
			pStatement.setInt(6, room.getAvailable());
			
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
	
	private final String deleteRoomById = "DELETE FROM sakura.Room WHERE roomId = ?";
	public boolean deleteRoom(Room room) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteRoomById);
			pStatement.setInt(1, room.getRoomId());
			
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
	
	private final String updateRoomById = "UPDATE sakura.Room SET "
			+ "name=?, =?, type=?, price=?, buildingId=?,"
			+ " available=? WHERE roomId=?";
	public boolean updateRoom (Room room) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateRoomById);
			pStatement.setString(1, room.getName());
			pStatement.setString(2, room.getType());
			pStatement.setFloat(3, room.getPrice());
			pStatement.setInt(4, room.getBuildingId());
			pStatement.setInt(5, room.getAvailable());
			
			pStatement.setInt(8, room.getRoomId());
			
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
	
	private final String updateRoomAvailability = "UPDATE sakura.Room SET "
			+ "available=? WHERE roomId=?";
	public boolean updateRoomAvailability(Room room) {
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateRoomAvailability);
			pStatement.setInt(1, room.getAvailable());
			
			pStatement.setInt(2, room.getRoomId());
			
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
	
	private final String findAllRoom = "SELECT * from sakura.Room";
	public List<Room> findAllRoom(){
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findAllRoom);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				r.setRoomId(resultSet.getInt(1));
				r.setName(resultSet.getString(2));
				r.setType(resultSet.getString(3));
				r.setPrice(resultSet.getFloat(4));
				r.setBuildingId(resultSet.getInt(5));
				r.setAvailable(resultSet.getInt(6));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private final String findRoomById = "SELECT * from sakura.Room WHERE roomId = ?";
	public List<Room> findRoomById(Room room){
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomById);
			pStatement.setInt(1, room.getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				r.setRoomId(resultSet.getInt(1));
				r.setName(resultSet.getString(2));
				r.setType(resultSet.getString(3));
				r.setPrice(resultSet.getFloat(4));
				r.setBuildingId(resultSet.getInt(5));
				r.setAvailable(resultSet.getInt(6));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private final String findRoomByType = "SELECT * From sakura.Room WHERE type = ?";
	public List<Room> findRoomByType(Room room){
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomByType);
			pStatement.setString(1, room.getType());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				r.setRoomId(resultSet.getInt(1));
				r.setName(resultSet.getString(2));
				r.setType(resultSet.getString(3));
				r.setPrice(resultSet.getFloat(4));
				r.setBuildingId(resultSet.getInt(5));
				r.setAvailable(resultSet.getInt(6));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private final String findRoomByAvailability = "SELECT * From sakura.Room WHERE available = ?";
	public List<Room> findRoomByAvailability(Room room){
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomByAvailability);
			pStatement.setInt(1, room.getAvailable());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				r.setRoomId(resultSet.getInt(1));
				r.setName(resultSet.getString(2));
				r.setType(resultSet.getString(3));
				r.setPrice(resultSet.getFloat(4));
				r.setBuildingId(resultSet.getInt(5));
				r.setAvailable(resultSet.getInt(6));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
