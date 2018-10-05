package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import domain.Building;
import domain.Room;
import service.BuildingService;
import service.RoomService;

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
			forward("/jsp/staff/staffEditBuilding.jsp");
		}
		else if (method.equals("checkRooms")) {
			String buildingId = request.getParameter("buildingId");
			Building building = new Building();
			building.setBuildingId(Integer.parseInt(buildingId));
			Room room = new Room();
			room.setBuilding(building);
			RoomService rs = new RoomService();
			List<Room> rooms = rs.findRoomByBuildingId(room);
			request.setAttribute("rooms", rooms);
			request.setAttribute("buildingId", buildingId);
			
			forward("/jsp/staff/staffRooms.jsp");
		}
		else if (method.equals("delete")) {
			String sessionId = request.getSession().getId();
			String buildingId = request.getParameter("buildingId");
			Building building = new Building();
			building.setBuildingId(Integer.parseInt(buildingId));
			BuildingService bs = new BuildingService();
			
			boolean result = bs.deleteBuilding(building, sessionId);
			if (result) {
				forward("/jsp/staff/staffBuildings.jsp");
			}
			else {
				request.getSession().setAttribute("errorMsg", 
						"Something going wrong when delete the building, please try again later.");
				forward("/jsp/staff/staffError.jsp");
			}
		}
		else if (method.equals("newBuilding")) {
			forward("/jsp/staff/staffNewBuilding.jsp");
		}
		else {
			request.getSession().setAttribute("errorMsg", "Invalid method.");
			forward("/jsp/error.jsp");
		}
		
	}

}
