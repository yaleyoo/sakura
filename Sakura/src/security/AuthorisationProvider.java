package security;

import java.util.HashMap;
import java.util.Map;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;

@SuppressWarnings("rawtypes")
public class AuthorisationProvider {
	/**
	 * Initialize the permission settings
	 */
	public static Map<String, Class[]> permission = new HashMap<String, Class[]>();
	static {
		Class[] cancelOrder = {Customer.class, Manager.class, Receptionist.class};
		permission.put("CancelOrder", cancelOrder);
		Class[] checkOrder = {Customer.class, Manager.class, Receptionist.class};
		permission.put("CheckOrder", checkOrder);
		Class[] getAvailableRooms = null;
		permission.put("GetAvailableRooms", getAvailableRooms);
		Class[] homePage = null;
		permission.put("HomePage", homePage);
		Class[] login = null;
		permission.put("Login", login);
		Class[] placeOrder = {Customer.class, Manager.class, Receptionist.class};
		permission.put("PlaceOrder", placeOrder);
		Class[] viewCustomer = {Customer.class, Manager.class, Receptionist.class};
		permission.put("ViewCustomer", viewCustomer);
		Class[] viewRooms = null;
		permission.put("ViewRooms", viewRooms);
		Class[] logout = null;
		permission.put("LogOut", logout);
		Class[] staffIndex = null;
		permission.put("StaffIndex", staffIndex);
		Class[] staffChooseCustomer = {Manager.class, Receptionist.class};
		permission.put("StaffChooseCustomer", staffChooseCustomer);
		Class[] staffCreateCustomer = {Manager.class, Receptionist.class};
		permission.put("StaffCreateCustomer", staffCreateCustomer);
		Class[] staffSearchCustomer = {Manager.class, Receptionist.class};
		permission.put("StaffSearchCustomer", staffSearchCustomer);
		Class[] staffViewPlaceOrder = {Manager.class, Receptionist.class};
		permission.put("StaffViewPlaceOrder", staffViewPlaceOrder);
		Class[] staffPlaceOrder = {Manager.class, Receptionist.class};
		permission.put("StaffPlaceOrder", staffPlaceOrder);
		Class[] staffCheckOrder = {Manager.class, Receptionist.class};
		permission.put("StaffCheckOrder", staffCheckOrder);
		Class[] staffBuilding = {Manager.class};
		permission.put("StaffBuildings", staffBuilding);
		Class[] staffManageBuilding = {Manager.class};
		permission.put("StaffManageBuilding", staffManageBuilding);
		permission.put("StaffNewBuilding", staffManageBuilding);
		permission.put("StaffEditBuilding", staffManageBuilding);
		Class[] staffRooms = {Manager.class};
		permission.put("StaffRooms", staffRooms);
		Class[] staffManageRooms = {Manager.class};
		permission.put("StaffManageRoom", staffManageRooms);
		permission.put("StaffNewRoom", staffManageRooms);
		permission.put("StaffEditRoom", staffManageRooms);

		Class[] staffOrderRooms = {Manager.class, Receptionist.class};
		permission.put("StaffOrderRooms", staffOrderRooms);
		Class[] staffManageCurrentOrders = {Manager.class, Receptionist.class};
		permission.put("StaffManageCurrentOrders", staffManageCurrentOrders);
		Class[] staffEditOrder = {Manager.class, Receptionist.class};
		permission.put("StaffEditOrder", staffEditOrder);


	}

	public static boolean checkAuthorisation(String command, Object user) {
		Class userClass = null;
		if (user != null)
			userClass = user.getClass();
		// if the command is invalid
		if (!permission.containsKey(command)) {
			return false;
		}
		Class[] permissionList = permission.get(command);
		// no authentication necessary
		if (permissionList == null) {
			return true;
		}
		else {
			for (int i=0; i<permissionList.length; i++) {
				// if user is authenticated
				if (permissionList[i] == userClass) {
					return true;
				}
			}
			return false;
		}
	}
}
