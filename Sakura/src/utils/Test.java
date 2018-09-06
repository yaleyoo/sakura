package utils;

import domain.*;
import service.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import dataMapper.*;

public class Test {

	public static void main(String[] args) {
		
		
		RoomService rs = new RoomService();

//		try {
//			DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date start = dateFormat2.parse("2018-09-17 22:36:01");
//			DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//			Date end;
//			end = dateFormat2.parse("2018-09-20 10:00:00");
//
//			
//			System.out.println(rs.findAvailableRooms(start, end, 1).size());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println(rs.findAllRooms().size());
        System.out.println("ss");
		
	}

}
