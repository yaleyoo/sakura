package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Order;
import domain.Room;
import domain.TimeRange;
import service.RoomService;
import utils.DateValidator;
import utils.OrderIdGenerator;
import utils.Parameters;

public class CheckOrderCommand extends FrontCommand {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	public void process() throws ServletException, IOException {
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("loggedUser");

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
			request.getSession().setAttribute("errorMsg",
					"Invalid date, check out date earlier than check in date.");
			forward("/jsp/error.jsp");
			return;
		}
		int days = DateValidator.calculateDateGap(checkInTime, checkOutTime);
		float sum = days * order.getRoom().getPrice();
		order.setSum(sum);

		// put order into identity map
		utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(order);
		identityMap.put(order.getOrderId(), order);

		// response client with order details
		request.setAttribute("order", order);
		forward("/jsp/checkOrder.jsp");

	}
}
