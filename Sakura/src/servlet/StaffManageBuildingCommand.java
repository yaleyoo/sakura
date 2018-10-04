package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Building;
import service.BuildingService;

public class StaffManageBuildingCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if (method.equals("edit")) {
			BuildingService bs = new BuildingService();
			String buildingId = request.getParameter("buildingId");
			Building building = new Building();
			building.setBuildingId(Integer.parseInt(buildingId));
			building = bs.getBuildingById(building).get(0);
			
			request.setAttribute("building", building);
			forward("/jsp/staffManageBuilding.jsp");
		}
		
	}

}
