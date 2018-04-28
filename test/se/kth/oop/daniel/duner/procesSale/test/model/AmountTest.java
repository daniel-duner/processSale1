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
		AmountOneInSEK = new Amount(1);
		AmountTwoInSEK = new Amount(2);
		AmountTwoInEUR = new Amount(2);
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
		double expResult = 2;
		double actResult = newAmount.getAmount();
		double delta = expResult-actResult;
		assertEquals("Object should be created",expResult, actResult,delta);
	}
}
