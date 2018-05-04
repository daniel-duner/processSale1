package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.model.Amount;
import se.kth.oop.daniel.duner.procesSale.model.CashRegister;
import se.kth.oop.daniel.duner.procesSale.model.Payment;
import se.kth.oop.daniel.duner.procesSale.model.TotalCost;

public class PaymentTest {
	private CashRegister cashRegister;
	private TotalCost totalCost;
	private Amount payment;
	
	@Before
	public void setUp() throws Exception {
		this.cashRegister = new CashRegister();
		this.payment = new Amount(2);
		Amount cost = new Amount(1);
		this.totalCost = new TotalCost();
		this.totalCost.setTotalCost(cost);
	}
	@After
	public void tearDown() {
		this.cashRegister = null;
		this.payment = null;
		this.totalCost = null;
	}
	
	@Test
	public void correctChangeCalculatiOnOnconstructionTest() throws Exception {
		Payment newPayment = new Payment(payment, totalCost, cashRegister);
		double expResult = 1;
		double result = newPayment.getChange().getAmount();
		double delta = 1-newPayment.getChange().getAmount();
		
		assertEquals("",expResult,result, delta);
	}

}
