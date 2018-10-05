package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

public class StaffManageCurrentOrdersCommand extends FrontCommand{

	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/staff/staffManageCurrentOrders.jsp");
	}

}
