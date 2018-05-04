package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.model.Amount;
import se.kth.oop.daniel.duner.procesSale.model.MEMLVL;
import se.kth.oop.daniel.duner.procesSale.model.Membership;
import se.kth.oop.daniel.duner.procesSale.model.TotalCost;

public class TotalCostTest {
	private TotalCost totCost;
	
	@Before
	public void setUp() throws Exception {
		totCost = new TotalCost();
	}

	@After
	public void tearDown() throws Exception {
		totCost = null;
	}

	@Test
	public void testInstantiatedCorrectly() throws Exception {
		assertEquals("",0,totCost.getTotalAmount().getAmount(),0-totCost.getTotalAmount().getAmount());
		assertEquals("",0,totCost.getDiscountAmount().getAmount(),0-totCost.getDiscountAmount().getAmount());
		assertEquals("",0,totCost.getTaxAmount().getAmount(),0-totCost.getTaxAmount().getAmount());
	}
	
	@Test
	public void testToString() throws Exception {
		String expResult = "Discount amount: SEK 0,00:-\nVAT amount: SEK 0,00:-\nTotal amount inkl. discounts and VAT: SEK 0,00:-\n"; 
		assertEquals("Not converted correctly to string",expResult,totCost.toString());
	}
	@Test
	public void testSetTotalCostWithNoDiscount() throws Exception {
		Amount price = new Amount(100);
		totCost.setTotalCost(price);
		double delta = 100-totCost.getDiscountAmount().getAmount();
		assertEquals("Set Total Cost does not correctly set the new amount without discount",100,totCost.getDiscountAmount().getAmount(),delta);
	}
	
	@Test
	public void testSetDiscountEligibility() throws Exception {
		Membership memb = new Membership(true,MEMLVL.GOLD);
		Amount price = new Amount(100);
		totCost.setDiscountEligibility(memb, price);
		assertTrue("Added membership is not setting discount eligibility correct",totCost.getMembership().getMembership());
	}
	

}
