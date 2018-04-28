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
	
	
	public TotalCost() throws Exception {
		totalAmount = new Amount(0);
		discountAmount = new Amount(0);
		taxAmount = new Amount(0);
		tax = new ValueAddedTax(0.25);
		discount = new Discount(0.1,0.15,0.25);
		discountEligibility = false;
		membershipLevel = null;
	}
	
	public void setDiscountEligibility(Membership membership, Amount price) throws Exception {
		discountEligibility = membership.getMembership();
		this.membershipLevel = membership.getMembershipLevel();
		this.setTotalCost(price);
	}
	
	public void setTotalCost(Amount price) throws Exception {
		totalAmount = new Amount(price.getAmount());
		taxAmount = calculateAmount(price,tax.getValueAddedTax());
		totalAmount = new Amount(totalAmount, taxAmount, '+');
		if (discountEligibility) {
		discountAmount = calculateAmount(price,discount.getDiscount(membershipLevel));
		totalAmount = new Amount(totalAmount, discountAmount, '-');
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Discount amount: "+ discountAmount.getAmount() + ":- \n");
		str.append("VAT amount: "+ taxAmount.getAmount() + ":- \n");
		str.append("Total amount inkl. discounts and VAT: "+ totalAmount.getAmount() + ":- \n");
		return str.toString();
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
		Amount newAmount = new Amount(price.getAmount()*increase);
		return newAmount;
	}
}
