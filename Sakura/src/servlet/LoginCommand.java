package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Manager;
import domain.Receptionist;
import domain.Staff;
import service.CustomerService;
import service.StaffService;

public class LoginCommand extends FrontCommand {

	
	@Override
	public void process() throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		String requestRole = request.getParameter("role");
		Staff r = new Staff();
		Staff m = new Staff();
		Customer c = new Customer();
		switch (requestRole) {
			case "customer":
				// HERE we pretend user already logged in as a customer.
				CustomerService cs = new CustomerService();
				
				c.setCustomerId(1);
				Customer customer = cs.findCustomer(c).get(0);
				session.setAttribute("loggedUser", customer);
				redirect("frontServlet?command=HomePage");
				break;
			case "receptionist":
				StaffService ss = new StaffService();
				
				r.setStaffId(2);
				Receptionist receptionist = new Receptionist(ss.findStaff(r).get(0));
				session.setAttribute("loggedUser", receptionist);
				redirect("frontServlet?command=StaffIndex");
				break;
			case "manager":
				StaffService ss1 = new StaffService();
				
				m.setStaffId(1);
				Manager manager = new Manager(ss1.findStaff(m).get(0));
				session.setAttribute("loggedUser", manager);
				redirect("frontServlet?command=StaffIndex");
				break;		
			default:
				request.setAttribute("errorMsg", "Invalid role.");
				forward("/jsp/error.jsp");
		}
				
	}
}
