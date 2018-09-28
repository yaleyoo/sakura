package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Building;
import service.BuildingService;
import service.RoomService;

public class ViewRoomsCommand extends FrontCommand{

	BuildingService bs;
	RoomService rs;	

	@Override
	public void process() throws ServletException, IOException {
		System.out.println("ViewRoomsCommand process");
		bs = new BuildingService();
		rs = new RoomService();
		List<Building> buildings = bs.getAllBuildings();
		request.setAttribute("buildings", buildings);
		request.setAttribute("rooms", rs.findAllRooms());
		forward("/jsp/rooms.jsp");		
	}
}
