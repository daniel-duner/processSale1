package model;

public class CashRegister {
	private Amount balanceInCash;

	public CashRegister(String currency) throws Exception {
		balanceInCash = new Amount(1000);
	}

	public void addPayment(Amount payment) throws Exception {
		balanceInCash = new Amount (balanceInCash, payment, '+');
	}

	public Amount getBalanceInCash() {
		return balanceInCash;
	}

}
