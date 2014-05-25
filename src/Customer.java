import java.lang.*;
import java.util.*;

class Customer {
	private String name;
	private Vector _rentals = new Vector();

	public Customer(String newname) {
		name = newname;
	};

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	};

	public String getName() {
		return name;
	};

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();

			thisAmount = each.getCharge();

			// add frequent renter points
			frequentRenterPoints++;
			// add bonus for two day new release rental
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE)
					&& each.getDaysRented() > 1)
				frequentRenterPoints++;

			// show figures for the rental
			result += "/t" + each.getMovie().getTitle() + "/t"
					+ String.valueOf(thisAmount) + "/n";
			totalAmount += thisAmount;
		}
		// add footer lines
		result += "Amount owed is " + String.valueOf(totalAmount) + "/n";
		result += "You earned " + String.valueOf(frequentRenterPoints)
				+ "frequent renter points";
		return result;

	}
}