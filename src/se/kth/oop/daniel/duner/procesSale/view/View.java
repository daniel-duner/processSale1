package se.kth.oop.daniel.duner.procesSale.view;

import static java.lang.System.out;

import se.kth.oop.daniel.duner.procesSale.controller.Controller;
import se.kth.oop.daniel.duner.procesSale.database.AccountingSystem;
import se.kth.oop.daniel.duner.procesSale.database.CustomerRegister;
import se.kth.oop.daniel.duner.procesSale.database.InventorySystem;
import se.kth.oop.daniel.duner.procesSale.database.PrintingSystem;
import se.kth.oop.daniel.duner.procesSale.integration.Amount;
import se.kth.oop.daniel.duner.procesSale.integration.ExternalSystemHandler;
import se.kth.oop.daniel.duner.procesSale.model.CashRegister;
import se.kth.oop.daniel.duner.procesSale.model.SaleInformationDTO;

/**
 * Represents the GUI
 * 
 * @author danielduner
 *
 */
public class View {

	/**
	 * the input cart
	 */
	private int[] cart;

	public View() {
		cart = new int[3];
		cart[0] = 1101;
		cart[1] = 1103;
		cart[2] = 1106;
	}

	/**
	 * the visualization of running total in view
	 * 
	 * @param saleInformationDTO
	 *            the saleInformation needed to print the running total
	 */
	public static void runningTotal(SaleInformationDTO saleInformationDTO) {
		Amount runningTotal = saleInformationDTO.getRunningTotal();
		Amount itemPrice = saleInformationDTO.getItemPrice();
		boolean itemValid = saleInformationDTO.getItemValid();
		String itemName = saleInformationDTO.getItemName();
		int quantity = saleInformationDTO.getQuantity();
		int currentProductNo = saleInformationDTO.getNoOnList();

		if (itemValid) {
			out.println("Product " + currentProductNo + ": " + itemName + " - QTY " + "[" + quantity + "]"
					+ " - Price ea. " + itemPrice);
			out.println("Running Total: " + runningTotal + "\n");
		} else {
			out.println("Invalid Item Id, does not exist in the inventory, item excluded from the sale");
			out.println("Running Total: " + runningTotal + "\n");
		}
	}
	/**
	 *  
	 *  returns the cart with all items to be scanned to the caller
	 *  
	 * @return
	 */
	public int[] getCart() {
		return cart;
	}

}
