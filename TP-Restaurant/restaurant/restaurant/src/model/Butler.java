package model;

import java.util.ArrayList;
import java.util.List;

public class Butler extends Server{

	public Restaurant restaurant;
	public List<Table> tables = new ArrayList<>();
	
	public Butler(List<Table> tables) {
		super();
		this.tables = tables;
	}
<<<<<<< HEAD

	public Butler() {
		// TODO Auto-generated constructor stub
	}
=======
>>>>>>> 2fb0ed95950daa3ff0ebffd8df5340890e3fc986
}
