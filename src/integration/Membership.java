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

	public boolean getMembership() {
		return membership;
	}

	public String getMembershipLevel() {
		return membershipLevel;
	}

}
