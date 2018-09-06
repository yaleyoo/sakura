package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Room;
import net.sf.json.JSONObject;
import service.RoomService;

@WebServlet("/getAvailableRooms")
public class GetAvailableRoomsServlet extends HttpServlet{
	private RoomService rs;
	
	public GetAvailableRoomsServlet() {
		super();
		rs = new RoomService();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Date checkInTime = (Date)request.getAttribute("checkInTime");
		Date checkOutTime = (Date)request.getAttribute("checkOutTime");
		int buildingId = (Integer)request.getAttribute("building");
	
		//response json for partially update
		response.setContentType("application/json; charset=utf-8");
		JSONObject json = new JSONObject();
		json.put("result", rs.findAvailableRooms(checkInTime, checkOutTime, buildingId));
		response.getWriter().write(json.toString());;
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
