package se.kth.oop.daniel.duner.procesSale.test.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.InvalidAmountException;
import se.kth.oop.daniel.duner.procesSale.integration.Amount;
import se.kth.oop.daniel.duner.procesSale.integration.CURRENCY;

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
	@Test(expected=Exception.class)
	public void testCreatingAmountIncorrect() throws Exception {
	 new Amount(-1);
	}
	@Test
	public void testCreatingAmountCorrectAdding() throws Exception {
		Amount newAmount = new Amount(AmountOneInSEK, AmountOneInSEK,'+');
		double expResult = 2;
		double result = newAmount.getAmount();
		double delta = expResult-result;
		assertEquals("Object should be created with added value",expResult, result,delta);
	}
	
	@Test
	public void testCreatingAmountCorrectSubtracting() throws Exception {
		Amount newAmount = new Amount(AmountOneInSEK, AmountOneInSEK,'-');
		double expResult = 0;
		double result = newAmount.getAmount();
		double delta = expResult-result;
		assertEquals("Object should be created with subtracted value",expResult, result,delta);
	}
	
	@Test(expected=Exception.class)
	public void testCreatingAmountNegative() throws Exception {
		new Amount(AmountOneInSEK, AmountTwoInSEK,'-');	
	}
	@Test(expected=Exception.class)
	public void testIncorrectOperation() throws Exception {
		new Amount(AmountOneInSEK, AmountTwoInSEK,'*');	
	}
	
	@Test
	public void testCreatingAmountwithoutArguments() throws Exception {
		Amount testAmount = new Amount();
		assertTrue("Verifies that amount is 0", testAmount.getAmount()==0);
		assertTrue("verifies that currency is SEK", testAmount.getCurrency() == CURRENCY.SEK);
	}
	
	
	
	@Test
	public void testToString() {
		String result = AmountOneInSEK.toString();
		String expResult = "SEK 1,00:-";
		assertEquals("The String shoould be \"SEK 1,00:-\"",result, expResult);
	}
}
