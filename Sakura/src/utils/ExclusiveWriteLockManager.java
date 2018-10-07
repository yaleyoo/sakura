package utils;

import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class ExclusiveWriteLockManager implements LockManager {
	private static ExclusiveWriteLockManager lm;
	private final int lock_been_taken = -1;
	private final int lock_can_take = 0;
	private final int you_hold_lock = 1;
	
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
		
		int lockStatus = hasLock(type, id, sessionId);
		
		// if lock is unavailable now, retry 3 times
		int i = 0;
		while (lockStatus == lock_been_taken && i<Parameters.num_of_retry) {
			if (i!=0) {
				// wait for 1s
				Thread.sleep(1000);
			}
			lockStatus = hasLock(type, id, sessionId);
			i++;
			System.out.println("[RETRY]   "+ i +" retrying..........");
		}
		
		// if current session can take the lock
		if (lockStatus == lock_can_take) {
			String acquireSQL = "insert into fuhnw47e9sr8fzla.Lock (Id, sessionId, tableName)"
					+ " values (?,?,?);"; 
			Connection conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(acquireSQL);
			pStatement.setString(1, id);
			pStatement.setString(2, sessionId);
			pStatement.setString(3, type);
			int sqlResult = pStatement.executeUpdate();
			
			DBConnection.closePreparedStatement(pStatement);
			DBConnection.closeConnection(conn);
			
			if (sqlResult == 1)
				result = true;
		}
		
		else if (lockStatus == you_hold_lock) {
			result = true;
		}
		
		return result;
	}

	@Override
	public boolean releaseLock(String type, String id, String sessionId) throws Exception {
		String releaseSQL = "delete from fuhnw47e9sr8fzla.Lock where tableName=? AND Id=?"
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
	
	/**
	 * check whether current session can acquire the lock
	 * @param type
	 * @param id
	 * @param sessionId
	 * @return
	 */
	private int hasLock(String type, String id, String sessionId) {
		String hasLockSQL = "SELECT sessionId FROM fuhnw47e9sr8fzla.Lock WHERE id =?" +
				"AND tableName=?";
		int result = 0;
		Connection conn;
		try {
			conn = DBConnection.getConnection();
			PreparedStatement pStatement = (PreparedStatement) conn.prepareStatement(hasLockSQL);
			pStatement.setString(1, id);
			pStatement.setString(2, type);
			
			ResultSet resultSet = pStatement.executeQuery();
			// if current object has been locked
			while (resultSet.next()) {
				String session_in_DB = resultSet.getString(1);
				// if current session has the lock
				if (session_in_DB.equals(sessionId)) {
					result = 1;
				}
				// if the lock has been taken by others
				else {
					result = -1;
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
