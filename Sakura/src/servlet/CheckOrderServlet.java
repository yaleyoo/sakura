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

@WebServlet("/checkOrder")
public class CheckOrderServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		/*
		 * HERE we pretend user already logged in as customer.
		 */
		CustomerService cs = new CustomerService();
		Customer c = new Customer();
		c.setCustomerId(1);
		Customer customer = cs.findCustomer(c).get(0);
		session.setAttribute("loggedCustomer", customer);
		
		// verify user's identity. 
		if (session.getAttribute("loggedCustomer") != null) {
			Order order = new Order();
			Customer logged = (Customer)session.getAttribute("loggedCustomer");
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
