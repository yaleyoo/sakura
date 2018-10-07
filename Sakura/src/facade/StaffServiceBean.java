package facade;

import domain.Staff;
import domain.StaffAssembler;
import domain.StaffDTO;
/**
 * a class for remote invoke
 */
public class StaffServiceBean {
	public StaffDTO getStaff(int id) {
		Staff br = new Staff();
		br.setStaffId(id);;
		
		return new StaffAssembler().writeDTO(new Staff());
				//new StaffMapper().findBookedRoomByRoomId(br).get(0));
	}
	
	public String getBookedRoomString(int id) {
		 return getStaff(id).toString();
	}
}
