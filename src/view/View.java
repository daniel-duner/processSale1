package view;

import startup.Main;
import static java.lang.System.*;

import controller.Controller;
import database.AccountingSystem;
import database.CustomerRegister;
import database.Inventory;
import database.PrintingSystem;
import integration.ExternalSystemHandler;
import model.Amount;
import model.CashRegister;
import model.SaleInformationDTO;

public class View {
	public static void main(String[] args) throws Exception {
		AccountingSystem accountingSystem = new AccountingSystem();
		CustomerRegister customerRegister = new CustomerRegister();
		Inventory inventory = new Inventory();
		PrintingSystem printingSystem = new PrintingSystem();
		CashRegister cashRegister = new CashRegister("SEK");
		ExternalSystemHandler externalSystemHandler = new ExternalSystemHandler(accountingSystem, customerRegister, inventory, printingSystem);
		Controller controller = new Controller(externalSystemHandler,cashRegister);
		
		int[] items = createItemIdsInCart();
		out.println("Customer comes to the checkout with goods and the cashier initiates a new sale");
		//Customer starts a new sale
		controller.startNewSale();
		//Scanning items
		out.println("Cashier recevies item and starts to register them");
		out.println("First itemId code (exists in inventory) code is 1101 \n");
		runningTotal(controller.registerItem(items[0]), 1);
		runningTotal(controller.registerItem(items[1]), 2);
		runningTotal(controller.registerItem(items[1]), 3);
		runningTotal(controller.registerItem(items[1]), 3);
		runningTotal(controller.registerItem(items[2]), 4);
		
	}
	
	public static int[] createItemIdsInCart() {
		int[] cart = new int[3];
		cart[0] = 1101;
		cart[1] = 1103;
		cart[2] = 1106;
		return cart;
	}
	
	public static void runningTotal(SaleInformationDTO saleInformationDTO, int currentItemNo) {
		Amount runningTotal = saleInformationDTO.getRunningTotal();
		Amount itemPrice = saleInformationDTO.getItemPrice();
		boolean itemValid = saleInformationDTO.getItemValid();
		String itemName = saleInformationDTO.getItemName();
		
		if (itemValid) {
			out.println("Product: "+ itemName + " price: " + itemPrice + "\n");
			out.println("Running Total: " + runningTotal+"\n");
		}
		else {
			out.println("Invalid Item Id, does not exist in the inventory");
			out.println("Running Total: " + runningTotal + "\n");
		}
	}
	

}
