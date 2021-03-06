package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Building;
import domain.DomainObject;
import utils.DBConnection;

public class BuildingMapper extends DataMapper{

	/**
	 * function to insert record to table Building
	 * @param Building obj
	 * @return success or failed
	 */
	@Override
	public boolean insert(DomainObject obj) {
		Building building = (Building)obj;
		String insertBuilding="INSERT INTO fuhnw47e9sr8fzla.Building "
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
	
	/**
	 * function to delete record by buildingId from table Building
	 * @param Building obj
	 * @return success or failed
	 */
	@Override
	public boolean delete(DomainObject obj) {
		Building building = (Building)obj;
		String deleteBuildingById = "DELETE FROM fuhnw47e9sr8fzla.Building WHERE buildingId = ?";
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
	
	/**
	 * function to update record by buildingId to table Building
	 * @param Building obj
	 * @return success or failed
	 */
	@Override
	public boolean update (DomainObject obj) {
		Building building = (Building)obj;
		String updateBuildingById = "UPDATE fuhnw47e9sr8fzla.Building SET "
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
	
	/**
	 * function to find record by buildingId from table Building
	 * @param Building obj
	 * @return a list of building objects
	 */
	public List<Building> findBuildingById(Building building){
		String findBuildingById = "SELECT * from fuhnw47e9sr8fzla.Building WHERE buildingId = ?";
		List<Building> result = new ArrayList<Building>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBuildingById);
			pStatement.setInt(1, building.getBuildingId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Building b = new Building();
				//get Identity Map for Order
				utils.IdentityMap<Building> identityMap = utils.IdentityMap.getInstance(b);
				int buildingId = resultSet.getInt(1);
				b.setBuildingId(buildingId);
				b.setAddress(resultSet.getString(2));
				b.setBuildingName(resultSet.getString(3));
				
				//put order into identity map
				identityMap.put(b.getBuildingId(), b);
				
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * function to find all record from table Building
	 * @return a list of building objects
	 */
	public List<Building> findAllBuilding(){
		String findBuildingById = "SELECT * from fuhnw47e9sr8fzla.Building";
		List<Building> result = new ArrayList<Building>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findBuildingById);
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Building b = new Building();
				//get Identity Map for Order
				utils.IdentityMap<Building> identityMap = utils.IdentityMap.getInstance(b);
				int buildingId = resultSet.getInt(1);
				b.setBuildingId(buildingId);
				b.setAddress(resultSet.getString(2));
				b.setBuildingName(resultSet.getString(3));
				
				//put order into identity map
				identityMap.put(b.getBuildingId(), b);
				result.add(b);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
