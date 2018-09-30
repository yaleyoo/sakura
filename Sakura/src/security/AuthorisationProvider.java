package security;

import java.util.HashMap;
import java.util.Map;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;

@SuppressWarnings("rawtypes")
public class AuthorisationProvider {
	public static Map<String, Class[]> pemission = new HashMap<String, Class[]>();
	
	static {
		Class[] cancelOrder = {Customer.class, Manager.class, Receptionist.class};
		pemission.put("CancelOrder", cancelOrder);
		Class[] checkOrder = {Customer.class, Manager.class, Receptionist.class};
		pemission.put("CheckOrder", checkOrder);
		Class[] getAvailableRooms = null;
		pemission.put("GetAvailableRooms", getAvailableRooms);
		Class[] homePage = null;
		pemission.put("HomePage", homePage);
		Class[] login = null;
		pemission.put("Login", login);
		Class[] placeOrder = {Customer.class, Manager.class, Receptionist.class};
		pemission.put("PlaceOrder", placeOrder);
		Class[] viewCustomer = {Customer.class, Manager.class, Receptionist.class};
		pemission.put("ViewCustomer", viewCustomer);
		Class[] viewRooms = null;
		pemission.put("ViewRooms", viewRooms);
	}
	
	public static boolean checkAuthorisation(String command, Object user) {
		Class userClass = null;
		if (user != null)
			userClass = user.getClass();
		
		// if the command is invalid
		if (!pemission.containsKey(command)) {
			return false;
		}
		Class[] pemissionList = pemission.get(command);
		// no authentication necessary
		if (pemissionList == null) {
			return true;
		}
		else {
			for (int i=0; i<pemissionList.length; i++) {
				// if user is authenticated
				if (pemissionList[i] == userClass) {
					return true;
				}
			}
			return false;
		}
	}
}
