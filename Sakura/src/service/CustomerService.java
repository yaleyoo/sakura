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
	
	/**
	 * insert customer information
	 * @param customer - a customer object which need to be inserted into db
	 * @param sessionId -  the id for the session who performs this insert
	 * @return
	 */
	public boolean insertCustomer(Customer customer, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(customer);
		return UnitOfWork.getCurrent().commit(sessionId);
		//return cm.insertCustomer(customer);
	}
	
	/**
	 * delete customer information
	 * @param customer - a customer object which need to be deleted from db
	 * @param sessionId -  the id for the session who performs this delete
	 * @return
	 */
	public boolean deleteCustomer(Customer customer, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(customer);
		return UnitOfWork.getCurrent().commit(sessionId);
		//return cm.deleteCustomer(customer);
	}
	
	/**
	 * update customer information
	 * @param building - a updated customer object which need to be wrote into db
	 * @param sessionId -  the id for the session who performs this update
	 * @return
	 */
	public boolean updateCustomer(Customer customer, String sessionId) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(customer);
		return UnitOfWork.getCurrent().commit(sessionId);
		//return cm.updateCustomer(customer);
	}
	
	/**
	 * find customer by customerId, it would search the identity map first,
	 * if not in identity map, search database
	 * @param customer
	 * @return a list of customer objects
	 */
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
	
	/**
	 * find customer by email, it would search the identity map first,
	 * if not in identity map, search database
	 * @param customer
	 * @return a list of customer objects
	 */
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
