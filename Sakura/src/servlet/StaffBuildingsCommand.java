package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import domain.Building;
import service.BuildingService;

public class StaffBuildingsCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		
		BuildingService bs = new BuildingService();
		List<Building> buildingList = bs.getAllBuildings();
		request.setAttribute("buildings", buildingList);
		forward("/jsp/staff/staffBuildings.jsp");
	}

}
