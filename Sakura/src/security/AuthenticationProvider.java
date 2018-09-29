package security;

import java.util.HashMap;
import java.util.Map;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;

public class AuthenticationProvider {
	@SuppressWarnings("rawtypes")
	public static Map<String, Class[]> pemission = new HashMap<String, Class[]>();
	
	@SuppressWarnings("rawtypes")
	public AuthenticationProvider() {
		Class[] cancel = {Customer.class};
		pemission.put("CancelOrder", cancel);
		Class[] check = {Customer.class};
		pemission.put("CheckOrder", check);
		Class[] getAvailable = {Customer.class, Manager.class, Receptionist.class};
		pemission.put("GetAvailableRooms", getAvailable);
		Class[] homePage = {Customer.class, Manager.class, Receptionist.class, null};
		pemission.put("HomePage", value)
	}
}
