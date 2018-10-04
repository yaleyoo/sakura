package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

public class StaffIndexCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/staff/staffIndex.jsp");
	}
}
