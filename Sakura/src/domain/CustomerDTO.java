package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class CustomerDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int customerId;
	private String firstname;
	private String lastname;
	private String title;
	private String identityNumber;
	private String identityType;
	private String email;
	private String number;
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
	
	@Override
	public String toString() {
		/*return "Customer{"+
				"customerId=" + customerId +
				"firstname=" + firstname +
				"lastname=" + lastname +
				"title=" + title +
				"identityNumber=" + identityNumber + 
				"identityType=" + identityType +
				"email=" + email +
				"number=" + number +
				"}";*/
		return JSONObject.fromObject(this).toString();
		
	}
	
	/**
	 * convert a string into a customerDTO object
	 * @param s
	 * @return
	 */
	public static CustomerDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (CustomerDTO) JSONObject.toBean(json, CustomerDTO.class);
	}
	
	
}
