package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.BuildingMapper;
import dataMapper.RoomMapper;
import domain.Building;
import domain.Room;
import utils.UnitOfWork;

public class BuildingService {
	BuildingMapper bm;
	public BuildingService() {
		bm = new BuildingMapper();
	}
	
	public List<Building> getAllBuildings(){
		return bm.findAllBuilding();
	}
	
	public List<Building> getBuildingById(Building building){
		utils.IdentityMap<Building> identityMap = utils.IdentityMap.getInstance(building);
		Building building_inMap = identityMap.get(building.getBuildingId());
		if (building_inMap != null) {
			List<Building> result = new ArrayList<Building>();
			result.add(building_inMap);
			
			return result;
		}
		return bm.findBuildingById(building);
	}
	
	public boolean updateBuilding(Building building, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(building);
		
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	public boolean deleteBuilding(Building building, String sessionId) {
		RoomMapper rm = new RoomMapper();
		//find rooms in that building
		Room room = new Room();
		room.setBuilding(building);
		List<Room> roomList = rm.findRoomByBuildingId(room);
		
		UnitOfWork.newCurrent();
		//register to delete rooms in that building
		for (Room r:roomList) {
			UnitOfWork.getCurrent().registerDeleted(r);
		}
		//register to delete building
		UnitOfWork.getCurrent().registerDeleted(building);
		
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	public boolean insertBuilding(Building building, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(building);
		
		return UnitOfWork.getCurrent().commit(sessionId);
	}
}
