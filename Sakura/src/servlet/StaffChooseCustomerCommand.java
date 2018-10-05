package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;

import domain.Order;
import service.OrderService;
import utils.DateValidator;



public class StaffChooseCustomerCommand extends FrontCommand{


	@Override
	public void process() throws ServletException, IOException {
		forward("/jsp/staff/staffChooseCustomer.jsp");
	}
}
