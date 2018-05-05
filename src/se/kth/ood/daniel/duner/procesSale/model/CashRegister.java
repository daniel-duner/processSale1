package se.kth.ood.daniel.duner.procesSale.model;

public class CashRegister {
	private Amount balanceInCash;
/**
 * Instantiates a cash register with 1000 in balance
 * @throws Exception
 */
	public CashRegister() throws Exception {
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
