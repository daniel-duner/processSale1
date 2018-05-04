package se.kth.oop.daniel.duner.procesSale.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.controller.ExternalSystemHandler;
import se.kth.oop.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.oop.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.oop.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.oop.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.oop.daniel.duner.procesSale.model.Amount;
import se.kth.oop.daniel.duner.procesSale.model.CashRegister;
import se.kth.oop.daniel.duner.procesSale.model.Item;
import se.kth.oop.daniel.duner.procesSale.model.MEMLVL;
import se.kth.oop.daniel.duner.procesSale.model.Membership;
import se.kth.oop.daniel.duner.procesSale.model.Sale;

public class SaleTest {
	private Sale sale;
	private Item item;

	@Before
	public void setUp() throws Exception {
		sale = new Sale(1);
		item = new Item(1101, new Amount(2), "description", "name");
		item.setItemExistTrue();
	}

	@After
	public void tearDown() throws Exception {
		sale = null;
		item = null;
	}

	@Test
	public void testInstantitedCorrectly() throws Exception {
		sale = new Sale(2);
		assertNotNull("Goods should not be null", sale.getGoods());
		assertNotNull("SaleDate should not be null", sale.getSaleDate());
		assertTrue("SaleId should not be null", sale.getSaleId() == 2);
		assertNotNull("SaleInformation should not be null", sale.getSaleInformation());
		assertNotNull("TotalCost should not be null", sale.getTotalCost());
	}

	@Test
	public void testAddItemItemValid() throws Exception {
		sale.addItem(item);
		assertTrue("item is not added to sale correctly", sale.getGoods().getItems().length == 1);
	}

	@Test
	public void testAddItemItemInvalid() throws Exception {
		item.setItemExistFalse();
		sale.addItem(item);
		assertFalse("item is not added to sale correctly", sale.getGoods().getItems().length == 1);
	}

	@Test
	public void testAddMultipleItemsItemValid() throws Exception {
		sale.addMultipleItems(item, 2);
		assertTrue("item is not added to sale correctly in item array", sale.getGoods().getItems().length == 1);
		assertTrue("item is not added to sale correctly in quantity array", sale.getGoods().getQuantity()[0] == 2);
	}

	@Test
	public void testAddMultipleItemsItemInvalid() throws Exception {
		item.setItemExistFalse();
		sale.addMultipleItems(item, 2);
		assertTrue("item is not added to sale correctly in item array", sale.getGoods().getItems().length == 0);
		assertTrue("item is not added to sale correctly in quantity array", sale.getGoods().getQuantity().length == 0);
	}

	@Test
	public void testRegisterPayment() throws Exception {
		Amount payment = new Amount(10);
		CashRegister cashReg = new CashRegister();
		double delta = sale.registerPayment(payment, cashReg).getAmount() - sale.getPayment().getChange().getAmount();
		assertEquals("", sale.registerPayment(payment, cashReg).getAmount(), sale.getPayment().getChange().getAmount(),
				delta);
	}

	@Test (expected = Exception.class)
	public void testEndSale() throws Exception {
		AccountingSystemHandler accSys = new AccountingSystemHandler();
		ExternalSystemHandler eSH = new ExternalSystemHandler(accSys, new CustomerRegisterHandler(),
				new InventorySystemHandler(), new PrintingSystemHandler());
		sale.endSale(eSH);
	}

	@Test
	public void testEndRgistration() throws Exception {
		sale.addItem(item);
		sale.endRegistration();
		double expResult = 2;
		double result = sale.getGoods().getPrice().getAmount();
		double delta = 2 - result;
		assertEquals("The Amount of price should be two", expResult, result, delta);
	}
	@Test
	public void testsetDiscountEligibility() throws Exception {
		Membership membership = new Membership(false, MEMLVL.NONE);
		Membership membership1 = new Membership(true, MEMLVL.GOLD);
		sale.setDiscountEligibility(membership);
		sale.setDiscountEligibility(membership1);
		assertTrue("",sale.getTotalCost().getMembership().getMembership());
		
	}
	
}
