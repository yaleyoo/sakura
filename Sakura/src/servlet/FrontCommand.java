package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class FrontCommand {
	protected ServletContext context;
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	protected void init(ServletContext context, HttpServletRequest request,
			HttpServletResponse response) {
		this.context = context;
		this.request = request;
		this.response = response;
	}
	
	protected void safeProcess() throws ServletException, IOException {
		try {
			process();
		}
		catch (Exception e) {
			String[] refererArray = request.getHeader("referer").split("/Sakura/");
			String referer = null;
			
			//redirect user to the referer page 
			if (refererArray.length == 2) {
				referer = refererArray[1];
				redirect("/Sakura/" + referer);
			}
			else {
				request.setAttribute("errorMsg", 
						"Invalid referer. Please don't manipulate the URI!");
				forward("/jsp/error.jsp");
			}
		}
	}
	
	protected void process() throws ServletException, IOException{};
	
	protected void forward (String target) throws ServletException, IOException
	{
		RequestDispatcher dispatcher = context.getRequestDispatcher(target);
		dispatcher.forward(request, response);
	}
	
	protected void redirect (String target) throws ServletException, IOException{
		response.sendRedirect(target);
	}
	
}
