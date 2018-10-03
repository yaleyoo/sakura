package domain;

public class Staff extends DomainObject{
	private int staffId;
	private String firstname;
	private String lastname;
	private String number;
	private String status;
	private String staffType;
	
	public final String manager = "Manager";
	public final String receptionist = "Receptionist";
	
	public Staff() {
		
	}
	
	public Staff(String firstname, String lastname, String number, String status) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.number = number;
		this.status = status;
		
	}
	
	@Override
	public String getId() {
		return ""+this.staffId;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
		
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
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}
	
	
}
