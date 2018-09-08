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

public void commit()  {
	//deal with new objects
	for(DomainObject obj: newObjects) {
		switch(obj.getClass().getSimpleName()) {			
			case "BookedRoom":
				BookedRoomMapper brm = new BookedRoomMapper();
				brm.insertBookedRoom((BookedRoom)obj);
				break;
			case "Building":
				BuildingMapper bm = new BuildingMapper();
				bm.insertBuilding((Building)obj);
				break;
			case "Customer":
				CustomerMapper cm = new CustomerMapper();
				cm.insertCustomer((Customer)obj);
				break;
			case "Order":
				OrderMapper om = new OrderMapper();
				om.insertOrder((Order)obj);
				break;
			case "Room":
				RoomMapper rm = new RoomMapper();
				rm.insertRoom((Room)obj);
				break;
		}		
	}
	
	//deal with dirty objects
	for(DomainObject obj: dirtyObjects) {
		switch(obj.getClass().getSimpleName()) {			
		case "BookedRoom":
			BookedRoomMapper brm = new BookedRoomMapper();
			brm.updateBookedRoom((BookedRoom)obj);
			break;
		case "Building":
			BuildingMapper bm = new BuildingMapper();
			bm.updateBuilding((Building)obj);
			break;
		case "Customer":
			CustomerMapper cm = new CustomerMapper();
			cm.updateCustomer((Customer)obj);
			break;
		case "Order":
			OrderMapper om = new OrderMapper();
			om.updateOrder((Order)obj);
			break;
		case "Room":
			RoomMapper rm = new RoomMapper();
			rm.updateRoom((Room)obj);
			break;
		}
	}
	
	//deal with deleted objects
	for(DomainObject obj: deletedObjects) {
		switch(obj.getClass().getSimpleName()) {			
		case "BookedRoom":
			BookedRoomMapper brm = new BookedRoomMapper();
			brm.deleteBookedRoom((BookedRoom)obj);
			break;
		case "Building":
			BuildingMapper bm = new BuildingMapper();
			bm.deleteBuilding((Building)obj);
			break;
		case "Customer":
			CustomerMapper cm = new CustomerMapper();
			cm.deleteCustomer((Customer)obj);
			break;
		case "Order":
			OrderMapper om = new OrderMapper();
			om.deleteOrder((Order)obj);
			break;
		case "Room":
			RoomMapper rm = new RoomMapper();
			rm.deleteRoom((Room)obj);
			break;
		}
	}
}
	
}
