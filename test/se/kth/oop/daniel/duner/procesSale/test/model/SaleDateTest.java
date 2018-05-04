package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.model.SaleDate;

public class SaleDateTest {
	private SaleDate saleDate;
	@Before
	public void setUp() throws Exception {
		saleDate = new SaleDate();
	}

	@After
	public void tearDown() throws Exception {
		saleDate = null;
	}

	@Test
	public void testInstantiatedCorrectly() {
		assertTrue("saleDate not set to null",saleDate.getDate() == null);
		assertTrue("StatSaleTime not set to null",saleDate.getStartSaleTime() == null);
		assertTrue("EndOfSaleTime not set to null",saleDate.getEndOfSaleTime() == null);
	}
	@Test
	public void testToString() {
		saleDate.setDate();
		saleDate.setStartSaleTime();
		saleDate.setEndOfSaleTime();
		String expResult = "Date of sale: " + saleDate.getDate() + "\n"+"Sale started: " 
		+ saleDate.getStartSaleTime() + "\n"+"Sale ended: " + saleDate.getEndOfSaleTime() + "\n";
		assertEquals("SaleDate not correctly converted to string",expResult, saleDate.toString());
		
		
		
	}

}
