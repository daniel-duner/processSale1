package view;

import static java.lang.System.out;

import controller.Controller;
import database.AccountingSystem;
import database.CustomerRegister;
import database.InventorySystem;
import database.PrintingSystem;
import integration.ExternalSystemHandler;
import model.Amount;
import model.CashRegister;
import model.SaleInformationDTO;

public class View {
	public static void main(String[] args) throws Exception {
		AccountingSystem accountingSystem = new AccountingSystem();
		CustomerRegister customerRegister = new CustomerRegister();
		InventorySystem inventory = new InventorySystem();
		PrintingSystem printingSystem = new PrintingSystem();
		CashRegister cashRegister = new CashRegister("SEK");
		ExternalSystemHandler externalSystemHandler = new ExternalSystemHandler(accountingSystem, customerRegister,
				inventory, printingSystem);
		Controller controller = new Controller(externalSystemHandler, cashRegister);

		int[] items = createItemIdsInCart();
		out.println("Customer comes to the checkout with goods and the cashier initiates a new sale".toUpperCase());
		// Customer starts a new sale
		controller.startNewSale();
		// Scanning items
		out.println("Cashier recevies item and starts to register them \n".toUpperCase());
		out.println("--------------------------------------------\n");
		runningTotal(controller.registerItem(items[0]), 1);
		runningTotal(controller.registerItem(items[1]), 2);
		runningTotal(controller.registerItem(items[1]), 3);
		runningTotal(controller.registerItem(items[1]), 4);
		runningTotal(controller.registerItem(items[2]), 5);
		runningTotal(controller.registerMultipleItems(items[0], 2), 6);
		out.println("--------------------------------------------\n");
		out.println("All items are registered and Cashier tells the system that the registration i done\n".toUpperCase());
		out.println("--------------------------------------------\n");
		out.println(controller.endRegistration());
		out.println("--------------------------------------------\n");
		out.println(
				"The Customer asks for discount and shows it personal identification and the cashier writes in the 8 digit code \n"
						.toUpperCase());
		int customerId = 01010101;
		out.println("--------------------------------------------\n");
		out.println(controller.requestDiscount(customerId).getMembership());
		out.println(controller.requestDiscount(customerId));
		out.println("--------------------------------------------\n");
		out.println("Customer pays in cash and the Cashier registers payment \n".toUpperCase());
		Amount payment = new Amount(1500);
		controller.registerPayment(payment);

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
		int quantity = saleInformationDTO.getQuantity();

		if (itemValid) {
			out.println("Product " + currentItemNo + ": " + itemName + " - QTY " + "[" + quantity + "]"
					+ " - Price ea. " + itemPrice);
			out.println("Running Total: " + runningTotal + "\n");
		} else {
			out.println("Invalid Item Id, does not exist in the inventory, item excluded from the sale");
			out.println("Running Total: " + runningTotal + "\n");
		}
	}

}
