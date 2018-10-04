package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

public class StaffNewBuildingCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		String buildingName = request.getParameter("buildingName");
		String address = request.getParameter("address");
		System.out.println(buildingName+address);
	}

}
