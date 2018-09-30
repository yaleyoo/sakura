package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import domain.Order;
import service.OrderService;

public class PlaceOrderCommand extends FrontCommand{
	

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	@Override
	public void process() throws ServletException, IOException {
		//fetch parameter
		long orderId = Long.parseLong(request.getParameter("order_id"));
		Order order = new Order();
		order.setOrderId(orderId);
		
		//search identity map first
		utils.IdentityMap<Order> identityMap = utils.IdentityMap.getInstance(order);
		Order order_inMap = identityMap.get(order.getOrderId());
		//if order not found
		if (order_inMap == null) {
			forward("/jsp/error.jsp");
		}
		else {
			order = order_inMap;
		}
		// insert order
		OrderService os = new OrderService();
		boolean result = os.insertOrder(order);
		
		if (result)
			forward("/jsp/successOrder.jsp");
		else
			forward("/jsp/error.jsp");
		
	}
}
