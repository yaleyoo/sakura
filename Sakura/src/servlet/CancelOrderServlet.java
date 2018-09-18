package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Order;
import service.OrderService;


@WebServlet("/cancelOrder")
public class CancelOrderServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderService os;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long orderId = Long.parseLong(request.getParameter("order_id"));
		Order order = new Order();
		order.setOrderId(orderId);
		order = os.findOrder(order).get(0);
		boolean result = true;
		
		// can only cancel order in 2 days before the check in date.
		Date now = new Date();
		System.out.println(order.getTimerange().getCheckInTime().getTime() - now.getTime());
		//TODO: still wrong
		if (order.getTimerange().getCheckInTime().getTime() - now.getTime() < 2*24*60) {
			result = false;
		}
		if (!result) {
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
			return;
		}
		result = os.cancelOrder(order);
		
		if (result)
			request.getRequestDispatcher("/jsp/successOrder.jsp").forward(request, response);
		else
			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}
	
	public void init() throws ServletException {
		os = new OrderService();
	}
	
	public void destroy() {
		super.destroy(); 
	}
}
