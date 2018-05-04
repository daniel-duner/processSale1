package se.kth.oop.daniel.duner.procesSale.model;

/**
 * Represents membership data, only mean to ransport data
 * 
 * @author danielduner
 *
 */

public class Membership {
	private boolean membership;
	private MEMLVL membershipLevel;
/**
 * Creates a membership with information about membership level and if membership is valid
 * @param membership represents if the membership is valid or not
 * @param membershipLevel represents the level of the membership
 */
	public Membership(boolean membership, MEMLVL membershipLevel) {
		this.membership = membership;
		this.membershipLevel = membershipLevel;
	}
/**
 * 
 * Format of the object when it's presented as a string
 * 
 */
	public String toString(){
		return ("Membership: " + firstLetterToUpperCase(membershipLevel));
	}

	public boolean getMembership() {
		return membership;
	}

	public MEMLVL getMembershipLevel() {
		return membershipLevel;
	}
	private String firstLetterToUpperCase(MEMLVL input){
		return input.toString().substring(0, 1).toUpperCase() + input.toString().substring(1);
		
	}

}
