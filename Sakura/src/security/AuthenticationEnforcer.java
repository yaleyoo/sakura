package security;

import javax.servlet.http.HttpSession;

import domain.Customer;
import service.CustomerService;

public class AuthenticationEnforcer {

	public static boolean authenticateCustomer(HttpSession session) {
		Customer customer = (Customer)session.getAttribute("loggedCustomer");
		CustomerService cs = new CustomerService();
		// if is already validated list
		if (UserStore.authenticatedCustomer.contains(customer)) {
			return true;
		}
		// if not in validated list, check the authentication in DB
		if (cs.findCustomer(customer).size() == 1) {
			UserStore.authenticatedCustomer.add(customer);
			return true;
		}
		else {
			return false;
		}
	}
}
