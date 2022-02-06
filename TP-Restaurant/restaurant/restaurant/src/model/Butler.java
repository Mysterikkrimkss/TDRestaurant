package model;

import java.util.ArrayList;
import java.util.List;

public class Butler extends Server{

<<<<<<< HEAD
	public Restaurant restaurant;
=======
>>>>>>> 594099a (correction git)
	public List<Table> tables = new ArrayList<>();
	
	public Butler(List<Table> tables) {
		super();
		this.tables = tables;
	}
}
