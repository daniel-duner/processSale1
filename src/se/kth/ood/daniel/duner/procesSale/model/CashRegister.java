package se.kth.ood.daniel.duner.procesSale.model;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class CashRegister {
	private Amount balanceInCash;
/**
 * Instantiates a cash register with 1000 in balance
 * @throws Exception
 */
	public CashRegister() throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		balanceInCash = new Amount(1000);
	}
/**
 * Adds an amount of money to the balance from a payment
 * @param payment represents the cost of the whole sale
 * @throws Exception
 */
	public void addPayment(Amount payment) throws InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		balanceInCash = new Amount (balanceInCash, payment, '+');
	}

	public Amount getBalanceInCash() {
		return balanceInCash;
	}

}
