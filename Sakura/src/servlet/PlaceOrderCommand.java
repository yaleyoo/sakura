package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Order;
import service.CustomerService;
import service.OrderService;

public class PlaceOrderCommand extends FrontCommand{
	

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
		else {
			forward("/jsp/error.jsp");
		}
		
	}
}
