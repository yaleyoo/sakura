package domain;

public class BuildingAssembler {
	public BuildingDTO writeDTO(Building building) {
		BuildingDTO result = new BuildingDTO();
		result.setAddress(building.getAddress());
		result.setBuildingId(building.getBuildingId());
		result.setBuildingName(building.getBuildingName());
		
		return result;
	}
}
