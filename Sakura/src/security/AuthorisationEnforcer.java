package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorisationEnforcer {
	public static boolean checkAuthorisation(HttpServletRequest request) {
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		Object user = session.getAttribute("loggedUser");
		
		return AuthorisationProvider.checkAuthorisation(command, user);
	}
}
