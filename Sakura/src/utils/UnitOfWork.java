package utils;

import java.util.ArrayList;
import java.util.List;

public class UnitOfWork {
	private static ThreadLocal current = new ThreadLocal();
	
	private List<Object> newObjects = new ArrayList<Object>();
}
