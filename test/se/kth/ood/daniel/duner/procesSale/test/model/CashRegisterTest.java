package se.kth.ood.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;

public class CashRegisterTest {
	private CashRegister cashReg;
	
	@Before
	public void setUp() throws Exception {
		cashReg = new CashRegister();
	}

	@After
	public void tearDown() throws Exception {
		cashReg = null;
	}

	@Test
	public void testCheckBalanceSetCorrect() {
		assertEquals("Balance is not correctly created",1000,cashReg.getBalanceInCash().getAmount(),1000-cashReg.getBalanceInCash().getAmount());
	}
	@Test
	public void testAddPayment() throws Exception {
		Amount payment = new Amount(100);
		cashReg.addPayment(payment);
		assertEquals("Balance is not correctly created",1100,cashReg.getBalanceInCash().getAmount(),1100-cashReg.getBalanceInCash().getAmount());
	}

}
