package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Customer;
import domain.Order;
import domain.Staff;
import service.OrderService;

public class ViewCustomerCommand extends FrontCommand{

	private OrderService os;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public void process() throws ServletException, IOException {
		os = new OrderService();
		HttpSession session = request.getSession();
		if (session.getAttribute("loggedUser").getClass().getSuperclass() == Staff.class) {
			redirect("frontServlet?command=StaffIndex");
			return;
		}
		else if (session.getAttribute("loggedUser").getClass() == Customer.class) {
			Customer customer = (Customer)session.getAttribute("loggedUser");
			
			Order o = new Order();
			o.setCustomer(customer);
			request.setAttribute("orders", os.findOrder(o));
			forward("/jsp/customerOrders.jsp");
		}
		else {
			request.setAttribute("errorMsg", "Invalid role.");
			forward("/jsp/error.jsp");
		}
		
	}
}
