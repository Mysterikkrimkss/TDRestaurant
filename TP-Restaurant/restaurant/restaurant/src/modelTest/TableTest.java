package modelTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import model.Dish;
import model.Server;
import model.Table;

public class TableTest {

	@Test
	public void takeDishTest() {
		Server server = new Server();
		Dish dish = new Dish();
		Table table = new Table();
		
		server.serveDish(table, dish);
		
		Assertions.assertNotEquals(table.getDishes(), new ArrayList<>());
	}
}
