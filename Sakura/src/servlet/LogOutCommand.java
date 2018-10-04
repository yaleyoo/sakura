package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

public class LogOutCommand extends FrontCommand {
	@Override
	public void process() throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("loggedUser");
		String[] refererArray = request.getHeader("referer").split("/Sakura/");
		String referer = null;
		
		//redirect user to the referer page 
		if (refererArray.length == 2) {
			referer = refererArray[1];
			redirect("/Sakura/" + referer);
		}
		else {
			session.setAttribute("errorMsg", 
					"Invalid referer. Please don't manipulate the URI!");
			forward("/jsp/error.jsp");
		}
	}
}
