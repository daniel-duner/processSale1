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

	public Discount() {
		discountGold = 0;
		discountSilver = 0;
		discountBronze = 0;
	}

	public Discount(double discountGold, double discountSilver, double discountBronze) throws Exception {
		if (checkAllowedDiscountValue(discountGold) || checkAllowedDiscountValue(discountSilver)
				|| checkAllowedDiscountValue(discountBronze)) {
			throw new InvalidAmountException("discount must be a positive double between 0 and 1");
		}
		this.discountGold = discountGold;
		this.discountSilver = discountSilver;
		this.discountBronze = discountBronze;
	}

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

	public void setAllDiscounts(double discountGold, double discountSilver, double discountBronze) throws Exception {
		if (checkAllowedDiscountValue(discountGold) || checkAllowedDiscountValue(discountSilver)
				|| checkAllowedDiscountValue(discountBronze)) {
			throw new InvalidAmountException("discount must be a positive double between 0 and 1");
		}
		this.discountGold = discountGold;
		this.discountSilver = discountSilver;
		this.discountBronze = discountBronze;
	}

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
		if (discount < 0 || discount > 1) {
			return true;
		}
		return false;
	}

}
