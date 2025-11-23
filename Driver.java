package projectridebookingsystem;

public class Driver {
	private String name;
	private long contact;

	Driver(String name, long contact) {
		this.name = name;
		this.contact = contact;
	}

	public void getDriver() {
		System.out.println("\n Driver Info");
		System.out.println("Drive: " + name);
		System.out.println("Contact: " + contact + "\n");
	}
}
