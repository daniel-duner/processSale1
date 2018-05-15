package se.kth.ood.daniel.duner.procesSale.controller;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

import se.kth.ood.daniel.duner.procesSale.integration.ItemNotFoundException;
import se.kth.ood.daniel.duner.procesSale.model.Amount;
import se.kth.ood.daniel.duner.procesSale.model.CashRegister;
import se.kth.ood.daniel.duner.procesSale.model.InvalidAmountException;
import se.kth.ood.daniel.duner.procesSale.model.InvalidCharException;
import se.kth.ood.daniel.duner.procesSale.model.InvalidStringException;
import se.kth.ood.daniel.duner.procesSale.model.Item;
import se.kth.ood.daniel.duner.procesSale.model.Membership;
import se.kth.ood.daniel.duner.procesSale.model.Sale;
import se.kth.ood.daniel.duner.procesSale.model.SaleInformationDTO;
import se.kth.ood.daniel.duner.procesSale.model.TotalCost;

/**
 * Takes inputs from <View> and delegates operations to the other classes
 * 
 * @author danielduner
 *
 */
public class Controller {
	private Sale sale;
	private ExternalSystemHandler externalSystemHandler;
	private CashRegister cashRegister;	

	/**
	 * Creates a new instance of Controller, representing the controller
	 * 
	 * @param externalSystemHandler Represents the system that handles communication with external systems
	 * @param cashRegister Represents the system keeping track of the balance in cash
	 */
	public Controller(ExternalSystemHandler externalSystemHandler, CashRegister cashRegister) {
		this.externalSystemHandler = externalSystemHandler;
		this.cashRegister = cashRegister;	
	}
	
	/**
	 * Starts a new Sale and is issued in the beginning of a sale process
	 * @throws Exception
	 */
	public void startNewSale() throws InvalidStringException, InvalidAmountException, FileNotFoundException, 
	UnsupportedEncodingException, InvalidCharException {
		sale = new Sale(externalSystemHandler.getNextSaleId());
	}

	/**
	 * Registers an item to the sale, adding it to the goods being sold
	 * 
	 * @param itemId represents item identification number, used to search after item in the inventorySystem
	 * @return return returns information object about a sale
	 * @throws Exception
	 */

	public SaleInformationDTO registerItem(int itemId) throws ItemNotFoundException, InvalidStringException, 
	InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		return sale.addItem(externalSystemHandler.findItem(itemId));
	}

	/**
	 * Registers multiple Items to the sale, adding them to the goods being sold
	 * 
	 * @param itemId represents item identification number, used to search after item in the inventorySystem
	 * @param quantity represents the quantity of the item
	 * @return return returns information object about a sale
	 * @throws Exception
	 */

	public SaleInformationDTO registerMultipleItems(int itemId, int quantity) throws ItemNotFoundException,
	InvalidStringException, InvalidAmountException, FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		return sale.addMultipleItems(externalSystemHandler.findItem(itemId), quantity);
	}

	/**
	 * Ends registration and returns information about the total Cost
	 * @return information about the total cost
	 * @throws Exception
	 */

	public TotalCost endRegistration() throws InvalidStringException, InvalidAmountException, 
	FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		return sale.endRegistration();
	}

	/**
	 * Registers payment in the system and returns the change to the caller
	 * @param payment represents a payment
	 * @return return returns the change
	 * @throws Exception
	 */

	public Amount registerPayment(Amount payment) throws InvalidStringException, InvalidAmountException, 
	FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		Amount change = sale.registerPayment(payment, cashRegister);
		sale.endSale(externalSystemHandler);
		return change;
	}

	/**
	 * requests a check if customer is eligible for discount and returns updated
	 * total cost including potential discount
	 * @param customerId the id of the customer which is asking for a discount
	 * @return returns the totalCost including tax and if eligible including discount
	 * @throws Exception
	 */

	public TotalCost requestDiscount(int customerId) throws InvalidStringException, InvalidAmountException, 
	FileNotFoundException, UnsupportedEncodingException, InvalidCharException {
		Membership membership = externalSystemHandler.findCustomer(customerId);
		sale.setDiscountEligibility(membership);
		return sale.getTotalCost();
	}

}
