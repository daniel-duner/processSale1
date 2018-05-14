package se.kth.ood.daniel.duner.procesSale.startup;

import se.kth.ood.daniel.duner.procesSale.controller.Controller;
import se.kth.ood.daniel.duner.procesSale.controller.ExternalSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;
import se.kth.ood.daniel.duner.procesSale.model.TotalRevenue;
import se.kth.ood.daniel.duner.procesSale.view.TotalRevenueView;
import se.kth.ood.daniel.duner.procesSale.view.View;

/**
 * Initiates all systems that are constant through the systems start
 * 
 * View is removed, since it is the main method in this scenario without a GUI
 * @author danielduner
 *
 */

public class Main {
		
	public static void main(String args[])throws Exception {
		
		TotalRevenue totalRevenue = TotalRevenue.getInstance();
		TotalRevenueView totalRevenueView = new TotalRevenueView();
		totalRevenue.addObserver(totalRevenueView);
		AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
		CustomerRegisterHandler customerRegisterHandler = new CustomerRegisterHandler();
		InventorySystemHandler inventoryHandler = new InventorySystemHandler();
		PrintingSystemHandler printingSystemHandler = new PrintingSystemHandler();
		CashRegister cashRegister = new CashRegister();
		ExternalSystemHandler externalSystemHandler = new ExternalSystemHandler(accountingSystemHandler, customerRegisterHandler, inventoryHandler, printingSystemHandler);
		Controller controller = new Controller(externalSystemHandler,cashRegister);
		View view = new View(controller, totalRevenueView);
		view.processSale();
		view.processSale();
		
	
	}
}
