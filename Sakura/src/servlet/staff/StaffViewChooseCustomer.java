package servlet.staff;

import java.io.IOException;

import javax.servlet.ServletException;

import servlet.FrontCommand;

public class StaffViewChooseCustomer extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
			forward("/jsp/staff/staffChooseCustomer.jsp");
	}

}
