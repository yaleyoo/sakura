package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BuildingService;
import service.RoomService;

@WebServlet("/viewRooms")
public class ViewRoomsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BuildingService bs;
	RoomService rs;
	public ViewRoomsServlet() {
		super();
		bs = new BuildingService();
		rs = new RoomService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("buildings", bs.getAllBuildings());
		request.setAttribute("rooms", rs.findAllRooms());
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
