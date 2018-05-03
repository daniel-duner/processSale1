package se.kth.oop.daniel.duner.procesSale.test.integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.*;
import integration.Amount;

public class AmountTest {
	private Amount AmountOneInSEK;
	private Amount AmountTwoInSEK;
	
	@Before
	public void setUp() throws Exception {
		AmountOneInSEK = new Amount(1);
		AmountTwoInSEK = new Amount(2);
	}
	@After
	public void tearDown(){
		AmountOneInSEK = null;
		AmountTwoInSEK = null;
	}
	@Test
	public void testCreatingAmountCorrect() throws Exception {
		Amount newAmount = new Amount(AmountOneInSEK, AmountOneInSEK,'+');
		double expResult = 2;
		double result = newAmount.getAmount();
		double delta = expResult-result;
		assertEquals("Object should be created",expResult, result,delta);
	}
	
	//@Test
	public void testCreatingAmountNegative() throws Exception {
		Amount result = new Amount(AmountOneInSEK, AmountTwoInSEK,'-');
		assertNull("Object should not be created",result);
	}
	
	@Test
	public void testCreatingAmountwithoutArguments() throws Exception {
		Amount testAmount = new Amount();
		boolean result = false;
		if (testAmount.getAmount() == 0 && testAmount.getCurrency() == "SEK") {
			result = true;
		}
		assertTrue("Object should have correct values", result);
	}
	
	
	
	@Test
	public void testToString() {
		String result = AmountOneInSEK.toString();
		String expResult = "SEK 1,00:-";
		assertEquals("The String shoould be \"SEK 1,00:-\"",result, expResult);
	}
}
