package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.Customer;
import service.CustomerService;

public class AuthenticationEnforcer {

	public static boolean checkAuthentication(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("loggedUser");
		
		// if haven't logged in, check authorisation
		if (user == null) {
			return AuthorisationEnforcer.checkAuthorisation(request);
		}
		
		if (user.getClass() == Customer.class) {
			CustomerService cs = new CustomerService();
			// if is already validated list
			if (UserStore.authenticatedCustomer.contains(user)) {
				return true;
			}
			// if not in validated list, check the authentication in DB
			if (cs.findCustomer((Customer) user).size() == 1) {
				UserStore.authenticatedCustomer.add((Customer) user);
				
				// if pass the authentication check, check the authorization
				return AuthorisationEnforcer.checkAuthorisation(request);
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}
}
