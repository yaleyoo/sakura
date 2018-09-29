package domain;

public class OrderAssembler {

	public OrderDTO writeDTO(Order order) {
		OrderDTO result = new OrderDTO();
		result.setCreateTime(order.getCreateTime());
		result.setOrderId(order.getOrderId());
		result.setStatus(order.getStatus());
		result.setSum(order.getSum());
		result.setTimerange(order.getTimerange());
		//customer
		writeCustomerDTO(result, order);
		//room
		writeRoomDTO(result, order);
		
		return result;
	}
	
	public void writeCustomerDTO(OrderDTO orderDTO, Order order) {
		CustomerDTO customerDTO = new CustomerDTO();
		Customer customer = order.getCustomer();
		customerDTO.setCustomerId(customer.getCustomerId());
		customerDTO.setEmail(customer.getEmail());
		customerDTO.setFirstname(customer.getFirstname());
		customerDTO.setIdentityNumber(customer.getIdentityNumber());
		customerDTO.setIdentityType(customer.getIdentityType());
		customerDTO.setLastname(customer.getLastname());
		customerDTO.setNumber(customer.getNumber());
		customerDTO.setTitle(customer.getTitle());
		
		orderDTO.setCustomer(customerDTO);
	}
	
	public void writeRoomDTO(OrderDTO orderDTO, Order order) {
		RoomDTO roomDTO = new RoomDTO();
		Room room = order.getRoom();
		roomDTO.setName(room.getName());
		roomDTO.setPrice(room.getPrice());
		roomDTO.setRoomId(room.getRoomId());
		roomDTO.setType(room.getType());
		writeBuildingDTO(roomDTO, room);
		
		orderDTO.setRoom(roomDTO);
	}
	
	public void writeBuildingDTO(RoomDTO roomDTO, Room room) {
		BuildingDTO buildingDTO = new BuildingDTO();
		Building building = room.getBuilding();
		buildingDTO.setAddress(building.getAddress());
		buildingDTO.setBuildingId(building.getBuildingId());
		buildingDTO.setBuildingName(building.getBuildingName());
		
		roomDTO.setBuildingDTO(buildingDTO);
	}
}
