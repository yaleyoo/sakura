package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import domain.Building;
import service.BuildingService;
import service.RoomService;

public class ViewRoomsCommand extends FrontCommand{

	BuildingService bs;
	RoomService rs;	

	@Override
	public void process() throws ServletException, IOException {
		bs = new BuildingService();
		rs = new RoomService();
		List<Building> buildings = bs.getAllBuildings();
		request.setAttribute("buildings", buildings);
		request.setAttribute("rooms", rs.findAllRooms());
		forward("/jsp/rooms.jsp");		
	}
}
