package security;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;

public class UserStore {
	/**
	 * list stored authenticated customer
	 */
	static List<Customer> authenticatedCustomer = new ArrayList<Customer>();
	/**
	 * list stored authenticated manager
	 */
	static List<Manager> authenticatedManager = new ArrayList<Manager>();
	/**
	 * list stored authenticated receptionist
	 */
	static List<Receptionist> authenticatedReceptionist = new ArrayList<Receptionist>();
}
