package projectridebookingsystem;

public class Passenger {
	private String name; // get set
	private long contact; // get set
	private String email; // get set
	private String pickUpLocation; // get set
	private String dropLocation; // get set
	private int seats; // get set

	Passenger(String name, long contact, String email, String pickUpLocation, String dropLocation, int seats) {
		super();
		this.name = name;
		this.contact = contact;
		this.email = email;
		this.pickUpLocation = pickUpLocation;
		this.dropLocation = dropLocation;
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long newContact) {
		this.contact = newContact;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String newEmail) {
		this.email = newEmail;
	}

	public String getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(String newPickUpLocation) {
		this.pickUpLocation = newPickUpLocation;
	}

	public String getDropLocation() {
		return dropLocation;
	}

	public void setDropLocation(String newDropLocation) {
		this.dropLocation = newDropLocation;
	}

	public int getSeats() {
		return this.seats;
	}

	public void setSeats(int newSeats) {
		this.seats = newSeats;
	}
}
