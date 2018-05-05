package se.kth.ood.daniel.duner.procesSale.controller;

import se.kth.ood.daniel.duner.procesSale.integration.AccountingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.CustomerRegisterHandler;
import se.kth.ood.daniel.duner.procesSale.integration.InventorySystemHandler;
import se.kth.ood.daniel.duner.procesSale.integration.PrintingSystemHandler;
import se.kth.ood.daniel.duner.procesSale.model.Customer;
import se.kth.ood.daniel.duner.procesSale.model.Item;
import se.kth.ood.daniel.duner.procesSale.model.Membership;
import se.kth.ood.daniel.duner.procesSale.model.SaleDTO;
/**
 * Handles commands to the external systems that are connected to this system.
 * @author danielduner
 *
 */
public class ExternalSystemHandler {
	private AccountingSystemHandler accountingSystemHandler;
	private CustomerRegisterHandler customerRegisterHandler;
	private InventorySystemHandler inventoryHandler;
	private PrintingSystemHandler printingSystemHandler;
	
	/**
	 * 
	 * Instantiates the External system handler
	 * 
	 * @param accountingSystemHandler represents the external accounting system
	 * @param customerRegisterHandler represents the customer register
	 * @param inventoryHandler represents the inventory system
	 * @param printingSystemHandler represents the printing system
	 */
	public ExternalSystemHandler(AccountingSystemHandler accountingSystemHandler,
			CustomerRegisterHandler customerRegisterHandler, InventorySystemHandler inventoryHandler, PrintingSystemHandler printingSystemHandler){
		this.accountingSystemHandler = accountingSystemHandler;
		this.customerRegisterHandler = customerRegisterHandler;
		this.inventoryHandler = inventoryHandler;
		this.printingSystemHandler = printingSystemHandler;
	}
	
	/**
	 * 
	 * returns the sale ID of the last sale
	 * 
	 * @return returns int representing the last sale ID
	 */
	public int getLastSaleId() {
		return accountingSystemHandler.getLastSaleId();
	}
	/**
	 * 
	 * returns the sale ID of the last sale
	 * 
	 * @return returns int representing the last sale ID
	 */
	public int getNextSaleId() {
		return accountingSystemHandler.getNextSaleId();
	}
	
	/**
	 * 
	 * Register that the sale is completed
	 * 
	 * @param saleDTO contains all information about the sale
	 */
	public void registerCompletedSale(SaleDTO saleDTO) {
		accountingSystemHandler.registerCompletedSale(saleDTO);
		registerSoldItemsInInventory(saleDTO);
		printReceipt(saleDTO);
	}
	
	/**
	 * 
	 * Searches the customer register after a matching ID
	 * 
	 * @param customerId a 8 digit code
	 * @return returns membership information
	 */
	public Membership findCustomer(int customerId) {
		return customerRegisterHandler.searchCustomer(customerId);
	}
	
	/**
	 * 
	 * Searches after an Item with an item ID in the inventory
	 * 
	 * @param itemId represents a searched Item ID
	 * @return returns an Item representing the information of the item searched
	 * @throws Exception
	 */
	public Item findItem (int itemId) throws Exception {
		return inventoryHandler.findItem(itemId);
	}
	
	private void registerSoldItemsInInventory(SaleDTO saleDTO) {
		inventoryHandler.updateInventory(saleDTO);
	}
	private void printReceipt(SaleDTO saleDTO) {
		printingSystemHandler.printReceipt(saleDTO);
	}
	
}
