package model;

import integration.Membership;

public class TotalCost {
	private Amount totalAmount;
	private Amount discountAmount;
	private Amount taxAmount;
	private ValueAddedTax tax;
	private Discount discount;
	private boolean discountEligibility;
	private String membershipLevel;
	
	
	public TotalCost(String currency) throws Exception {
		totalAmount = new Amount(0, currency);
		discountAmount = new Amount(0, currency);
		taxAmount = new Amount(0, currency);
		tax = new ValueAddedTax(0.25);
		discount = new Discount(0.1,0.15,0.25);
		discountEligibility = false;
		membershipLevel = null;
	}
	
	public void setDiscountEligibility(Membership membership) {
		discountEligibility = membership.getMembership();
		this.membershipLevel = membership.getMembershipLevel();
	}
	
	public void setTotalCost(Amount price) throws Exception {
		totalAmount = new Amount(price.getAmount(), price.getCurrency());
		taxAmount = calculateAmount(price,tax.getValueAddedTax());
		totalAmount = new Amount(totalAmount, taxAmount, '+');
		if (discountEligibility) {
		discountAmount = calculateAmount(price,discount.getDiscount(membershipLevel));
		totalAmount = new Amount(totalAmount, discountAmount, '-');
		}

	}
	
	public Amount getTotalAmount(){
		return this.totalAmount;
	}
	public Amount getDiscountAmount(){
		return this.discountAmount;
	}
	public Amount getTaxAmount(){
		return this.taxAmount;
	}
	
	private Amount calculateAmount(Amount price, double increase) throws Exception{
		Amount newAmount = new Amount(price.getAmount()*increase,price.getCurrency());
		return newAmount;
	}
}
