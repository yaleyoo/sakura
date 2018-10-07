package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Staff;
import domain.DomainObject;
import utils.DBConnection;
import utils.IdentityMap;

public class StaffMapper extends DataMapper{

	@Override
	public boolean insert(DomainObject obj) {
		Staff staff = (Staff)obj;
		String insertStaff="INSERT INTO fuhnw47e9sr8fzla.Staff "
				+ "(staffId, firstname, lastname, number, status, staffType)"
				+ " VALUES (?, ?, ?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertStaff);
			pStatement.setInt(1, staff.getStaffId());
			pStatement.setString(2, staff.getFirstname());
			pStatement.setString(3, staff.getLastname());
			pStatement.setString(4, staff.getNumber());
			pStatement.setString(5, staff.getStatus());
			pStatement.setString(6, staff.getStaffType());
			
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
		Staff staff = (Staff)obj;
		String deleteStaffById = "DELETE FROM fuhnw47e9sr8fzla.Staff WHERE staffId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteStaffById);
			pStatement.setInt(1, staff.getStaffId());
			
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
		Staff staff = (Staff)obj;
		String updateStaffById = "UPDATE fuhnw47e9sr8fzla.Staff SET "
				+ "firstname=?, lastname=?, number=?, status=?, staffType=? "
				+ "WHERE staffId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateStaffById);
			pStatement.setString(1, staff.getFirstname());
			pStatement.setString(2, staff.getLastname());
			pStatement.setString(3, staff.getNumber());
			pStatement.setString(4, staff.getStatus());
			pStatement.setString(5, staff.getStaffType());
			
			pStatement.setInt(6, staff.getStaffId());
			
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
	
	public List<Staff> findStaffById (Staff staff){
		String findStaffById = "SELECT * FROM fuhnw47e9sr8fzla.Staff WHERE staffId=?";
		List<Staff> result = new ArrayList<Staff>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findStaffById);
			pStatement.setInt(1, staff.getStaffId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Staff temp = new Staff();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<Staff> identityMap = IdentityMap.getInstance(temp);
				temp.setStaffId(resultSet.getInt(1));
				temp.setFirstname(resultSet.getString(2));
				temp.setLastname(resultSet.getString(3));
				temp.setNumber(resultSet.getString(4));
				temp.setStatus(resultSet.getString(5));
				temp.setStaffType(resultSet.getString(6));
				
				//put Room Object r in the identity map
				identityMap.put(temp.getStaffId(), temp);
				result.add(temp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
		
	}
}
