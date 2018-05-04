package se.kth.oop.daniel.duner.procesSale.test.integration;

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
import se.kth.oop.daniel.duner.procesSale.model.Payment;
import se.kth.oop.daniel.duner.procesSale.model.Sale;
import se.kth.oop.daniel.duner.procesSale.model.SaleDTO;

public class PrintingSystemHandlerTest {
	private CashRegister cashReg;
	private Amount payment;
	private Sale sale;
	private Item item;
	private SaleDTO saleDTO;
	PrintingSystemHandler pSH;
	@Before
	public void setUp() throws Exception {
		cashReg = new CashRegister();
		sale = new Sale(1);
		item = new Item(1101, new Amount(2), "description", "name");
		item.setItemExistTrue();
		sale.addItem(item);
		sale.endRegistration();
		payment = new Amount(3);
		sale.registerPayment(payment, cashReg);
		saleDTO = new SaleDTO(sale);
	}

	@After
	public void tearDown() throws Exception {
		sale = null;
		item = null;
		saleDTO = null;
		pSH = null;
		cashReg = null;
	}

	@Test
	public void testPrintReceipt() {
		pSH = new PrintingSystemHandler();
		pSH.printReceipt(saleDTO);
	}

}
