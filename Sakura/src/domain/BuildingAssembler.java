package domain;

public class BuildingAssembler {
	
	/**
	 * write a buildingDTO based on a building object
	 * @param building
	 * @return
	 */
	public BuildingDTO writeDTO(Building building) {
		BuildingDTO result = new BuildingDTO();
		result.setAddress(building.getAddress());
		result.setBuildingId(building.getBuildingId());
		result.setBuildingName(building.getBuildingName());
		
		return result;
	}
}
