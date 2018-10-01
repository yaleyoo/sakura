package utils;

public interface LockManager {
	
	/**
	 * 
	 * @param type - the type of the acquired lock, will search in type+"Lock" table
	 * @param id - primary key of the object
	 * @param sessionId - the owner of the lock
	 * @return
	 */
	public boolean acquireLock(String type, String id, String sessionId) throws Exception;
	
	/**
	 * 
	 * @param type - the type of the acquired lock, will search in type+"Lock" table
	 * @param id - primary key of the object
	 * @param sessionId - the owner of the lock
	 * @return
	 */
	public boolean releaseLock(String type, String id, String sessionId) throws Exception;
	
}
