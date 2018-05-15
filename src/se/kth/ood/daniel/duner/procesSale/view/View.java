package se.kth.ood.daniel.duner.procesSale.view;

import static java.lang.System.out;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.controller.Controller;
import se.kth.ood.daniel.duner.procesSale.integration.FailedToConnectException;
import se.kth.ood.daniel.duner.procesSale.integration.ItemNotFoundException;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.InvalidAmountException;
import se.kth.ood.daniel.duner.procesSale.model.InvalidCharException;
import se.kth.ood.daniel.duner.procesSale.model.InvalidStringException;
import se.kth.ood.daniel.duner.procesSale.model.SaleInformationDTO;

/**
 * Represents the GUI
 * 
 * @author danielduner
 *
 */
public class View implements Observer{

	private int[] cart;
	private Controller controller;
	TotalRevenueView totRev;

	public View(Controller controller, TotalRevenueView totRev) {
		cart = new int[3];
		cart[0] = 1101;
		cart[1] = 1103;
		cart[2] = 1106;
		this.controller = controller;
		this.totRev = totRev;
	}
	
	public void processSale() throws ItemNotFoundException, InvalidStringException, InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		out.println("Customer comes to the checkout with goods and the cashier initiates a new sale".toUpperCase());
		controller.startNewSale();
		out.println("Cashier recevies item and starts to register them \n".toUpperCase());
		out.println("--------------------------------------------\n");
		totRev.printDisplay();
		registerItem(cart[0]);
		registerItem(cart[1]);
		registerItem(cart[1]);
		registerItem(cart[1]);
		registerItem(cart[2]);
		registerItem(1111);
		totRev.printDisplay();
		runningTotal(controller.registerMultipleItems(cart[0], 2));
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
	/**
	 * Registers an item, if item is found a running total will be presented on the display else an error message will be printed
	 * @param itemId the searched item id
	 * @throws Exception if the item cannot be found in the inventory
	 */
	public void registerItem(int itemId) throws InvalidStringException, InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		try {
			runningTotal(controller.registerItem(itemId));
		} catch (ItemNotFoundException ItemNotFoundException) {
			System.out.println("The item with the item id: "+itemId+" does not exist, try again\n");
		} catch (FailedToConnectException FailedToConnectException) {
			System.out.println("Failed to connect to the database when searching for the item with the item id: "+itemId+", try again\n");
		}
	}
	

	/**
	 * the visualization of running total in view
	 * @param saleInformationDTO  the saleInformation needed to print the running total
	 */
	private void runningTotal(SaleInformationDTO saleInformationDTO) {
		Amount runningTotal = saleInformationDTO.getRunningTotal();
		Amount itemPrice = saleInformationDTO.getItemPrice();
		String itemName = saleInformationDTO.getItemName();
		int quantity = saleInformationDTO.getQuantity();
		int currentProductNo = saleInformationDTO.getNoOnList();

			out.println("Product " + currentProductNo + ": " + itemName + " - QTY " + "[" + quantity + "]"
					+ " - Price ea. " + itemPrice);
			out.println("Running Total: " + runningTotal + "\n");
	}
		
//			out.println("Invalid Item Id, does not exist in the inventory, item excluded from the sale");
//			out.println("Running Total: " + runningTotal + "\n");
		
	
	/**
	 *  returns the cart with all items to be scanned to the caller
	 * @return returns the cart
	 */
	public int[] getCart() {
		return cart;
	}

@Override
public void update(Amount totalRevenue) {
	// TODO Auto-generated method stub
	
}

}
