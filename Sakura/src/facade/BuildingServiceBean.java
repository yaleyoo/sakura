package facade;

import dataMapper.BuildingMapper;
import domain.Building;
import domain.BuildingAssembler;
import domain.BuildingDTO;

public class BuildingServiceBean {
	
	public BuildingDTO getBuilding(int id) {
		Building building = new Building();
		building.setBuildingId(id);
		
		return new BuildingAssembler().writeDTO(
				new BuildingMapper().findBuildingById(building).get(0));
	}
	
	public String getBuildingString(int id) {
		 return getBuilding(id).toString();
	}
}
