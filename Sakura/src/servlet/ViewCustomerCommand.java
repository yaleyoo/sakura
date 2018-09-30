package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Order;
import service.OrderService;

public class ViewCustomerCommand extends FrontCommand{

	private OrderService os;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public void process() throws ServletException, IOException {
		os = new OrderService();
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("loggedUser");
		session.setAttribute("loggedUser", customer);
		
		// verify user's identity. 
		if (session.getAttribute("loggedUser") != null) {
			Order o = new Order();
			o.setCustomer(customer);
			request.setAttribute("orders", os.findOrder(o));
			forward("/jsp/customerOrders.jsp");
		}
		else {			
			response.getWriter().write("Verification Neccessary");
			forward("/jsp/error.jsp");
		}
		
	}
}
