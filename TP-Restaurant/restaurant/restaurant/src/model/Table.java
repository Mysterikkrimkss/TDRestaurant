package model;

public class Table {

	private Server server;
	
	private Customer customer;
	
	public Table( ) {}
	
	public Table(Server server) {
		this.server = server;
	}

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
