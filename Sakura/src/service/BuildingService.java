package service;

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
}
