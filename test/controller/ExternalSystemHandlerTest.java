package controller;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.controller.ExternalSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;
import se.kth.ood.daniel.duner.procesSale.model.Item;
import se.kth.ood.daniel.duner.procesSale.model.Sale;
import se.kth.ood.daniel.duner.procesSale.model.SaleDTO;

public class ExternalSystemHandlerTest {
	private AccountingSystemHandler accSys;
	
	private CustomerRegisterHandler cusReg;
	private InventorySystemHandler invSys;
	private PrintingSystemHandler priSys;
	private ExternalSystemHandler eSH;
	private CashRegister cashReg;
	private Amount payment;
	private Sale sale;
	private Item item;
	private SaleDTO saleDTO;
	
	@Before
	public void setUp() throws Exception {
		accSys = new AccountingSystemHandler();	
		cusReg = new CustomerRegisterHandler();
		invSys = new InventorySystemHandler();
		priSys = new PrintingSystemHandler();
		cashReg = new CashRegister();
		eSH = new ExternalSystemHandler(accSys, cusReg, invSys, priSys);
		sale = new Sale(1);
		item = new Item(1101, new Amount(2), "description", "name");
		sale.addItem(item);
		sale.endRegistration();
		payment = new Amount(3);
		sale.registerPayment(payment, cashReg);
		saleDTO = new SaleDTO(sale);
	}
	@After
	public void tearDown() {
		accSys = null;
		cusReg = null;
		invSys = null;
		priSys = null;
		cashReg = null;
		eSH = null;
		sale = null;
		item = null;
		payment = null;
	}
	@Test
	public void testGetLatestSaleId() {
		assertTrue("Should be 0 at initiation",eSH.getLastSaleId() == 0);
	}
	@Test
	public void testRegisterCompleteSale() {
		eSH.registerCompletedSale(saleDTO);
		assertTrue("Should be 0 at initiation",eSH.getLastSaleId() == 1);
	}

}
