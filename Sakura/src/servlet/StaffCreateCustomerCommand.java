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



public class StaffCreateCustomerCommand extends FrontCommand{
	
	private CustomerService cs;

	@Override
	public void process() throws ServletException, IOException {
		
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String title = request.getParameter("title");
		String identityType = request.getParameter("identity_type");
		String identityNumber = request.getParameter("identity_number");
		String mobileNumber = request.getParameter("mobile_number");
		
		// Check if customer's information is valid
		
		if(firstName == "" || lastName == "" || email == ""
				|| identityType == "" || identityNumber == "") {
			request.setAttribute("errorMsg",
					"Please make sure you fill all the inputs in the form");
			forward("/jsp/error.jsp");
			return;
		}
		
		cs = new CustomerService();
	
		Customer customer = new Customer(firstName, lastName, title, 
				identityNumber, identityType, email, mobileNumber);
		
		// Insert new customer into database
		cs.insertCustomer(customer, request.getSession().getId());
		
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
