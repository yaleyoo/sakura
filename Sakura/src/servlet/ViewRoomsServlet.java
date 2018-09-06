package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Room;
import service.RoomService;

@WebServlet("/viewRooms")
public class ViewRoomsServlet extends HttpServlet{
	private RoomService rs;
	
	public ViewRoomsServlet() {
		super();
		rs = new RoomService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date checkInTime = (Date)request.getAttribute("checkInTime");
		Date checkOutTime = (Date)request.getAttribute("checkOutTime");
		int buildingId = (Integer)request.getAttribute("building");
		
		request.setAttribute("rooms", rs.findAvailableRooms(checkInTime, checkOutTime, buildingId));
		request.getRequestDispatcher("/jsp/rooms.jsp").forward(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void init() throws ServletException {
	}
	public void destroy() {
		super.destroy(); 
	}
}
