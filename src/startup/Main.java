package startup;

import controller.Controller;
import database.AccountingSystem;
import database.CustomerRegister;
import database.Inventory;
import database.PrintingSystem;
import integration.ExternalSystemHandler;
import model.CashRegister;
import view.View;

/**
 * Initiates all systems that are constant through the systems start
 * 
 * View is removed, since it is the main method in this scenario without a GUI
 * @author danielduner
 *
 */

public class Main {
	//View view;
	AccountingSystem accountingSystem;
	CustomerRegister customerRegister;
	Inventory inventory;
	PrintingSystem printingSystem;
	CashRegister cashRegister;
	ExternalSystemHandler externalSystemHandler;
	
	Controller controller;
	
	public Main()throws Exception {
		//View view = new View();
		AccountingSystem accountingSystem = new AccountingSystem();
		CustomerRegister customerRegister = new CustomerRegister();
		Inventory inventory = new Inventory();
		PrintingSystem printingSystem = new PrintingSystem();
		CashRegister cashRegister = new CashRegister("SEK");
		ExternalSystemHandler externalSystemHandler = new ExternalSystemHandler(accountingSystem, customerRegister, inventory, printingSystem);
		
		Controller controller = new Controller(externalSystemHandler,cashRegister);
		
	}
}
