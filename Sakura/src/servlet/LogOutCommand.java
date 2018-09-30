package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class LogOutCommand extends FrontCommand {
	@Override
	public void process() throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("loggedUser");
		
		forward("/index.jsp");
		
	}
}
