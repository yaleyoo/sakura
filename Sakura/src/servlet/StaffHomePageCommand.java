package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

public class StaffHomePageCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/staffIndex.jsp");
		
	}
}
