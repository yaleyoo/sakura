package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import domain.Order;
import service.OrderService;
import utils.DateValidator;



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
		if (DateValidator.calculateDateGap(
				order.getTimerange().getCheckInTime(), now) < 2) {
			result = false;
		}
		if (!result) {
			forward("/jsp/error.jsp");
			return;
		}
		result = os.cancelOrder(order, request.getSession().getId());
		
		if (result)
			forward("/jsp/successOrder.jsp");
		else
			forward("/jsp/error.jsp");
	}
}
