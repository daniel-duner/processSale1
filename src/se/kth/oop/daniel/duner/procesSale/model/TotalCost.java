package se.kth.oop.daniel.duner.procesSale.model;

/**
 * 
 * Contains and handles information about things affecting the total cost of the sale
 * 
 * @author danielduner
 *
 */
public class TotalCost {
	private Amount totalAmount;
	private Amount discountAmount;
	private Amount taxAmount;
	private ValueAddedTax tax;
	private Discount discount;
	private Membership membership;
	
	/**
	 * Instanstiates a standard total cost with a value of 0 and the tax rate set to 25% and the 
	 * different membership statuses set to 10%, 15% and 25%
	 * @throws Exception
	 */
	public TotalCost() throws Exception {		
		totalAmount = new Amount(0);
		discountAmount = new Amount(0);
		taxAmount = new Amount(0);
		tax = new ValueAddedTax(0.25);
		discount = new Discount(0.1,0.15,0.25);
		membership = new Membership(false, MEMLVL.NONE);
	}
/**
 * 
 * Format of the object when presented as a string
 * 
 */
	public String toString() {
		return"Discount amount: "+ discountAmount + "\n"+"VAT amount: "+ taxAmount + "\n"+"Total amount inkl. discounts and VAT: "+ totalAmount + "\n";
	}
	
	/**
	 * sets the membership that decides if discount shall be included or not
	 * @param membership represents the customers membership
	 * @param price represents the current price previous to eventual discount
	 * @throws Exception
	 */
	public void setDiscountEligibility(Membership membership, Amount price) throws Exception {
		this.membership = membership;
		this.setTotalCost(price);
	}
	/**
	 * Sets/updates the total cost
	 * @param price represents the new price excluded tax or discounts
	 * @throws Exception
	 */
	public void setTotalCost(Amount price) throws Exception {
		totalAmount = new Amount(price.getAmount());
		taxAmount = calculateAmount(price,tax.getValueAddedTax());
		totalAmount = new Amount(totalAmount, taxAmount, '+');
		if (membership.getMembership()) {
		discountAmount = calculateAmount(price,discount.getDiscount(membership.getMembershipLevel()));
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
	public Membership getMembership() {
		return membership;
	}
	private Amount calculateAmount(Amount price, double increase) throws Exception{
		 return new Amount(price.getAmount()*increase);
	}
}
