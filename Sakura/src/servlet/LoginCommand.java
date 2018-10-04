package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import domain.Customer;
import service.CustomerService;

public class LoginCommand extends FrontCommand {

	//private static String[] = ['1'];
	
	@Override
	public void process() throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String role = request.getParameter("role");
		

		/*
		 * HERE we pretend user already logged in as a customer.
		 */
		CustomerService cs = new CustomerService();
		Customer c = new Customer();
		c.setCustomerId(1);
		Customer customer = cs.findCustomer(c).get(0);
		session.setAttribute("loggedUser", customer);
		
		forward("/index.jsp");
		
	}
}
