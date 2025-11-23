package projectridebookingsystem;

public class Cab {
	static int id = 353345;
	private Driver driver; // null
	private String number; // vehicle num
	private String uberId;
	private String type;
	private int capacity;
	private String status = "AVAIL";
	private String location = "DECCAN";

	String[] typeVehicle = { "hatchback", "sedan", "suv", "muv" };
	int[] vehicleCapacity = { 3, 4, 5, 6 };

	{
		this.uberId = "UBER" + id++;
	}

	Cab(String number, String type, Driver driver) {
		this.number = number;
		this.type = type.toLowerCase();

		int index = 0;
		for (String element : typeVehicle) {
			if (type.toLowerCase().equals(element)) {
				break;
			}
			index++;
		}
		this.capacity = vehicleCapacity[index];
		this.driver = driver;
	}

	public void getCabDetails() {
		System.out.println("\n CAB DETAILS");
		System.out.println("Uber Id: " + uberId);
		System.out.println("Status: " + status);
		System.out.println("Type: " + type);
		System.out.println("Capacity: " + capacity);
		System.out.println("Location: " + location);
		System.out.println("");
	}

	public String getCabNumber() {
		return number;
	}

	public Driver getDriver() {
		return driver;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String newStatus) {
		status = newStatus;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getUberId() {
		return uberId;
	}
}
