package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import exceptions.*;
import model.Amount;

public class AmountTest {
	private Amount AmountOneInSEK;
	private Amount AmountTwoInSEK;
	private Amount AmountTwoInEUR;
	Amount newAmount = null;
	
	@Before
	public void setUp() throws Exception {
		AmountOneInSEK = new Amount(1,"SEK");
		AmountTwoInSEK = new Amount(2,"SEK");
		AmountTwoInEUR = new Amount(2,"EUR");
	}
	@After
	public void tearDown(){
		AmountOneInSEK = null;
		AmountTwoInEUR = null;
		AmountTwoInSEK = null;
	}
	@Test
	public void testCreatingAmountCorrect() throws Exception {
		newAmount = new Amount(AmountOneInSEK, AmountOneInSEK,'+');
		int expResult = 2;
		int actResult = newAmount.getAmount();
		assertEquals("Object should be created",expResult, actResult);
	}
	@Test
	public void testCreatingAmountWithNegativeValue() throws Exception {
		newAmount = new Amount(AmountOneInSEK, AmountTwoInSEK,'-');
		int expResult = 0;
		int actResult = newAmount.getAmount();
		assertTrue("value shall be negative", expResult>actResult);
	}
	@Test
	public void testCreatingAmountFromAmountsWithDifferentCurrecnies() throws Exception {
		newAmount = new Amount(AmountOneInSEK, AmountTwoInEUR,'+');
		int expResult = 0;
		int actResult = newAmount.getAmount();
		assertEquals("value shall be negative", actResult==expResult);
	}


}
