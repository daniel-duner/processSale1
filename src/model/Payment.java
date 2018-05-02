package model;
/**
 * Represents a payment that the is received from customer to cashier and then to system
 * @author danielduner
 *
 */
public class Payment {
	private CashRegister cashRegister;
	
	private TotalCost totalCost;
	private Amount change;
	private Amount payment;
/**
 * Instantiates a payment and calculates the change
 * 
 * @param payment represents the received payment
 * @param totalCost represents the total cost of the sale
 * @param cashRegister represents the cash register
 * @throws Exception
 */
	public Payment(Amount payment, TotalCost totalCost,CashRegister cashRegister) throws Exception {
		this.cashRegister = cashRegister;
		this.payment = payment;
		this.totalCost = totalCost;
		calculateChange();
		cashRegister.addPayment(new Amount(totalCost.getTotalAmount().getAmount()));
	}
	
	public Amount getChange() {
		return change;
	}

	public Amount getPayment() {
		return payment;
	}

	public TotalCost getTotalCost() {
		return totalCost;
	}

	private void calculateChange() throws Exception {
		change = new Amount(payment, totalCost.getTotalAmount(),'-');
	}

}
