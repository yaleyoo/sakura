package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import service.CustomerService;
import service.OrderService;
import service.RoomService;
import utils.Parameters;

public class OrderServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
		 * HERE we pretend user already logged in as a customer.
		 */
		CustomerService cs = new CustomerService();
		Customer c = new Customer();
		c.setCustomerId(1);
		Customer customer = cs.findCustomer(c).get(0);
		session.setAttribute("loggedCustomer", customer);
		
		// verify user's identity. 
		if (session.getAttribute("loggedCustomer") != null) {
			// get request parameters
			int roomId = Integer.parseInt(request.getParameter("room_id"));
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
			// generate order
			RoomService rs = new RoomService();
			Order order = new Order();
			Customer logged = (Customer)session.getAttribute("loggedCustomer");
			order.setCreateTime(new Date());
			order.setCustomer(logged);
			Room room = new Room();
			room.setRoomId(roomId);
			order.setRoom(rs.findRoomById(room).get(0));
			order.setStatus(Parameters.BOOKING);
			TimeRange range = new TimeRange();
			range.setCheckInTime(checkInTime);
			range.setCheckOutTime(checkOutTime);
			order.setTimerange(range);
			
			int days = checkOutTime.getDate() - checkInTime.getDate();
			if (days < 0) {
				// end date earlier than start date. INVALID.
				response.getWriter().write("Verification Neccessary");
				return;
			}
			else if (days == 0)
				days = 0;
			float sum = days * order.getRoom().getPrice();
			order.setSum(sum);
			
			// insert order
			OrderService os = new OrderService();
			boolean result = os.insertOrder(order);
			
			if (result)
				request.getRequestDispatcher("/jsp/successOrder.jsp").forward(request, response);
			else
				request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		}
		else {
			// TODO: would redirect user to an error page
			response.getWriter().write("Verification Neccessary");
		}
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
