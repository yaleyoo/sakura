package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;

import domain.Customer;
import domain.Order;
import domain.Receptionist;
import domain.Room;
import domain.TimeRange;
import service.OrderService;
import utils.DateValidator;
import utils.IdentityMap;

public class StaffEditOrderCommand extends FrontCommand {

	@Override
	public void process() throws ServletException, IOException {
		String method = request.getParameter("method");
		if (method.equals("search")) {
			Order order = new Order();
			order.setOrderId(Long.parseLong(request.getParameter("orderId")));
			
			OrderService os = new OrderService();
			List<Order> result = os.findOrder(order);
			if (result.size() > 0) {
				order = result.get(0);
				request.setAttribute("order", order);
			}
			forward("/jsp/staff/staffManageCurrentOrders.jsp");
			return;
		}
		else if (method.equals("update")) {
			try {
				Long orderId = Long.parseLong(request.getParameter("orderId"));
				int customerId = Integer.parseInt(request.getParameter("customerId"));
				int roomId = Integer.parseInt(request.getParameter("roomId"));
				SimpleDateFormat sdf =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
				Date checkInTime = sdf.parse(request.getParameter("checkInTime"));
				Date checkOutTime = sdf.parse(request.getParameter("checkOutTime"));
				Date createTime = sdf.parse(request.getParameter("createTime"));
				float sum = Float.parseFloat(request.getParameter("sum"));
				String status = request.getParameter("status");
				if (status.equals("cancel")) {
					redirect("frontServlet?command=CancelOrder?orderId="+orderId);
					return;
				}
				
				Order order = new Order();
				order.setCreateTime(createTime);
				Customer customer = new Customer();
				customer.setCustomerId(customerId);
				order.setCustomer(customer);
				order.setOrderId(orderId);
				Room room = new Room();
				room.setRoomId(roomId);
				order.setRoom(room);
				order.setStatus(status);
				order.setSum(sum);
				TimeRange timerange = new TimeRange(checkInTime, checkOutTime);
				order.setTimerange(timerange);
				
				OrderService os = new OrderService();
				boolean result = os.updateOrder(order, request.getSession().getId());
				if (result) {
					IdentityMap map = IdentityMap.getInstance(order);
					map.put(order.getOrderId(), order);
					request.setAttribute("successReason", "updated the order.");
					forward("/jsp/staff/staffSuccess.jsp");
				}
				else {
					request.setAttribute("errorMsg",
							"Something going wrong when updating the order.");
					forward("/jsp/staff/staffError.jsp");
				}
			} catch (ParseException e) {
				request.setAttribute("errorMsg", e.getMessage());
				forward("/jsp/staff/staffError.jsp");
			}
			
		}
		else {
			request.setAttribute("errorMsg", "Invalid method.");
			forward("/jsp/staff/staffError.jsp");
		}
	}

}
