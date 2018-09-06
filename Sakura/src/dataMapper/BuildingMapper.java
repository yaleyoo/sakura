package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Building;
import domain.Room;
import utils.DBConnection;

public class BuildingMapper {

	public boolean insertBuilding(Building building) {
		String insertBuilding="INSERT INTO sakura.Building "
				+ "(buildingId, address, buildingName)"
				+ " VALUES (?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertBuilding);
			pStatement.setInt(1, building.getBuildingId());
			pStatement.setString(2, building.getAddress());
			pStatement.setString(3, building.getBuildingName());
			
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
	
	public boolean deleteBuilding(Building building) {
		String deleteBuildingById = "DELETE FROM sakura.Building WHERE buildingId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteBuildingById);
			pStatement.setInt(1, building.getBuildingId());
			
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
	
	public boolean updateBuilding (Building building) {
		String updateBuildingById = "UPDATE sakura.Building SET "
				+ "address=?, buildingName=? "
				+ " WHERE buildingId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateBuildingById);
			pStatement.setString(1, building.getAddress());
			pStatement.setString(2, building.getBuildingName());
			
			pStatement.setInt(3, building.getBuildingId());
			
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
	
	public List<Building> findBuildingById(Building building){
		String findBuildingById = "SELECT * from sakura.Building WHERE buildingId = ?";
		List<Building> result = new ArrayList<Building>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBuildingById);
			pStatement.setInt(1, building.getBuildingId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Building b = new Building();
				int buildingId = resultSet.getInt(1);
				b.setBuildingId(buildingId);
				b.setAddress(resultSet.getString(2));
				b.setBuildingName(resultSet.getString(3));
				
				//set room list
				List<Room> roomList = new ArrayList<Room>();
				//RoomMapper rm = new RoomMapper();
				//Building tempBuilding = new Building();
				//tempBuilding.setBuildingId(buildingId);
				//Room tempRoom = new Room();
				//tempRoom.setBuilding(tempBuilding);
				//roomList = rm.findRoomByBuildingId(tempRoom);
				b.setRoomList(roomList);
				
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public List<Building> findAllBuilding(){
		String findBuildingById = "SELECT * from sakura.Building";
		List<Building> result = new ArrayList<Building>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBuildingById);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Building b = new Building();
				int buildingId = resultSet.getInt(1);
				b.setBuildingId(buildingId);
				b.setAddress(resultSet.getString(2));
				b.setBuildingName(resultSet.getString(3));
				//set room list
				List<Room> roomList = new ArrayList<Room>();
				//RoomMapper rm = new RoomMapper();
				//Building tempBuilding = new Building();
				//tempBuilding.setBuildingId(buildingId);
				//Room tempRoom = new Room();
				//tempRoom.setBuilding(tempBuilding);
				
				//roomList = rm.findRoomByBuildingId(tempRoom);
				b.setRoomList(roomList);
				
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
