package database;

import integration.Membership;
import model.Adress;
import model.Customer;

/**
 * Represents a database that stores all customers (HARDCODED)
 * @author danielduner
 *
 */

public class CustomerRegister {
	private Customer[] customerRegister;
	private Adress adress = new Adress("Begslagsvägen", 41, "Stockholm", 16848);

	public CustomerRegister() {
		customerRegister = new Customer[5];
		customerRegister[0] = new Customer("Anders", "Svensson", 01010101, adress, new Membership(true, "gold"));
		customerRegister[1] = new Customer("Per", "Persson", 02020202, adress, new Membership(false, "none"));
		customerRegister[2] = new Customer("Arne", "Arnesson", 03030303, adress, new Membership(true, "bronze"));
		customerRegister[3] = new Customer("Alexander", "Alexandersson", 04040404, adress,
				new Membership(true, "bronze"));
		customerRegister[4] = new Customer("Sune", "Sunesson", 05050505, adress, new Membership(false, "none"));
	}

	public Membership searchCustomer(int customerId) {
		for (int i = 0; i < customerRegister.length; i++) {
			if (customerRegister[i].getPersonalId() == customerId) {
				return customerRegister[i].getMembership();
			}
		}
		Membership notRegistered = new Membership(false, "none");
		return notRegistered;
	}
}
