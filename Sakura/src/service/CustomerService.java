package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.CustomerMapper;
import domain.Customer;
import utils.UnitOfWork;

public class CustomerService {
	private CustomerMapper cm;
	public CustomerService() {
		cm = new CustomerMapper();
	}
	
	public boolean insertCustomer(Customer customer, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(customer);
		return UnitOfWork.getCurrent().commit(sessionId);
		//return cm.insertCustomer(customer);
	}
	
	public boolean deleteCustomer(Customer customer, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(customer);
		return UnitOfWork.getCurrent().commit(sessionId);
		//return cm.deleteCustomer(customer);
	}
	
	public boolean updateCustomer(Customer customer, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(customer);
		return UnitOfWork.getCurrent().commit(sessionId);
		//return cm.updateCustomer(customer);
	}
	
	public List<Customer> findCustomer(Customer customer){
		//search identity map first
		utils.IdentityMap<Customer> identityMap = utils.IdentityMap.getInstance(customer);
		Customer customer_inMap = identityMap.get(customer.getCustomerId());
		//if object is found
		if (customer_inMap != null) {
			List<Customer> result = new ArrayList<Customer>();
			result.add(customer_inMap);
			return result;
		}
		//if not in the identity map
		return cm.findCustomerById(customer);
	}
	
	public List<Customer> findCustomerByEmail(Customer customer){
		//search identity map first
		utils.IdentityMap<Customer> identityMap = utils.IdentityMap.getInstance(customer);
		Customer customer_inMap = identityMap.get(customer.getCustomerId());
		//if object is found
		if (customer_inMap != null) {
			List<Customer> result = new ArrayList<Customer>();
			result.add(customer_inMap);
			return result;
		}
		//if not in the identity map
		return cm.findCustomerByEmail(customer);
	}
}
