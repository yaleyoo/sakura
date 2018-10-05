package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

import domain.Room;
import service.RoomService;

public class StaffManageRoomCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		String method = request.getParameter("method");
		
		if (method.equals("create")) {
			String buildingId = request.getParameter("buildingId");
			request.setAttribute("buildingId", buildingId);
			forward("/jsp/staff/staffCreateRoom.jsp");
		}
		else if (method.equals("edit")) {
			String roomIdString = request.getParameter("roomId");
			Room room = new Room();
			room.setRoomId(Integer.parseInt(roomIdString));
			RoomService rs = new RoomService();
			room = rs.findRoomById(room).get(0);
			
			request.setAttribute("room", room);
			forward("/jsp/staff/staffEditRoom.jsp");
		}
		else if (method.equals("delete")) {
			String roomIdString = request.getParameter("roomId");
			Room room = new Room();
			room.setRoomId(Integer.parseInt(roomIdString));
			
			RoomService rs = new RoomService();
			boolean result = rs.deleteRoom(room, request.getSession().getId());
			if (result) {
				request.setAttribute("successReason", "delete the room.");
				forward("/jsp/staff/staffSuccess.jsp");
			}
			else {
				request.setAttribute("errorMsg", 
						"Something going wrong when deleteing the room, please try again later.");
				forward("/jsp/staff/staffError.jsp");
			}
		}
		else {
			request.setAttribute("errorMsg", "invalid method.");
			forward("/jsp/staff/staffError.jsp");
		}
	}

}
