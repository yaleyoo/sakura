package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthorisationEnforcer {
	/**
	 * retrieve command type and logged user from request, send to authorisationProvider
	 *  to check authorisation.
	 * @param request
	 * @return
	 */
	public static boolean checkAuthorisation(HttpServletRequest request) {
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		Object user = session.getAttribute("loggedUser");
		
		return AuthorisationProvider.checkAuthorisation(command, user);
	}
}
