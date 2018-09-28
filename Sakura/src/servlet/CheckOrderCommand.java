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
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import service.CustomerService;
import service.RoomService;
import utils.OrderIdGenerator;
import utils.Parameters;

public class CheckOrderCommand extends FrontCommand{
	


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
	

	@Override
	public void process() throws ServletException, IOException {
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
			order.setOrderId(OrderIdGenerator.getOrderId(customer));
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
			
			//put order into identity map
			utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(order);
			identityMap.put(order.getOrderId(), order);
			
			// response client with order details
			request.setAttribute("order", order);
			forward("/jsp/checkOrder.jsp");
		}
		else {
			
			response.getWriter().write("Verification Neccessary");
			forward("/jsp/error.jsp");
		}
		
	}
}
