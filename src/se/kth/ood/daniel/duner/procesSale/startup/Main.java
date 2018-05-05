package se.kth.ood.daniel.duner.procesSale.startup;

import static java.lang.System.out;

import se.kth.ood.daniel.duner.procesSale.controller.Controller;
import se.kth.ood.daniel.duner.procesSale.controller.ExternalSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;
import se.kth.ood.daniel.duner.procesSale.view.View;

/**
 * Initiates all systems that are constant through the systems start
 * 
 * View is removed, since it is the main method in this scenario without a GUI
 * @author danielduner
 *
 */

public class Main {
	//View view;
	AccountingSystemHandler accountingSystemHandler;
	CustomerRegisterHandler customerRegisterHandler;
	InventorySystemHandler inventoryHandler;
	PrintingSystemHandler printingSystemHandler;
	CashRegister cashRegister;
	ExternalSystemHandler externalSystemHandler;
	Controller controller;
		
	public static void main(String args[])throws Exception {
		View view = new View();
		AccountingSystemHandler accountingSystemHandler = new AccountingSystemHandler();
		CustomerRegisterHandler customerRegisterHandler = new CustomerRegisterHandler();
		InventorySystemHandler inventoryHandler = new InventorySystemHandler();
		PrintingSystemHandler printingSystemHandler = new PrintingSystemHandler();
		CashRegister cashRegister = new CashRegister();
		ExternalSystemHandler externalSystemHandler = new ExternalSystemHandler(accountingSystemHandler, customerRegisterHandler, inventoryHandler, printingSystemHandler);
		
		Controller controller = new Controller(externalSystemHandler,cashRegister);

		int[] items = view.getCart();
		out.println("Customer comes to the checkout with goods and the cashier initiates a new sale".toUpperCase());
		controller.startNewSale();
		out.println("Cashier recevies item and starts to register them \n".toUpperCase());
		out.println("--------------------------------------------\n");
		View.runningTotal(controller.registerItem(items[0]));
		View.runningTotal(controller.registerItem(items[1]));
		View.runningTotal(controller.registerItem(items[1]));
		View.runningTotal(controller.registerItem(items[1]));
		View.runningTotal(controller.registerItem(items[2]));
		View.runningTotal(controller.registerMultipleItems(items[0], 2));
		out.println("--------------------------------------------\n");
		out.println("All items are registered and Cashier tells the system that the registration i done\n".toUpperCase());
		out.println("--------------------------------------------\n");
		out.println(controller.endRegistration());
		out.println("--------------------------------------------\n");
		out.println("The Customer asks for discount and shows it personal identification and the cashier writes in the 8 digit code \n".toUpperCase());
		int customerId = 01010101;
		out.println("--------------------------------------------\n");
		out.println(controller.requestDiscount(customerId).getMembership());
		out.println(controller.requestDiscount(customerId));
		out.println("--------------------------------------------\n");
		out.println("Customer pays in cash and the Cashier registers payment \n".toUpperCase());
		Amount payment = new Amount(1500);
		controller.registerPayment(payment);
		
	}
}
