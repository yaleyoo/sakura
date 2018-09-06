package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Building;
import domain.Room;
import utils.DBConnection;

public class RoomMapper {
	public boolean insertRoom(Room room) {
		String insertRoom="INSERT INTO sakura.Room "
				+ "(roomId, name, type, price, buildingId)"
				+ " VALUES (?, ?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertRoom);
			pStatement.setInt(1, room.getRoomId());
			pStatement.setString(2, room.getName());
			pStatement.setString(3, room.getType());
			pStatement.setFloat(4, room.getPrice());
			pStatement.setInt(5, room.getBuilding().getBuildingId());
			
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
	
	public boolean deleteRoom(Room room) {
		String deleteRoomById = "DELETE FROM sakura.Room WHERE roomId = ?";
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
	
	public boolean updateRoom (Room room) {
		String updateRoomById = "UPDATE sakura.Room SET "
				+ "name=?, =?, type=?, price=?, buildingId=?,"
				+ " WHERE roomId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateRoomById);
			pStatement.setString(1, room.getName());
			pStatement.setString(2, room.getType());
			pStatement.setFloat(3, room.getPrice());
			pStatement.setInt(4, room.getBuilding().getBuildingId());
			
			pStatement.setInt(5, room.getRoomId());
			
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
	
	public List<Room> findAllRoom(){
		String findAllRoom = "SELECT * from sakura.Room";
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
				
				//set room.building
				int buildingId = resultSet.getInt(5);
				BuildingMapper bm = new BuildingMapper();
				Building b = new Building();
				b.setBuildingId(buildingId);
				r.setBuilding(bm.findBuildingById(b).get(0));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Room> findRoomById(Room room){
		String findRoomById = "SELECT * from sakura.Room WHERE roomId = ?";
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
				//set room.building
				int buildingId = resultSet.getInt(5);
				BuildingMapper bm = new BuildingMapper();
				Building b = new Building();
				b.setBuildingId(buildingId);
				r.setBuilding(bm.findBuildingById(b).get(0));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Room> findRoomByType(Room room){
		String findRoomByType = "SELECT * From sakura.Room WHERE type = ?";
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
				//set room.building
				int buildingId = resultSet.getInt(5);
				BuildingMapper bm = new BuildingMapper();
				Building b = new Building();
				b.setBuildingId(buildingId);
				r.setBuilding(bm.findBuildingById(b).get(0));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Room> findRoomByBuildingId(Room room){
		String findRoomByBuildingId = "SELECT * from sakura.Room WHERE buildingId = ?";
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomByBuildingId);
			pStatement.setInt(1, room.getBuilding().getBuildingId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				r.setRoomId(resultSet.getInt(1));
				r.setName(resultSet.getString(2));
				r.setType(resultSet.getString(3));
				r.setPrice(resultSet.getFloat(4));
				//set room.building
				int buildingId = resultSet.getInt(5);
				BuildingMapper bm = new BuildingMapper();
				Building b = new Building();
				b.setBuildingId(buildingId);
				r.setBuilding(bm.findBuildingById(b).get(0));
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
