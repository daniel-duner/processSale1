package controller;

import integration.Amount;
import integration.ExternalSystemHandler;
import integration.Item;
import model.CashRegister;
import model.Customer;
import model.Membership;
import model.Sale;
import model.SaleInformationDTO;
import model.TotalCost;
import model.TotalCostDTO;

/**
 * Takes inputs from View and delegates operations to the other classes
 * 
 * @author danielduner
 *
 */
public class Controller {
	private Sale sale;
	private ExternalSystemHandler externalSystemHandler;
	private CashRegister cashRegister;

	/**
	 * Instatiate controller
	 * 
	 * @param externalSystemHandler
	 *            - Used to communicate with external systems
	 * @param cashRegister
	 *            - Keeps track of the balance
	 */
	public Controller(ExternalSystemHandler externalSystemHandler, CashRegister cashRegister) {
		this.externalSystemHandler = externalSystemHandler;
		this.cashRegister = cashRegister;
	}

	/**
	 * Starts a new Sale
	 * 
	 * @throws Exception
	 */
	public void startNewSale() throws Exception {
		int newSaleId = externalSystemHandler.getLatestSaleId() + 1;
		sale = new Sale(newSaleId);
	}

	/**
	 * Registers an item in the sale
	 * 
	 * @param itemId
	 *            represents item identification number, used to search after item
	 *            in the inventorySystem
	 * @return return returns information object about a sale
	 * @throws Exception
	 */

	public SaleInformationDTO registerItem(int itemId) throws Exception {
		Item item = externalSystemHandler.findItem(itemId);
		return sale.addItem(item);
	}

	/**
	 * Registers multiple Items in the sale
	 * 
	 * @param itemId
	 *            represents item identification number, used to search after item
	 *            in the inventorySystem
	 * @param quantity
	 *            represents the quantity of the item
	 * @return return returns information object about a sale
	 * @throws Exception
	 */

	public SaleInformationDTO registerMultipleItems(int itemId, int quantity) throws Exception {
		Item item = externalSystemHandler.findItem(itemId);
		return sale.addMultipleItems(item, quantity);
	}

	/**
	 * Ends registration and returns information about the total Cost
	 * 
	 * @return information about the total cost
	 * @throws Exception
	 */

	public TotalCost endRegistration() throws Exception {
		TotalCost totalCost = sale.endRegistration();
		return totalCost;
	}

	/**
	 * 
	 * Registers payment in the system and returns the change
	 * 
	 * @param payment
	 *            represents a payment
	 * @return return returns the change
	 * @throws Exception
	 */

	public Amount registerPayment(Amount payment) throws Exception {
		Amount change = sale.registerPayment(payment, cashRegister);
		sale.endSale(externalSystemHandler);
		return change;
	}

	/**
	 * 
	 * requests a check if customer is eligible for discount and returns updated
	 * total cost including potential discount
	 * 
	 * @param customerId
	 * @return
	 * @throws Exception
	 */

	public TotalCost requestDiscount(int customerId) throws Exception {
		Membership membership = externalSystemHandler.findCustomer(customerId);
		sale.setDiscountEligibility(membership);
		return sale.getTotalCost();
	}

}
