package security;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;
import domain.Staff;
import service.CustomerService;
import service.StaffService;

/**
 * A class for authentication check
 * @author steve
 *
 */
public class AuthenticationEnforcer {

	/**
	 * check authentication based on the attribute 'loggedUser' saved in session
	 * @param request
	 * @return
	 */
	public static boolean checkAuthentication(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Object user = session.getAttribute("loggedUser");
		// if haven't logged in, check authorisation, some actions doesn't required login
		if (user == null) {
			return AuthorisationEnforcer.checkAuthorisation(request);
		}
		
		// check customer's authentication
		if (user.getClass() == Customer.class) {
			CustomerService cs = new CustomerService();
			// if is already validated list
			if (UserStore.authenticatedCustomer.contains(user)) {
				return AuthorisationEnforcer.checkAuthorisation(request);
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
		
		// check Manager's authentication authentication
		else if (user.getClass() == Manager.class) {
			StaffService ss = new StaffService();
			// if is already validated list
			if (UserStore.authenticatedManager.contains(user)) {
				return AuthorisationEnforcer.checkAuthorisation(request);
			}
			// if not in validated list, check the authentication in DB
			List<Staff> staffList = ss.findStaff((Staff)user);
			if (staffList.size() == 1) {
				UserStore.authenticatedManager.add((Manager) user);
				
				// if pass the authentication check, check the authorization
				return AuthorisationEnforcer.checkAuthorisation(request);
			}
			else {
				return false;
			}
		}
		
		// check Receptionist's authentication authentication
		else if (user.getClass() == Receptionist.class) {
			StaffService ss = new StaffService();
			// if is already validated list
			if (UserStore.authenticatedReceptionist.contains(user)) {
				return AuthorisationEnforcer.checkAuthorisation(request);
			}
			// if not in validated list, check the authentication in DB
			List<Staff> staffList = ss.findStaff((Staff)user);
			if (staffList.size() == 1) {
				UserStore.authenticatedReceptionist.add((Receptionist) user);
				
				// if pass the authentication check, check the authorization
				return AuthorisationEnforcer.checkAuthorisation(request);
			}
			else {
				return false;
			}
		}
		
		// if the data saved in session doesn't match any of those class, return false
		else {
			return false;
		}
	}
}
