package model;

import integration.Amount;

public class TotalCostDTO {
	private Amount totalAmount;
	private Amount discountAmount;
	private Amount taxAmount;
	private Membership membership;
	
	
	public TotalCostDTO(TotalCost totalCost) throws Exception {
		this.totalAmount = totalCost.getTotalAmount();
		this.discountAmount = totalCost.getDiscountAmount();
		this.taxAmount = totalCost.getTaxAmount();
		membership = totalCost.getMembership();
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
}
