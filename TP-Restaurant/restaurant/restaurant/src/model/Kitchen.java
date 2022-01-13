package model;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {

	private List<Order> tasksToDo = new ArrayList<>();

	public void add(Order order) {
		tasksToDo.add(order);
	}
}
