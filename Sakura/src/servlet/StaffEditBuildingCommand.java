package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Building;
import service.BuildingService;

public class StaffEditBuildingCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		String buildingId = request.getParameter("buildingId");
		String buildingName = request.getParameter("buildingName");
		String address = request.getParameter("address");
		
		Building building = new Building();
		building.setAddress(address);
		building.setBuildingId(Integer.parseInt(buildingId));
		building.setBuildingName(buildingName);
		BuildingService bs = new BuildingService();
		boolean result = bs.updateBuilding(building, request.getSession().getId());
		if (result) {
			redirect("frontServlet?command=StaffBuildings");
		}
		else {
			request.setAttribute("errorMsg", 
					"something wrong happened when update building.");
		}
	}

}
