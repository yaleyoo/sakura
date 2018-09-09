package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.BuildingMapper;
import domain.Building;

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
}
