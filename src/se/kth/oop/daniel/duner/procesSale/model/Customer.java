package se.kth.oop.daniel.duner.procesSale.model;

/**
 * Contains data on a customer, data that is stored in a register.
 * @author danielduner
 *
 */
public class Customer {
	String surName;
	String lastName;
	int personalId;
	Address adress;
	Membership membership;
	/**
	 * Instantiates a Customer with all chosen information
	 * @param surName represents chosen surname
	 * @param lastName represents chosen last name
	 * @param personalId represents chosen personal id number
	 * @param adress chosen represents an object containing chosen adress information
	 * @param membership represents an object containing membership information
	 */
	public Customer(String surName,String lastName, int personalId, Address adress,Membership membership) {
		this.surName = surName;
		this.lastName = lastName;
		this.personalId = personalId;
		this.adress = adress;
		this.membership = membership;
	}
	
	public String getName() {
		return surName + " "+ lastName;
	}
	
	public int getPersonalId(){
		return personalId;
	}
	public Address getAdress() {
		return adress;
	}
	public Membership getMembership() {
		return membership;
	}
	
}
