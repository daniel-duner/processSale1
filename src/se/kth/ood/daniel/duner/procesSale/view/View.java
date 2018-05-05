package se.kth.ood.daniel.duner.procesSale.view;

import static java.lang.System.out;

import se.kth.ood.daniel.duner.procesSale.controller.Controller;
import se.kth.ood.daniel.duner.procesSale.controller.ExternalSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;
import se.kth.ood.daniel.duner.procesSale.model.SaleInformationDTO;

/**
 * Represents the GUI
 * 
 * @author danielduner
 *
 */
public class View {

	/**
	 * Representing the cart with items that customer gives the cashier and which the
	 * cashier will scan
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
	 * @param saleInformationDTO  the saleInformation needed to print the running total
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
	 *  returns the cart with all items to be scanned to the caller
	 * @return returns the cart
	 */
	public int[] getCart() {
		return cart;
	}

}
