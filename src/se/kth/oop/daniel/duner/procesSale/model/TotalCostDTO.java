package se.kth.oop.daniel.duner.procesSale.model;

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
		return "Discount amount: "+ discountAmount + "\n"+"VAT amount: "+ taxAmount +
				"\n"+"Total amount inkl. discounts and VAT: "+ totalAmount + "\n";
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
