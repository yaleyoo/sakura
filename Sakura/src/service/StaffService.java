package service;

import java.util.ArrayList;
import java.util.List;

import dataMapper.StaffMapper;
import domain.Staff;

public class StaffService {
	private StaffMapper sm;
	
	public StaffService() {
		sm = new StaffMapper();
	}
	
	public List<Staff> findStaff(Staff staff){
		//search identity map first
		utils.IdentityMap<Staff> identityMap = utils.IdentityMap.getInstance(staff);
		Staff staff_inMap = identityMap.get(staff.getStaffId());
		//if object is found
		if (staff_inMap != null) {
			List<Staff> result = new ArrayList<Staff>();
			result.add(staff_inMap);
			return result;
		}
		//if not in the identity map
		return sm.findStaffById(staff);
	}
}
