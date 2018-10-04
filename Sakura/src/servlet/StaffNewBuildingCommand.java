package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Building;
import service.BuildingService;

public class StaffNewBuildingCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		String buildingName = request.getParameter("buildingName");
		String address = request.getParameter("address");
		
		Building building = new Building();
		building.setAddress(address);
		building.setBuildingName(buildingName);
		
		BuildingService bs= new BuildingService();
		boolean result = bs.insertBuilding(building, request.getSession().getId());
		
		if (result) {
			redirect("frontServlet?command=StaffBuildings");
		}
		else {
			request.getSession().setAttribute("errorMsg", 
					"something wrong happened when insert building.");
		}
	}

}
