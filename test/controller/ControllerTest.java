package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.ood.daniel.duner.procesSale.controller.Controller;
import se.kth.ood.daniel.duner.procesSale.controller.ExternalSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;
import se.kth.ood.daniel.duner.procesSale.model.MEMLVL;
import se.kth.ood.daniel.duner.procesSale.model.SaleInformationDTO;
import se.kth.ood.daniel.duner.procesSale.model.TotalCost;

public class ControllerTest {
	private AccountingSystemHandler accSys;
	private CustomerRegisterHandler cusReg;
	private InventorySystemHandler invSys;
	private PrintingSystemHandler priSys;
	private ExternalSystemHandler eSH;
	private CashRegister cashReg;
	private Controller contr;
	
	@Before
	public void setUp() throws Exception {
		accSys = new AccountingSystemHandler();	
		cusReg = new CustomerRegisterHandler();
		invSys = new InventorySystemHandler();
		priSys = new PrintingSystemHandler();
		cashReg = new CashRegister();
		eSH = new ExternalSystemHandler(accSys, cusReg, invSys, priSys);
		contr = new Controller(eSH,cashReg);
	}
	@After
	public void tearDown() {
		accSys = null;
		cusReg = null;
		invSys = null;
		priSys = null;
		cashReg = null;
		eSH = null;
		contr = null;
	}

	@Test
	public void testInstantiation() {
		contr = new Controller(eSH,cashReg);
		assertNotNull("Verify not null", contr);
	}
	
	@Test
	public void testRegisterItem() throws Exception {
		contr.startNewSale();
		SaleInformationDTO saleInfoDTO = contr.registerItem(1101);
		double result = saleInfoDTO.getItemPrice().getAmount();
		double expResult = 130;
		double delta = expResult-result;
		assertEquals("The set price should be 130",expResult, result, delta);
	}
	
	@Test
	public void testRegisterMultipleItems() throws Exception {
		contr.startNewSale();
		SaleInformationDTO saleInfoDTO = contr.registerMultipleItems(1101, 2);
		double result = saleInfoDTO.getItemPrice().getAmount();
		double expResult = 260;
		double delta = expResult-result;
		assertEquals("The set price should be 260",expResult, result, delta);
		assertTrue("The quantity should be 2",saleInfoDTO.getQuantity()==2);
	}
	
	@Test
	public void testEndRegistration() throws Exception {
		contr.startNewSale();
		contr.registerMultipleItems(1101, 2);
		TotalCost totCost = contr.endRegistration();
		double result = totCost.getTotalAmount().getAmount();
		double expResult = 325;
		double delta = expResult-result;
		assertEquals("The set price should be 325",expResult, result, delta);
	}
	@Test
	public void testRegisterPayment() throws Exception {
		contr.startNewSale();
		Amount change = contr.registerPayment(new Amount(325));
		double result = change.getAmount();
		double expResult = 325;
		double delta = expResult-result;
		assertEquals("The set price should be 325",expResult, result, delta);
	}
	@Test
	public void testRequestDiscount() throws Exception {
		contr.startNewSale();
		TotalCost totCost = contr.requestDiscount(10101010);
		MEMLVL result = totCost.getMembership().getMembershipLevel();
		MEMLVL expResult = MEMLVL.NONE;
		assertEquals("The set membership level should be NONE",expResult, result);
	}
	
	

}
