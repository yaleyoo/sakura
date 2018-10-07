package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Building;
import domain.DomainObject;
import domain.Room;
import utils.DBConnection;
import utils.IdentityMap;

public class RoomMapper extends DataMapper{
	@Override
	public boolean insert(DomainObject obj) {
		Room room = (Room)obj;
		String insertRoom="INSERT INTO fuhnw47e9sr8fzla.Room "
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
	
	@Override
	public boolean delete(DomainObject obj) {
		Room room = (Room)obj;
		String deleteRoomById = "DELETE FROM fuhnw47e9sr8fzla.Room WHERE roomId = ?";
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
	
	@Override
	public boolean update (DomainObject obj) {
		Room room = (Room)obj;
		String updateRoomById = "UPDATE fuhnw47e9sr8fzla.Room SET "
				+ "name=?, type=?, price=?, buildingId=?"
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
		String findAllRoom = "SELECT * from fuhnw47e9sr8fzla.Room";
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findAllRoom);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<Room> identityMap = IdentityMap.getInstance(r);
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
				
				//put Room Object r in the identity map
				identityMap.put(r.getRoomId(), r);
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Room> findRoomById(Room room){
		String findRoomById = "SELECT * from fuhnw47e9sr8fzla.Room WHERE roomId = ?";
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomById);
			pStatement.setInt(1, room.getRoomId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<Room> identityMap = IdentityMap.getInstance(r);
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
				
				//put Room Object r in the identity map
				identityMap.put(r.getRoomId(), r);
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Room> findRoomByType(Room room){
		String findRoomByType = "SELECT * From fuhnw47e9sr8fzla.Room WHERE type = ?";
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomByType);
			pStatement.setString(1, room.getType());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<Room> identityMap = IdentityMap.getInstance(r);
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
				
				//put Room Object r in the identity map
				identityMap.put(r.getRoomId(), r);
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Room> findRoomByBuildingId(Room room){
		String findRoomByBuildingId = "SELECT * from fuhnw47e9sr8fzla.Room WHERE buildingId = ?";
		List<Room> result = new ArrayList<Room>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findRoomByBuildingId);
			pStatement.setInt(1, room.getBuilding().getBuildingId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Room r = new Room();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<Room> identityMap = IdentityMap.getInstance(r);
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
				
				//put Room Object r in the identity map
				identityMap.put(r.getRoomId(), r);
				
				
				result.add(r);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
