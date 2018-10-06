package servlet;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;

import domain.Customer;
import domain.Order;
import net.sf.json.JSONObject;
import service.CustomerService;
import service.OrderService;
import utils.DateValidator;



public class StaffPlaceOrderCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		//fetch parameter
		long orderId = Long.parseLong(request.getParameter("order_id"));
		Order order = new Order();
		order.setOrderId(orderId);
		
		//search identity map first
		utils.IdentityMap<Order> orderIdentityMap = utils.IdentityMap.getInstance(order);
		Order order_inMap = orderIdentityMap.get(order.getOrderId());
		//if order not found
		if (order_inMap == null) {
			request.setAttribute("errorMsg", 
					"Order is not found, please try agin.");
			forward("/jsp/staff/staffError.jsp");
		}
		else {
			order = order_inMap;
		}
		// insert order
		OrderService os = new OrderService();
		boolean result = os.validateOrder(order, request.getSession().getId());
		
		if (result)
			forward("/jsp/staff/staffSuccess.jsp");
		else {
			request.setAttribute("errorMsg",
					"Something wrong happened (e.g. this room has been taken), please try agin later.");
			forward("/jsp/staff/staffError.jsp");
		}    
		
	}
}
