package model;

import exceptions.*;

/**
 * Holds the information of discounts
 * 
 * @author danielduner
 *
 */

public class Discount {
	private double discountGold;
	private double discountSilver;
	private double discountBronze;
	final int priceIsZero = 1;
	final int fullPrice = 0;
/**
 * Instantiates an "empty" discount where discounts are set to 0
 */
	public Discount() {
		discountGold = 0;
		discountSilver = 0;
		discountBronze = 0;
	}

	/**
	 * Instantiates a discount, setting all discount. Discounts shall not be less than 0, which would mean adding
	 * money to the sale or above 1 which would mean giving money away.
	 *
	 * @param discountGold represents chosen discount amount for gold membership
	 * @param discountSilver represents chosen discount amount for silver membership
	 * @param discountBronze represents chosen discount amount for bronze membership
	 * @throws Exception represents an exception that is thrown if any of the amounts are less than 0 or more than 1%
	 */
	public Discount(double discountGold, double discountSilver, double discountBronze) throws Exception {
		if (checkAllowedDiscountValue(discountGold) || checkAllowedDiscountValue(discountSilver)
				|| checkAllowedDiscountValue(discountBronze)) {
			throw new InvalidAmountException("discount must be a positive double between 0 and 1");
		}
		this.discountGold = discountGold;
		this.discountSilver = discountSilver;
		this.discountBronze = discountBronze;
	}
/**
 * changes the discount of a chosen membership level
 * @param discount represents chosen discount value
 * @param membershipLevel represents the membership level which to change
 * @throws Exception 
 */
	public void setSingleDiscount(double discount, String membershipLevel) throws Exception {
		if (checkAllowedDiscountValue(discount)) {
			throw new InvalidAmountException("discount must be a positive double between 0 and 1");
		}
		if (checkAllowedMembership(membershipLevel)) {
			throw new InvalidStringException("membershiplevel must be gold, silver or bronze");
		}
		switch (membershipLevel) {
		case "gold":
			this.discountGold = discount;
			break;
		case "silver":
			this.discountSilver = discount;
			break;
		case "bronze":
			this.discountBronze = discount;
			break;
		}
	}
/**
 * changes the discount of all membership levels
 * @param discountGold represents chosen discount amount for gold membership
 * @param discountSilver represents chosen discount amount for silver membership
 * @param discountBronze represents chosen discount amount for bronze membership
 * @throws Exception
 */
	public void setAllDiscounts(double discountGold, double discountSilver, double discountBronze) throws Exception {
		if (checkAllowedDiscountValue(discountGold) || checkAllowedDiscountValue(discountSilver)
				|| checkAllowedDiscountValue(discountBronze)) {
			throw new InvalidAmountException("discount must be a positive double between 0 and 1");
		}
		this.discountGold = discountGold;
		this.discountSilver = discountSilver;
		this.discountBronze = discountBronze;
	}
/**
 * fetches a chosen discount value
 * @param membershipLevel represents the membership that the caller wants to fetch discount value of
 * @return returns a chosen discount value
 * @throws Exception
 */
	public double getDiscount(String membershipLevel) throws Exception {
		if (checkAllowedMembership(membershipLevel)) {
			throw new InvalidStringException("membershiplevel must be gold, silver or bronze");
		}
		switch (membershipLevel) {
		case "gold":
			return discountGold;
		case "silver":
			return discountSilver;
		case "bronze":
			return discountBronze;
		}
		return 0;
	}

	private boolean checkAllowedMembership(String membershipLevel) {
		if (membershipLevel != "gold" && membershipLevel != "silver" && membershipLevel != "bronze") {
			return true;
		}
		return false;
	}

	private boolean checkAllowedDiscountValue(double discount) {
		if (discount < fullPrice || discount > priceIsZero) {
			return true;
		}
		return false;
	}

}
