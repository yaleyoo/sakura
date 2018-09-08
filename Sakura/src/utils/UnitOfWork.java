package utils;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import dataMapper.*;
import domain.*;

public class UnitOfWork {
	private static ThreadLocal current = new ThreadLocal();
	
	private List<DomainObject> newObjects = new ArrayList<DomainObject>();
	private List<DomainObject> dirtyObjects = new ArrayList<DomainObject>();
	private List<DomainObject> deletedObjects = new ArrayList<DomainObject>();
	

public static void newCurrent() { 
	setCurrent(new UnitOfWork());
}

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

public boolean commit()  {
	boolean addResult = true;
	boolean updateResult = true;
	boolean deleteResult = true;
	//deal with new objects
	for(DomainObject obj: newObjects) {
		if(!addResult) {
			return false;
		}
		switch(obj.getClass().getSimpleName()) {			
			case "BookedRoom":
				BookedRoomMapper brm = new BookedRoomMapper();
				addResult = brm.insertBookedRoom((BookedRoom)obj);
				break;
			case "Building":
				BuildingMapper bm = new BuildingMapper();
				addResult = bm.insertBuilding((Building)obj);
				break;
			case "Customer":
				CustomerMapper cm = new CustomerMapper();
				addResult = cm.insertCustomer((Customer)obj);
				break;
			case "Order":
				OrderMapper om = new OrderMapper();
				addResult = om.insertOrder((Order)obj);
				break;
			case "Room":
				RoomMapper rm = new RoomMapper();
				addResult = rm.insertRoom((Room)obj);
				break;
		}		
	}
	
	//deal with dirty objects
	for(DomainObject obj: dirtyObjects) {
		if(!updateResult) {
			return false;
		}
		switch(obj.getClass().getSimpleName()) {			
		case "BookedRoom":
			BookedRoomMapper brm = new BookedRoomMapper();
			updateResult = brm.updateBookedRoom((BookedRoom)obj);
			break;
		case "Building":
			BuildingMapper bm = new BuildingMapper();
			updateResult = bm.updateBuilding((Building)obj);
			break;
		case "Customer":
			CustomerMapper cm = new CustomerMapper();
			updateResult = cm.updateCustomer((Customer)obj);
			break;
		case "Order":
			OrderMapper om = new OrderMapper();
			updateResult = om.updateOrder((Order)obj);
			break;
		case "Room":
			RoomMapper rm = new RoomMapper();
			updateResult = rm.updateRoom((Room)obj);
			break;
		}
	}
	
	//deal with deleted objects
	for(DomainObject obj: deletedObjects) {
		if(!deleteResult) {
			return false;
		}
		switch(obj.getClass().getSimpleName()) {			
		case "BookedRoom":
			BookedRoomMapper brm = new BookedRoomMapper();
			deleteResult = brm.deleteBookedRoom((BookedRoom)obj);
			break;
		case "Building":
			BuildingMapper bm = new BuildingMapper();
			deleteResult = bm.deleteBuilding((Building)obj);
			break;
		case "Customer":
			CustomerMapper cm = new CustomerMapper();
			deleteResult = cm.deleteCustomer((Customer)obj);
			break;
		case "Order":
			OrderMapper om = new OrderMapper();
			deleteResult = om.deleteOrder((Order)obj);
			break;
		case "Room":
			RoomMapper rm = new RoomMapper();
			deleteResult = rm.deleteRoom((Room)obj);
			break;
		}
	}
	
	return true;
}
	
}
