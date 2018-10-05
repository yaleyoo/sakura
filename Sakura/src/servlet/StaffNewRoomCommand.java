package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Building;
import domain.Room;
import service.RoomService;

public class StaffNewRoomCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String price = request.getParameter("price");
		String buildingId = request.getParameter("buildingId");
		
		Room room = new Room();
		room.setName(name);
		room.setPrice(Float.parseFloat(price));
		room.setType(type);
		Building building = new Building();
		building.setBuildingId(Integer.parseInt(buildingId));
		room.setBuilding(building);
		
		RoomService rs = new RoomService();
		boolean result = rs.insertRoom(room, request.getSession().getId());
		if (result) {
			request.setAttribute("successReason", "create the room!");
			forward("/jsp/staff/staffSuccess.jsp");
		}
		else {
			request.getSession().setAttribute("errorMsg", 
					"Something going wrong when delete the room, please try again later.");
			forward("/jsp/staff/staffError.jsp");
		}
	}

}
