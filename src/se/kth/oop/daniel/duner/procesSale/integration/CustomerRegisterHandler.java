package se.kth.oop.daniel.duner.procesSale.integration;

import se.kth.oop.daniel.duner.procesSale.model.Address;
import se.kth.oop.daniel.duner.procesSale.model.Customer;
import se.kth.oop.daniel.duner.procesSale.model.MEMLVL;
import se.kth.oop.daniel.duner.procesSale.model.Membership;

/**
 * Represents the system that handles the database that stores all customers (HARDCODED)
 * @author danielduner
 *
 */

public class CustomerRegisterHandler {
	private Customer[] customerRegister;
	private Address adress = new Address("Begslagsvägen", 41, "Stockholm", 16848);	

	/**
	 * Instatiates the Customer Register
	 */
	public CustomerRegisterHandler() {
		customerRegister = new Customer[5];
		customerRegister[0] = new Customer("Anders", "Svensson", 01010101, adress, new Membership(true, MEMLVL.GOLD));
		customerRegister[1] = new Customer("Per", "Persson", 02020202, adress, new Membership(false, MEMLVL.NONE));
		customerRegister[2] = new Customer("Arne", "Arnesson", 03030303, adress, new Membership(true, MEMLVL.BRONZE));
		customerRegister[3] = new Customer("Alexander", "Alexandersson", 04040404, adress, new Membership(true, MEMLVL.SILVER));
		customerRegister[4] = new Customer("Sune", "Sunesson", 05050505, adress, new Membership(false, MEMLVL.NONE));
	}
	
	/**
	 * Searches the customer register after the customer id and returns a membership, if a membership does not
	 * exist an empty object will be returned
	 * @param customerId represents the customers identification number
	 * @return returns either Membership or an Empty Membership
	 */

	public Membership searchCustomer(int customerId) {
		for (int i = 0; i < customerRegister.length; i++) {
			if (customerRegister[i].getPersonalId() == customerId) {
				return customerRegister[i].getMembership();
			}
		}
		return new Membership(false, MEMLVL.NONE);
	}
}
