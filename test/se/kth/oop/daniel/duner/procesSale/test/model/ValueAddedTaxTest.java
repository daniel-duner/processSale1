package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.model.ValueAddedTax;

public class ValueAddedTaxTest {
	private ValueAddedTax vAT;
	@Before
	public void setUp() throws Exception {
		vAT = new ValueAddedTax(0.5);
	}

	@After
	public void tearDown() throws Exception {
		vAT = null;
	}

	@Test(expected = Exception.class)
	public void testInvalidAmountException() throws Exception {
		new ValueAddedTax(2);
	}
	@Test(expected = Exception.class)
	public void testCheckAllowedAddedTaxAboveMax() throws Exception {
		vAT.setValueAddedTax(2);

	}
	@Test(expected = Exception.class)
	public void testCheckAllowedAddedTaxBelowMin() throws Exception {
		vAT.setValueAddedTax(-1);
	}
	
	@Test
	public void testInstantiatedCorrectWithArgument() throws Exception {
		vAT = new ValueAddedTax(0.50);
		assertEquals("tax rate instantiated incorrectly",0.50,vAT.getValueAddedTax(),0.50-vAT.getValueAddedTax());
	}
	@Test
	public void testInstantiatedCorrect() throws Exception {
		vAT = new ValueAddedTax();
		assertEquals("tax rate instantiated incorrectly",0.25,vAT.getValueAddedTax(),0.25-vAT.getValueAddedTax());
	}
	@Test
	public void testSetValueAddedTax() throws Exception {
		vAT.setValueAddedTax(0.25);
		assertEquals("tax rate set incorrectly",0.25,vAT.getValueAddedTax(),0.25-vAT.getValueAddedTax());

	}
	
	

}
