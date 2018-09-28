package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Order;
import service.OrderService;



public class CancelOrderCommand extends FrontCommand{

	private OrderService os;

	@Override
	public void process() throws ServletException, IOException {
		os = new OrderService();
		long orderId = Long.parseLong(request.getParameter("order_id"));
		Order order = new Order();
		order.setOrderId(orderId);
		order = os.findOrder(order).get(0);
		boolean result = true;
		
		// can only cancel order in 2 days before the check in date.
		Date now = new Date();
		System.out.println(order.getTimerange().getCheckInTime().getTime() - now.getTime());
		//TODO: still wrong
		if (order.getTimerange().getCheckInTime().getTime() - now.getTime() < 2*24*60) {
			result = false;
		}
		if (!result) {
			forward("/jsp/error.jsp");
			return;
		}
		result = os.cancelOrder(order);
		
		if (result)
			forward("/jsp/successOrder.jsp");
		else
			forward("/jsp/error.jsp");
	}
}
