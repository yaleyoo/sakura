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
		Class[] logout = null;
		pemission.put("LogOut", logout);
		Class[] staffIndex = null;
		pemission.put("StaffIndex", staffIndex);
		Class[] staffChooseCustomer = {Manager.class, Receptionist.class};
		pemission.put("staffChooseCustomer", staffChooseCustomer);
		Class[] staffCreateCustomer = {Manager.class, Receptionist.class};
		pemission.put("staffCreateCustomer", staffCreateCustomer);
		Class[] staffSearchCustomer = {Manager.class, Receptionist.class};
		pemission.put("staffSearchCustomer", staffSearchCustomer);
		Class[] staffViewPlaceOrder = {Manager.class, Receptionist.class};
		pemission.put("staffViewPlaceOrder", staffViewPlaceOrder);
		Class[] staffPlaceOrder = {Manager.class, Receptionist.class};
		pemission.put("staffPlaceOrder", staffPlaceOrder);
		Class[] staffCheckOrder = {Manager.class, Receptionist.class};
		pemission.put("staffCheckOrder", staffCheckOrder);
		Class[] staffBuilding = {Manager.class};
		pemission.put("staffBuilding", staffBuilding);
		Class[] staffManageBuilding = {Manager.class};
		pemission.put("staffManageBuilding", staffManageBuilding);
		Class[] staffRooms = {Manager.class};
		pemission.put("staffRooms", staffRooms);
		Class[] staffManageRooms = {Manager.class};
		pemission.put("staffManageRooms", staffManageRooms);
		
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
