package se.kth.oop.daniel.duner.procesSale.test.model;

import org.junit.Test;

import integration.Amount;
import model.CashRegister;
import model.Payment;
import model.TotalCost;

public class PaymentTest {
	private CashRegister cashRegister;
	private TotalCost totalCost;
	private Amount payment;
	
	@Before
	public void setUp() {
		this.cashRegister = cashRegister;
		this.payment = payment;
		this.totalCost = totalCost;
	}
	
	@Test
	public void correctChangeCalculatiOnOnconstructionTest() {
		Payment payment = new Paymeny()
	}

}
