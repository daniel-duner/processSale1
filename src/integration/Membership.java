package integration;

/**
 * Represents membership data, only mean to ransport data
 * 
 * @author danielduner
 *
 */

public class Membership {
	private boolean membership;
	private String membershipLevel;

	public Membership(boolean membership, String membershipLevel) {
		this.membership = membership;
		this.membershipLevel = membershipLevel;
	}
	
	public String toString(){
		String str = ("Membership: " + firstLetterToUpperCase(membershipLevel));
		return str;
	}

	public boolean getMembership() {
		return membership;
	}

	public String getMembershipLevel() {
		return membershipLevel;
	}
	private String firstLetterToUpperCase(String input){
		return input.substring(0, 1).toUpperCase() + input.substring(1);
		
	}

}
