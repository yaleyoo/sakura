package dataMapper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import domain.Customer;
import domain.DomainObject;
import utils.DBConnection;
import utils.IdentityMap;

public class CustomerMapper extends DataMapper{
	
	@Override
	public boolean insert(DomainObject obj) {
		Customer customer = (Customer)obj;
		String insertCustomer="INSERT INTO sakura.Customer "
				+ "(customerId, firstname, lastname, title, identityNumber, identityType, number, email)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(insertCustomer);
			pStatement.setInt(1, customer.getCustomerId());
			pStatement.setString(2, customer.getFirstname());
			pStatement.setString(3, customer.getLastname());
			pStatement.setString(4, customer.getTitle());
			pStatement.setString(5, customer.getIdentityNumber());
			pStatement.setString(6, customer.getIdentityType());
			pStatement.setString(7, customer.getNumber());
			pStatement.setString(8, customer.getEmail());
			
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
		Customer customer = (Customer)obj;
		String deleteCustomerById = "DELETE FROM sakura.Customer WHERE customerId = ?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(deleteCustomerById);
			pStatement.setInt(1, customer.getCustomerId());
			
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
		Customer customer = (Customer)obj;
		String updateCustomerById = "UPDATE sakura.Customer SET "
				+ "firstname=?, lastname=?, title=?, identityNumber=?, identityType=?,"
				+ " number=?, email=? WHERE customerId=?";
		int result = 0;
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(updateCustomerById);
			pStatement.setString(1, customer.getFirstname());
			pStatement.setString(2, customer.getLastname());
			pStatement.setString(3, customer.getTitle());
			pStatement.setString(4, customer.getIdentityNumber());
			pStatement.setString(5, customer.getIdentityType());
			pStatement.setString(6, customer.getNumber());
			pStatement.setString(7, customer.getEmail());
			
			pStatement.setInt(8, customer.getCustomerId());
			
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
	
	public List<Customer> findCustomerById(Customer customer){
		String findCustomerById = "SELECT * from sakura.Customer WHERE customerId = ?";
		List<Customer> result = new ArrayList<Customer>();
		try {
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(findCustomerById);
			pStatement.setInt(1, customer.getCustomerId());
			ResultSet resultSet = pStatement.executeQuery();
			
			while(resultSet.next()) {
				Customer c = new Customer();
				//adapting IDENTITY MAP, get identityMap for Room.
				IdentityMap<Customer> identityMap = IdentityMap.getInstance(c);
				c.setCustomerId(resultSet.getInt(1));
				c.setFirstname(resultSet.getString(2));
				c.setLastname(resultSet.getString(3));
				c.setTitle(resultSet.getString(4));
				c.setIdentityNumber(resultSet.getString(5));
				c.setIdentityType(resultSet.getString(6));
				c.setNumber(resultSet.getString(7));
				c.setEmail(resultSet.getString(8));
				
				//put Room Object r in the identity map
				identityMap.put(c.getCustomerId(), c);
				result.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
