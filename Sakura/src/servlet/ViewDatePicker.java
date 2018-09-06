package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BuildingService;
import service.RoomService;

@WebServlet("/viewDatePicker")
public class ViewDatePicker extends HttpServlet{
	BuildingService bs;
	public ViewDatePicker() {
		super();
		bs = new BuildingService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("buildings", bs.getAllBuildings());
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
