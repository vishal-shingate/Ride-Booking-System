package projectridebookingsystem;

import java.util.Scanner;
import java.util.ArrayList;

@SuppressWarnings("resource")

public class Ride {
	String[] stops = { "Deccan", "Shivajinagar", "Swargate", "Yerwada" };
	int[] distances = { 0, 2, 4, 7, 9 };
	ArrayList<Cab> listCabs = new ArrayList<Cab>();
	Passenger passenger;
	Cab currentCab;

	{
		addPassenger();
	}

	{
		Cab cab1 = new Cab("MH-01-AA-1334", "sedan", new Driver("Ramesh Kumar", 9876543210l));
		Cab cab2 = new Cab("MH-27-AA-1254", "suv", new Driver("Suresh Kumar", 9876555510l));
		Cab cab3 = new Cab("MH-35-AA-1264", "hatchback", new Driver("Rajesh Kumar", 9876543340l));
		Cab cab4 = new Cab("MH-23-AA-1284", "muv", new Driver("Mahesh Kumar", 9876543210l));
		Cab cab5 = new Cab("MH-21-AA-1274", "sedan", new Driver("Mukesh Kumar", 9876534210l));
		Cab cab6 = new Cab("MH-03-AA-1294", "hatchback", new Driver("Hitesh Kumar", 9876578210l));
		listCabs.add(cab1);
		listCabs.add(cab2);
		listCabs.add(cab3);
		listCabs.add(cab4);
		listCabs.add(cab5);
		listCabs.add(cab6);
	}

	public void addPassenger() {
		System.out.println("Passenger Details");
		System.out.print("Name: ");
		String name = new Scanner(System.in).nextLine();
		System.out.print("Contact: ");
		long contact = new Scanner(System.in).nextLong();
		System.out.print("Email: ");
		String email = new Scanner(System.in).nextLine();
		System.out.print("Pickup Location-> 1.Deccan 2.Shivajinagar 3.Swargate 4.Yerwada \nEnter your response: ");
		String pickup = new Scanner(System.in).nextLine();
		System.out.print("Drop Location: ");
		String drop = new Scanner(System.in).nextLine();
		System.out.print("Number of people: ");
		int seats = new Scanner(System.in).nextInt();

		this.passenger = new Passenger(name, contact, email, pickup, drop, seats);
	}

	public void homeModule() {
		for (;;) {
			System.out.println("\n WEL-COME \n");
			System.out.println("1. BOOK A RIDE");
			System.out.println("2. CANCEL RIDE");
			System.out.println("3. RIDE HISTORY");
			System.out.println("4. LOGOUT \n");
			System.out.print("Enter your response: ");
			int response = new Scanner(System.in).nextInt();

			switch (response) {
			case 1 -> bookRide();
			case 2 -> cancelRide();
			case 3 -> rideHistory();
			case 4 -> {
				System.out.println("THANK U FOR USING UBER");
				System.exit(0);
			}
			default -> System.out.println("INVALID RESPONSE");
			}
		}
	}

	public void bookRide() {
		if (passenger == null) {
			addPassenger();
		}
		System.out.println("\n BOOK-A-RIDE MODULE \n");
		for (Cab element : listCabs) {
			if (element.getStatus() == "AVAIL" && passenger.getSeats() <= element.getCapacity()) {
				element.getCabDetails();
			}
		}
		System.out.print("\n Enter the uberId: ");
		String uberId = new Scanner(System.in).next();
		boolean assump = false;
		for (Cab ele : listCabs) {
			if (ele.getUberId().equals(uberId)) {
				System.out.println("YOUR RIDE HAS BEEN SUCCESSFULLY CONFIRMED");
				currentCab = ele;
				assump = true;
				System.out.println("YOU RIDE DETAILS");
				System.out.println("Cab Number: " + ele.getCabNumber());
				ele.getDriver().getDriver();
				double fare = calculateFare(passenger.getPickUpLocation(), passenger.getDropLocation());
				System.out.println("Pickup: " + passenger.getPickUpLocation());
				System.out.println("Drop: " + passenger.getDropLocation());
				System.out.println("\n Fare is: " + fare + "rs \n");
				break;
			}
		}
		if (!assump) {
			System.out.println("\n INVALID UBER ID ");
		}
	}

	public double calculateFare(String pickup, String drop) {
		double fare = 0;
		int pickUpIndex = 1;
		int dropIndex = 1;
		int index = 0;
		for (String point : stops) {
			if (pickup.equals(point)) {
				pickUpIndex = index;
			}
			if (drop.equals(point)) {
				dropIndex = index;
			}
			index++;
		}
		fare = (distances[dropIndex] - distances[pickUpIndex]) * 30;
		if (fare < 0) {
			return -1 * fare;
		} else {
			return fare;
		}
	}

	public void cancelRide() {
		if (currentCab == null) {
			System.out.println("\n NO RIDE HAS BEEN BOOKE");
			return;
		}
		System.out.println("\n CANCEL-A-RIDE MODULE \n");
		System.out.println("YOUR RIDE DETAILS");
		currentCab.getCabDetails();
		System.out.println("Cab Number: " + currentCab.getCabNumber());
		currentCab.getDriver().getDriver();

		System.out.print("DO U WANT TO CANCEL YOUR RIDE (YES/NO): ");
		String resp = new Scanner(System.in).next();
		if (resp.equalsIgnoreCase("YES")) {
			System.out.println("YOUR RIDE HAS BEEN CANCELLED");
			currentCab = null;
			passenger = null;
		}
	}

	public void rideHistory() {
		System.out.println("\n RIDE-HISTORY MODULE");
	}
}
