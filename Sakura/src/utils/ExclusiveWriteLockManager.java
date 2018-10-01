package utils;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ExclusiveWriteLockManager implements LockManager {
	private static ExclusiveWriteLockManager lm;
	
	private ExclusiveWriteLockManager() {
		
	}
	
	public static ExclusiveWriteLockManager getInstance() {
		if (lm == null) {
			lm = new ExclusiveWriteLockManager();
		}
		
		return lm;
	}

	@Override
	public boolean acquireLock(String type, String id, String sessionId) throws Exception {
		
		boolean result = false;
		
		if (!hasLock(type, id, sessionId)) {
			String acquireSQL = "insert into sakura.Lock (Id, sessionId, tableName)"
					+ " values (?,?,?);"; 
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(acquireSQL);
			pStatement.setString(1, id);
			pStatement.setString(2, sessionId);
			pStatement.setString(3, type);
			pStatement.executeUpdate();
			
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
			
			result = true;
		}
		return result;
	}

	@Override
	public boolean releaseLock(String type, String id, String sessionId) throws Exception {
		String releaseSQL = "delete from sakura.Lock where tableName=? AND Id=?"
				+" AND sessionId=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(releaseSQL);
		pStatement.setString(1, type);
		pStatement.setString(2, id);
		pStatement.setString(3, sessionId);
		
		int result = pStatement.executeUpdate();
		
		if (result ==0)
			return false;
		else
			return true;
	}
	
	private boolean hasLock(String type, String id, String sessionId) {
		String hasLockSQL = "SELECT sessionId FROM sakura.Lock WHERE id =?" +
				"AND tableName=?";
		boolean result = false;
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(hasLockSQL);
			pStatement.setString(1, id);
			pStatement.setString(2, type);
			
			ResultSet resultSet = pStatement.executeQuery();
			// if current session has the lock
			while (resultSet.next()) {
				String session_in_DB = resultSet.getString(0);
				if (session_in_DB.equals(sessionId)) {
					result = true;
				}
			}
			
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}

}
