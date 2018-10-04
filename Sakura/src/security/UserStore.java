package security;

import java.util.ArrayList;
import java.util.List;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;

public class UserStore {
	static List<Customer> authenticatedCustomer = new ArrayList<Customer>();
	static List<Manager> authenticatedManager = new ArrayList<Manager>();
	static List<Receptionist> authenticatedReceptionist = new ArrayList<Receptionist>();
}
