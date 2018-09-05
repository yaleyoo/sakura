package service;

import java.util.List;

import dataMapper.CustomerMapper;
import domain.Customer;

public class CustomerService {
	private CustomerMapper cm;
	public CustomerService() {
		cm = new CustomerMapper();
	}
	
	public boolean insertCustomer(Customer customer) {
		return cm.insertCustomer(customer);
	}
	
	public boolean deleteCustomer(Customer customer) {
		return cm.deleteCustomer(customer);
	}
	
	public boolean updateCustomer(Customer customer) {
		return cm.updateCustomer(customer);
	}
	
	public List<Customer> findCustomer(Customer customer){
		return cm.findCustomerById(customer);
	}
}
