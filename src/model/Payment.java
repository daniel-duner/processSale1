package model;

public class Payment {
	private CashRegister cashRegister;
	
	private TotalCost totalCost;
	private Amount change;
	private Amount payment;

	public Payment(Amount payment, TotalCost totalCost,CashRegister cashRegister) throws Exception {
		this.cashRegister = cashRegister;
		this.payment = payment;
		this.totalCost = totalCost;
		calculateChange();
		cashRegister.addPayment(new Amount(payment,change,'-'));
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
		change = new Amount(payment, totalCost.getDiscountAmount(), '-');
	}

}
