package domain;

import utils.UnitOfWork;

public class Customer extends DomainObject{
	private int customerId;
	private String firstname;
	private String lastname;
	private String title;
	private String identityNumber;
	private String identityType;
	private String email;
	private String number;
		
	public Customer(String firstname, String lastname, String title, String identityNumber, String identityType,
			String email, String number) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.title = title;
		this.identityNumber = identityNumber;
		this.identityType = identityType;
		this.email = email;
		this.number = number;
		
	}
	
	public Customer() {
		
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getIdentityType() {
		return identityType;
	}
	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
