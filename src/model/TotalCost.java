package model;

import integration.Membership;

public class TotalCost {
	private Amount totalAmount;
	private Amount discountAmount;
	private Amount taxAmount;
	private ValueAddedTax tax;
	private Discount discount;
	private Membership membership;
	
	
	public TotalCost() throws Exception {
		totalAmount = new Amount(0);
		discountAmount = new Amount(0);
		taxAmount = new Amount(0);
		tax = new ValueAddedTax(0.25);
		discount = new Discount(0.1,0.15,0.25);
		membership = new Membership(false, "none");
	}
	
	public void setDiscountEligibility(Membership membership, Amount price) throws Exception {
		this.membership = membership;
		this.setTotalCost(price);
	}
	
	public void setTotalCost(Amount price) throws Exception {
		totalAmount = new Amount(price.getAmount());
		taxAmount = calculateAmount(price,tax.getValueAddedTax());
		totalAmount = new Amount(totalAmount, taxAmount, '+');
		if (membership.getMembership()) {
		discountAmount = calculateAmount(price,discount.getDiscount(membership.getMembershipLevel()));
		totalAmount = new Amount(totalAmount, discountAmount, '-');
		}
	}
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Discount amount: "+ discountAmount + "\n");
		str.append("VAT amount: "+ taxAmount + "\n");
		str.append("Total amount inkl. discounts and VAT: "+ totalAmount + "\n");
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
	public Membership getMembershipLevel() {
		return membership;
	}
	
	private Amount calculateAmount(Amount price, double increase) throws Exception{
		Amount newAmount = new Amount(price.getAmount()*increase);
		return newAmount;
	}
}
