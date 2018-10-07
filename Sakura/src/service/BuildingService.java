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
	
	/**
	 * find all buildings
	 * @return a list of building objects
	 */
	public List<Building> getAllBuildings(){
		return bm.findAllBuilding();
	}
	
	/**
	 * find building by buildingId, it would search the identity map first,
	 * if not in identity map, search database
	 * @param building
	 * @return a list of building objects
	 */
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

	/**
	 * update building information
	 * @param building - a updated building object which need to be wrote into db
	 * @param sessionId -  the id for the session who performs this update
	 * @return
	 */
	public boolean updateBuilding(Building building, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(building);
		
		return UnitOfWork.getCurrent().commit(sessionId);
	}
	
	/**
	 * delete building information
	 * @param building - a building object which need to be deleted from db
	 * @param sessionId -  the id for the session who performs this delete
	 * @return
	 */
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
	
	/**
	 * insert building information
	 * @param building - a building object which need to be inserted into db
	 * @param sessionId -  the id for the session who performs this insert
	 * @return
	 */
	public boolean insertBuilding(Building building, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(building);
		
		return UnitOfWork.getCurrent().commit(sessionId);
	}
}
