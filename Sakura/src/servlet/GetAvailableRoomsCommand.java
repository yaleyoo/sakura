package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import service.RoomService;

public class GetAvailableRoomsCommand extends FrontCommand{

	private RoomService rs;
	
	@Override
	public void process() throws ServletException, IOException {
		rs = new RoomService();
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Date checkInTime = null;
		Date checkOutTime = null;
		try {
			checkInTime = sdf.parse(request.getParameter("check_in_time"));
			checkOutTime = sdf.parse(request.getParameter("check_out_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int buildingId = Integer.parseInt(request.getParameter("building_id"));
	
		//response json for partially update
		response.setContentType("application/json; charset=utf-8");
		JSONObject json = new JSONObject();
		json.put("result", rs.findAvailableRooms(checkInTime, checkOutTime, buildingId));
		
		response.getWriter().write(json.toString());
		
	}
}
