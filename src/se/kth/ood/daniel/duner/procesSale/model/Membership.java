package se.kth.ood.daniel.duner.procesSale.model;

/**
 * Represents membership data, only mean to ransport data
 * 
 * @author danielduner
 *
 */

public class Membership {
	private boolean membership;
	private MemLvl membershipLevel;
/**
 * Creates a membership with information about membership level and if membership is valid
 * @param membership represents if the membership is valid or not
 * @param membershipLevel represents the level of the membership
 */
	public Membership(boolean membership, MemLvl membershipLevel) {
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

	public MemLvl getMembershipLevel() {
		return membershipLevel;
	}
	private String firstLetterToUpperCase(MemLvl input){
		return input.toString().substring(0, 1).toUpperCase() + input.toString().substring(1);
		
	}

}
