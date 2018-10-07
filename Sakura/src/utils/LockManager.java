package utils;

public interface LockManager {
	
	/**
	 * acquire the lock for specific type and id.
	 * @param type - the type of the acquired lock, will search in type+"Lock" table
	 * @param id - primary key of the object
	 * @param sessionId - the owner of the lock
	 * @return
	 */
	public boolean acquireLock(String type, String id, String sessionId) throws Exception;
	
	/**
	 * release the lock for specific type and id.
	 * @param type - the type of the acquired lock, will search in type+"Lock" table
	 * @param id - primary key of the object
	 * @param sessionId - the owner of the lock
	 * @return
	 */
	public boolean releaseLock(String type, String id, String sessionId) throws Exception;
	
}
