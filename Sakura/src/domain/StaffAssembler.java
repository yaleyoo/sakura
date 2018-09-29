package domain;

public class StaffAssembler {
	public StaffDTO writeDTO(Staff staff) {
		StaffDTO result = new StaffDTO();
		result.setFirstname(staff.getFirstname());
		result.setLastname(staff.getLastname());
		result.setNumber(staff.getNumber());
		result.setStaffId(staff.getStaffId());
		result.setStatus(staff.getStatus());
		
		return result;
	}
}
