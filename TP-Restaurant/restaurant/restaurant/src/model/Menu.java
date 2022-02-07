package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

	private List<Dish> dishes = new ArrayList<>();
	
	public Menu(Menu menu) {
		dishes = menu.dishes;
	}
	
<<<<<<< HEAD
	public Menu() {
		// TODO Auto-generated constructor stub
	}

=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
	public void setDishPrice(Dish dish, Double price) {
		if(dishes.contains(dish)) dish.setPrice(price);
	}
	
	public void add(Dish dish) {
		dishes.add(dish);
	}
}
