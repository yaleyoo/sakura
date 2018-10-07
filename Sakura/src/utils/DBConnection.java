package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBConnection {
	private static ThreadLocal<Connection> current = new ThreadLocal<Connection>();
    private static String driverString = "com.mysql.jdbc.Driver";
	private static String connectionString = "jdbc:mysql://lmag6s0zwmcswp5w.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/fuhnw47e9sr8fzla";
	private static String username = "cspyu8m80uyskk24";
	private static String password = "gxfbizs4ee0lurrw";
	/**
	 * Get singleton Connection object for current thread.
	 * @return Connection object for current thread.
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		Connection connection;
		// if current thread has no connection instance, create one.
		if (current.get() == null) {
			try {
				Class.forName(driverString);
				connection = (Connection) DriverManager.getConnection(connectionString,username,password);
			} catch (Exception e) {
				throw e;
			}
			current.set(connection);
			return connection;
		}
		else
			return current.get();
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
		current.set(null);
		connection.close();
	}
	
	/* test the DB Connection
	public static void main(String[] args) throws Exception {
		Connection conn = DBUtil.getConnection();
		System.out.println(conn);
	}*/
}
