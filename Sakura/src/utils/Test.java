package utils;

import domain.*;
import service.*;
import dataMapper.*;

public class Test {

	public static void main(String[] args) {
		
		Room room = new Room();
		room.setName("spring1");
		room.setType("single");
		room.setPrice(300);
		room.setBuildingId(1);
		room.setRoomId(3);
		
		RoomMapper cs = new RoomMapper();
		System.out.println(cs.findRoomByType(room).size());
		
	}

}
