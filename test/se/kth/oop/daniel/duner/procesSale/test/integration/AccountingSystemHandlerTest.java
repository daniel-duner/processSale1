package se.kth.oop.daniel.duner.procesSale.test.integration;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.oop.daniel.duner.procesSale.model.Amount;
import se.kth.oop.daniel.duner.procesSale.model.Item;
import se.kth.oop.daniel.duner.procesSale.model.Sale;
import se.kth.oop.daniel.duner.procesSale.model.SaleDTO;

public class AccountingSystemHandlerTest {
	private Sale sale;
	private Sale sale2;
	private Item item;
	private SaleDTO saleDTO;
	private SaleDTO saleDTO2;
	private AccountingSystemHandler accSys;
	@Before
	public void setUp() throws Exception {
		sale = new Sale(1);
		sale2 = new Sale(2);
		item = new Item(1101, new Amount(2), "description", "name");
		sale.addItem(item);
		saleDTO = new SaleDTO(sale);
		saleDTO2 = new SaleDTO(sale2);
		accSys = new AccountingSystemHandler();
	}

	@After
	public void tearDown() throws Exception {
		sale = null;
		sale2 = null;
		item = null;
		saleDTO = null;
		saleDTO2 = null;
		accSys = null;
	}

	@Test
	public void testInstatiation() {
		accSys = new AccountingSystemHandler();
		assertTrue("last sale id should be 0",accSys.getLatestSaleId() == 0);	
	}
	
	@Test
	public void testRegisterCompletedSale() {
		accSys.registerCompletedSale(saleDTO);
		accSys.registerCompletedSale(saleDTO2);
		assertTrue("last sale id should be 0",accSys.getLatestSaleId() == 2);
	}
	

}
