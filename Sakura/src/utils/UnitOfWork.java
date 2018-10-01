package utils;

import java.util.ArrayList;
import java.util.List;

import dataMapper.*;
import domain.*;

public class UnitOfWork {
	@SuppressWarnings("rawtypes")
	private static ThreadLocal current = new ThreadLocal();
	
	private List<DomainObject> newObjects = new ArrayList<DomainObject>();
	private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
	private List<DomainObject> deletedObjects = new ArrayList<DomainObject>();
	

public static void newCurrent() { 
	setCurrent(new UnitOfWork());
}

@SuppressWarnings("unchecked")
public static void setCurrent(UnitOfWork uow) { 
	current.set(uow);
}

public static UnitOfWork getCurrent() {
	return (UnitOfWork) current.get();
}

public void registerDirty(DomainObject obj) {
	 if(!checkIfInList(obj)) {
		 dirtyObjects.add(obj);
	 }	 
}

public void registerDeleted(DomainObject obj) {
	 if(!checkIfInList(obj)) {
		 deletedObjects.add(obj);
	 }	 
}

public void registerNew(DomainObject obj) {
	 if(!checkIfInList(obj)) {
		 newObjects.add(obj);
	 }
}

public boolean checkIfInList(DomainObject obj) {
	 if(dirtyObjects.contains(obj)) {
		 return true;
	 }
	 if(deletedObjects.contains(obj)) {
		 return true;
	 }
	 if(newObjects.contains(obj)) {
		 return true;
	 }
	 return false;
}

public boolean commit(String sessionId) {
	boolean addResult = true;
	boolean updateResult = true;
	boolean deleteResult = true;
	//deal with new objects
	for(DomainObject obj: newObjects) {
		if(!addResult) {
			return false;
		}
		try {
			DataMapper dm = (DataMapper) Class.forName(
					"dataMapper."+obj.getClass().getSimpleName()+"Mapper").newInstance();
			dm.insert(obj);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//deal with dirty objects
	for(DomainObject obj: dirtyObjects) {
		if(!updateResult) {
			return false;
		}
		
		try {
			DataMapper dm = (DataMapper) Class.forName(
					"dataMapper."+obj.getClass().getSimpleName()+"Mapper").newInstance();
			ImplicitMapper im = new ImplicitMapper(
					dm, sessionId, obj.getClass().getSimpleName());
			im.update(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//deal with deleted objects
	for(DomainObject obj: deletedObjects) {
		if(!deleteResult) {
			return false;
		}
		
		try {
			DataMapper dm = (DataMapper) Class.forName(
					"dataMapper."+obj.getClass().getSimpleName()+"Mapper").newInstance();
			ImplicitMapper im = new ImplicitMapper(
					dm, sessionId, obj.getClass().getSimpleName());
			im.delete(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	return true;
}
	
}
