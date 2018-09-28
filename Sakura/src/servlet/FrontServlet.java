package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FrontCommand command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.process();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	@SuppressWarnings("unchecked")
	private FrontCommand getCommand(HttpServletRequest request) {
		try {
			return (FrontCommand)getCommandClass(request).getDeclaredConstructor().newInstance();
		}catch(Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("rawtypes")
	private Class getCommandClass (HttpServletRequest request) {
		Class result;
		
		final String commandClassName = "servlet."+(String) request.getParameter("command") + "Command";
		System.out.println(commandClassName);
		
		try {
			result = Class.forName(commandClassName);
			System.out.println(commandClassName);
		} catch (ClassNotFoundException e) {
			result = null;
		}
		
		return result;
	}

}
