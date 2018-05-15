package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Represents a payment that the is received from customer to cashier and then to system
 * @author danielduner
 *
 */
public class Payment {
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
	public Payment(Amount payment, TotalCost totalCost,CashRegister cashRegister) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
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

	private void calculateChange() throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		change = new Amount(payment, totalCost.getTotalAmount(),'-');
	}

}
