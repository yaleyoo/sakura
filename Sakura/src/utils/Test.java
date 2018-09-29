package utils;

import domain.*;
import service.*;
import servlet.GetAvailableRoomsCommand;

import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dataMapper.*;

public class Test {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		
		
//		RoomService rs = new RoomService();
//
//		try {
//			DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date start = dateFormat2.parse("2018-09-17 22:36:01");
//			DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date end;
//			end = dateFormat2.parse("2018-09-20 10:00:00");
//
//			
//			System.out.println(end.getDate()-start.getDate());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
		//A a = (A)Class.forName("utils.B").getConstructor().newInstance();
		//a.print();
		
		
		
		/*Order o = new Order();
		o.setCreateTime(new Date());
		Customer c = new Customer();
		c.setCustomerId(1);
		c.setFirstname("aaa");
		c.setTitle("mr");
		c.setEmail("sss");
		c.setIdentityNumber("111");
		c.setIdentityType("ss");
		c.setLastname("sss");
		c.setNumber("341231");
		o.setCustomer(c);
		Room r = new Room();
		Building b = new Building();
		r.setBuilding(b);
		o.setRoom(r);
		o.setOrderId(Long.parseLong("1809182317351"));
		o.setTimerange(new TimeRange(new Date(), new Date()));
		
		OrderAssembler oa = new OrderAssembler();
		OrderDTO od = oa.writeDTO(o);
		
		String s = od.toString();
		OrderDTO ox = OrderDTO.readString(s);
		
		System.out.println(ox);*/
		
		BookedRoom br = new BookedRoom();
		br.setBookedRoomId(1);
		DomainObject d = br;
		
		
		
		
		
		
	}

}
