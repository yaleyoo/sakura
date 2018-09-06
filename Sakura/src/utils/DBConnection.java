package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBConnection {

    private static String driverString = "com.mysql.jdbc.Driver";
	private static String connectionString = "jdbc:mysql://www.yaleyoo.com:3306/sakura";
	private static String username = "sakura";
	private static String password = "sakura";
	private static Connection connection = null;
	public static Connection getConnection() throws Exception {
		if (connection == null) {
			try {
				Class.forName(driverString);
				connection = (Connection) DriverManager.getConnection(connectionString,username,password);
			} catch (Exception e) {
				throw e;
			}
			return connection;
		}
		else
			return connection;
	}
	public static void closeStatement(Statement statement) throws Exception {
		statement.close();
	}
	public static void closePreparedStatement(PreparedStatement pStatement)
			throws Exception {
		pStatement.close();
	}
	public static void closeResultSet(ResultSet resultSet) throws Exception {
		resultSet.close();
	}
	public static void closeConnection(Connection connection) throws Exception {
		connection.close();
	}
	
	/* test the DB Connection
	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
	}*/
}
