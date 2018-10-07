package domain;

public class CustomerAssembler {
	
	/**
	 * write a customerDTO based on a customer object
	 * @param customer
	 * @return
	 */
	public CustomerDTO writeDTO(Customer customer) {
		CustomerDTO result = new CustomerDTO();
		result.setCustomerId(customer.getCustomerId());
		result.setEmail(customer.getEmail());
		result.setFirstname(customer.getFirstname());
		result.setLastname(customer.getLastname());
		result.setIdentityNumber(customer.getIdentityNumber());
		result.setIdentityType(customer.getIdentityType());
		result.setNumber(customer.getNumber());
		result.setTitle(customer.getTitle());
		
		return result;
	}
}
