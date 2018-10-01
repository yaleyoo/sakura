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
			String acquireSQL = "insert into sakura.Lock (Id, locked, sessionId, table)"
					+ " values ("+id+", 1, "+sessionId+","+type+")"; 
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(acquireSQL);
			pStatement.executeUpdate();
			
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
			
			result = true;
			
		}
		return result;
	}

	@Override
	public boolean releaseLock(String type, String id, String sessionId) throws Exception {
		String releaseSQL = "delect from sakura.Lock where table="+type+"Id="
				+id+"sessionId="+sessionId;
		Connection conn = DBConnection.getConnection();
		PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(releaseSQL);
		
		int result = pStatement.executeUpdate();
		
		if (result ==0)
			return false;
		else
			return true;
	}
	
	private boolean hasLock(String type, String id, String sessionId) {
		String hasLockSQL = "select locked from sakura.Lock where id =" + id +
				"table=" + type;
		
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(hasLockSQL);
			
			ResultSet resultSet = pStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt(0) == 1) {
					DBConnection.closePreparedStatement(pStatement);
					DBConnection.closeConnection(conn);
					
					return false;
				}
			}
			
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return true;
		
	}

}
