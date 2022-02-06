package model;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> 594099a (correction git)
public class Table {

	private Server server;
	
	private Customer customer;
	
<<<<<<< HEAD
	private List<Dish> dishes = new ArrayList<>();
	
=======
>>>>>>> 594099a (correction git)
	public Table( ) {}
	
	public Table(Server server) {
		this.server = server;
	}
<<<<<<< HEAD
	
	public void takeDish(Dish dish) {
		dishes.add(dish);
	}
=======
>>>>>>> 594099a (correction git)

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public void removeServer() {
		server = null;
	}
}
