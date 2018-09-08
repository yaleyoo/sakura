package service;

import java.util.List;

import dataMapper.CustomerMapper;
import domain.Customer;
import utils.UnitOfWork;

public class CustomerService {
	private CustomerMapper cm;
	public CustomerService() {
		cm = new CustomerMapper();
	}
	
	public boolean insertCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerNew(customer);
		return UnitOfWork.getCurrent().commit();
		//return cm.insertCustomer(customer);
	}
	
	public boolean deleteCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDeleted(customer);
		return UnitOfWork.getCurrent().commit();
		//return cm.deleteCustomer(customer);
	}
	
	public boolean updateCustomer(Customer customer) {
		UnitOfWork.newCurrent();
		UnitOfWork.getCurrent().registerDirty(customer);
		return UnitOfWork.getCurrent().commit();
		//return cm.updateCustomer(customer);
	}
	
	public List<Customer> findCustomer(Customer customer){
		return cm.findCustomerById(customer);
	}
}
