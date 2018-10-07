package domain;

import java.io.Serializable;

import net.sf.json.JSONObject;

public class StaffDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int staffId;
	private String firstname;
	private String lastname;
	private String number;
	private String status;
	
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
	
	@Override
	public String toString() {
		/*return "Staff{"+
				"staffId=" + staffId +
				"firstname=" + firstname +
				"lastname=" + lastname +
				"number=" + number +
				"status=" + status +
				"}";*/
		return JSONObject.fromObject(this).toString();
		
	}
	
	/**
	 * convert a string into a staffDTO object
	 * @param s
	 * @return
	 */
	public static StaffDTO readString(String s) {
		JSONObject json = JSONObject.fromObject(s);
		return (StaffDTO) JSONObject.toBean(json, StaffDTO.class);
	}
	
	
}
