package servlet;

import java.io.IOException;

import javax.servlet.ServletException;

public class HomePageCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		forward("/index.jsp");
		
	}
}
