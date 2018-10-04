package domain;

public class Manager extends Staff{

	public Manager(Staff staff) {
		this.setFirstname(staff.getFirstname());
		this.setLastname(staff.getLastname());
		this.setNumber(staff.getNumber());
		this.setStaffId(staff.getStaffId());
		this.setStaffType(staff.getStaffType());
		this.setStatus(staff.getStatus());
	}
}
