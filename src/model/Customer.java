package model;

import integration.Membership;

/**
 * Contains data on a customer, data that is stored in a register.
 * @author danielduner
 *
 */

public class Customer {
	String surName;
	String lastName;
	int personalId;
	Adress adress;
	Membership membership;
	
	public Customer(String surName,String lastName, int personalId, Adress adress,Membership membership) {
		this.surName = surName;
		this.lastName = lastName;
		this.personalId = personalId;
		this.adress = adress;
		this.membership = membership;
	}
	public String getName() {
		StringBuilder name = new StringBuilder(surName);
		name.append(" "+lastName);
		return name.toString();
	}
	
	public int getPersonalId(){
		return personalId;
	}
	public Adress getAdress() {
		return adress;
	}
	public Membership getMembership() {
		return membership;
	}
	
}
