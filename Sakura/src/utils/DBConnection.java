package utils;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DBConnection {

    // For local setup, uncomment this line or, better, set the environment variable in your run configuration
	//private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/ebookshop;create=true";
	private static final String DB_CONNECTION = "jdbc:mysql://www.yaleyoo.com:3306/sakura";
	private static final String DB_USER = "sakura";
	private static final String DB_PASSWORD = "sakura";


    public static PreparedStatement prepare(String stm) {
		 
		PreparedStatement preparedStatement = null;
		try {	
	
	       	 Connection dbConnection = getDBConnection();

			preparedStatement = (PreparedStatement) dbConnection.prepareStatement(stm);

			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		
		}

		return preparedStatement;
	}
	private static Connection getDBConnection() {



		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			Connection dbConnection = (Connection) DriverManager.getConnection(
                            DB_CONNECTION, DB_USER,DB_PASSWORD);
			return dbConnection;

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		}
		System.out.println("Connection problem");
		return null;

	}

    public static PreparedStatement prepare(String stm, int returnGeneratedKeys) {
        PreparedStatement preparedStatement = null;
        try {

            Connection dbConnection = getDBConnection();

            preparedStatement = (PreparedStatement) dbConnection.prepareStatement(stm, Statement.RETURN_GENERATED_KEYS);


        } catch (SQLException e) {

            System.out.println(e.getMessage());


        }

        return preparedStatement;
    }
    
    /* test DB connection
    public static void main(String[] args) throws Exception {
		Connection conn = getDBConnection();
		System.out.println(conn);
	}*/
}
