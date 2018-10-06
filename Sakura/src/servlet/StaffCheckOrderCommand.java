package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Customer;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import service.RoomService;
import utils.DateValidator;
import utils.OrderIdGenerator;
import utils.Parameters;

public class StaffCheckOrderCommand extends FrontCommand{
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	@Override
	public void process() throws ServletException, IOException {
		// Fetch customer Id
		int customerId = Integer.parseInt(request.getParameter("customer_id"));
		Customer customer = new Customer();
		customer.setCustomerId(customerId);
		
		// Check if the customer is selected
		utils.IdentityMap<Customer> identityMap = utils.IdentityMap.getInstance(customer);
		Customer customer_inMap = identityMap.get(customerId);
		// If customer not found
	    if (customer_inMap == null) {
			request.setAttribute("errorMsg", 
					"Customer is not choosen, please try agin.");
			forward("/jsp/staff/staffError.jsp");
		} else {
			customer = customer_inMap;
		}

		// get request parameters
		int roomId = Integer.parseInt(request.getParameter("room_id"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
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
		Customer logged = customer;
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

		if (!DateValidator.validateCheckInOutDate(checkInTime, checkOutTime)) {
			// end date earlier than start date. INVALID.
			request.setAttribute("errorMsg",
					"Invalid date, check out date earlier than check in date.");
			forward("/jsp/staff/staffError.jsp");
			return;
		}
		int days = DateValidator.calculateDateGap(checkInTime, checkOutTime);
		float sum = days * order.getRoom().getPrice();
		order.setSum(sum);

		// put order into identity map
		utils.IdentityMap<Order> orderIdentityMap = utils.IdentityMap.getInstance(order);
		orderIdentityMap.put(order.getOrderId(), order);

		// response client with order details
		request.setAttribute("order", order);
		forward("/jsp/staff/staffCheckOrder.jsp");
		
	}
}
