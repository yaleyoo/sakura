package facade;

import dataMapper.OrderMapper;
import domain.Order;
import domain.OrderAssembler;
import domain.OrderDTO;

public class OrderServiceBean {

	public OrderDTO getOrder(long id) {
		Order br = new Order();
		br.setOrderId(id);;
		
		return new OrderAssembler().writeDTO(
				new OrderMapper().findOrderByOrderId(br).get(0));
	}
	
	public String getBookedRoomString(int id) {
		 return getOrder(id).toString();
	}
}
