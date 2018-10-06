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



public class StaffSearchCustomerCommand extends FrontCommand{
	
	private CustomerService cs;

	@Override
	public void process() throws ServletException, IOException {
		
		String email = request.getParameter("email");

		
		// Check if customer's information is valid
		
		if(email == "") {
			request.setAttribute("errorMsg",
					"Please make sure you fill the email in the search input");
			forward("/jsp/error.jsp");
			return;
		}
		Customer customer = new Customer();
		customer.setEmail(email);
		cs = new CustomerService();
		
		
		//get customer id so that the customer can be put into identity map
		Customer newCustomer = cs.findCustomerByEmail(customer).get(0);
		
		// Put order into identity map
		utils.IdentityMap<Customer> identityMap = utils.IdentityMap.getInstance(customer);
		identityMap.put(newCustomer.getCustomerId(), newCustomer);
				
		// Response client with successful information
		response.setContentType("application/json; charset=utf-8");
		JSONObject json = new JSONObject();
		json.put("customer", newCustomer);
		
		response.getWriter().write(json.toString());
	}
}
