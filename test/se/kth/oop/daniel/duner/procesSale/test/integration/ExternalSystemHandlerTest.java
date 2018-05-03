package se.kth.oop.daniel.duner.procesSale.test.integration;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se.kth.oop.daniel.duner.procesSale.database.AccountingSystem;
import se.kth.oop.daniel.duner.procesSale.database.CustomerRegister;
import se.kth.oop.daniel.duner.procesSale.database.InventorySystem;
import se.kth.oop.daniel.duner.procesSale.database.PrintingSystem;
import se.kth.oop.daniel.duner.procesSale.integration.ExternalSystemHandler;

public class ExternalSystemHandlerTest {
	private AccountingSystem accSys;
	private CustomerRegister cusReg;
	private InventorySystem invSys;
	private PrintingSystem priSys;
	private ExternalSystemHandler eSH;
	
	@Before
	public void setUp() throws Exception {
		accSys = new AccountingSystem();	
		cusReg = new CustomerRegister();
		invSys = new InventorySystem();
		priSys = new PrintingSystem();
		eSH = new ExternalSystemHandler(accSys, cusReg, invSys, priSys);
	}
	@After
	public void tearDown() {
		accSys = null;
		cusReg = null;
		invSys = null;
		priSys = null;
		eSH = null;
	}
	@Test
	public void test() {
		
	}

}
