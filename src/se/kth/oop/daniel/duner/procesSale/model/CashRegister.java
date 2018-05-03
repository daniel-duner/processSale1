package se.kth.oop.daniel.duner.procesSale.model;

import se.kth.oop.daniel.duner.procesSale.integration.Amount;

public class CashRegister {
	private Amount balanceInCash;
/**
 * Instantiates a cash register with 1000 in balance
 * @param currency	represents the currency chosen for the cash in the cash register 
 * @throws Exception
 */
	public CashRegister(String currency) throws Exception {
		balanceInCash = new Amount(1000);
	}
/**
 * Adds an amount of money to the balance from a payment
 * @param payment represents the cost of the whole sale
 * @throws Exception
 */
	public void addPayment(Amount payment) throws Exception {
		balanceInCash = new Amount (balanceInCash, payment, '+');
	}

	public Amount getBalanceInCash() {
		return balanceInCash;
	}

}
