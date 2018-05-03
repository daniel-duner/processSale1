package se.kth.oop.daniel.duner.procesSale.startup;

import static java.lang.System.out;

import se.kth.oop.daniel.duner.procesSale.controller.Controller;
import se.kth.oop.daniel.duner.procesSale.database.AccountingSystem;
import se.kth.oop.daniel.duner.procesSale.database.CustomerRegister;
import se.kth.oop.daniel.duner.procesSale.database.InventorySystem;
import se.kth.oop.daniel.duner.procesSale.database.PrintingSystem;
import se.kth.oop.daniel.duner.procesSale.integration.Amount;
import se.kth.oop.daniel.duner.procesSale.integration.ExternalSystemHandler;
import se.kth.oop.daniel.duner.procesSale.model.CashRegister;
import se.kth.oop.daniel.duner.procesSale.view.View;

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
	InventorySystem inventory;
	PrintingSystem printingSystem;
	CashRegister cashRegister;
	ExternalSystemHandler externalSystemHandler;
	Controller controller;
		
	public static void main(String args[])throws Exception {
		View view = new View();
		AccountingSystem accountingSystem = new AccountingSystem();
		CustomerRegister customerRegister = new CustomerRegister();
		InventorySystem inventory = new InventorySystem();
		PrintingSystem printingSystem = new PrintingSystem();
		CashRegister cashRegister = new CashRegister("SEK");
		ExternalSystemHandler externalSystemHandler = new ExternalSystemHandler(accountingSystem, customerRegister, inventory, printingSystem);
		
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
