package se.kth.oop.daniel.duner.procesSale.integration;

import se.kth.oop.daniel.duner.procesSale.database.AccountingSystem;
import se.kth.oop.daniel.duner.procesSale.database.CustomerRegister;
import se.kth.oop.daniel.duner.procesSale.database.InventorySystem;
import se.kth.oop.daniel.duner.procesSale.database.PrintingSystem;
import se.kth.oop.daniel.duner.procesSale.model.Customer;
import se.kth.oop.daniel.duner.procesSale.model.Membership;
import se.kth.oop.daniel.duner.procesSale.model.SaleDTO;
/**
 * Handles commands to the external systems that are connected to this system.
 * @author danielduner
 *
 */
public class ExternalSystemHandler {
	private AccountingSystem accountingSystem;
	private CustomerRegister customerRegister;
	private InventorySystem inventory;
	private PrintingSystem printingSystem;
	
	/**
	 * 
	 * Instantiates the External system handler
	 * 
	 * @param accountingSystem represents the external accounting system
	 * @param customerRegister represents the customer register
	 * @param inventory represents the inventory system
	 * @param printingSystem represents the printing system
	 */
	public ExternalSystemHandler(AccountingSystem accountingSystem,
			CustomerRegister customerRegister, InventorySystem inventory, PrintingSystem printingSystem){
		this.accountingSystem = accountingSystem;
		this.customerRegister = customerRegister;
		this.inventory = inventory;
		this.printingSystem = printingSystem;
	}
	
	/**
	 * 
	 * returns the sale ID of the last sale
	 * 
	 * @return returns int representing the last sale ID
	 */
	public int getLatestSaleId() {
		return accountingSystem.getLatestSaleId();
	}
	
	/**
	 * 
	 * Register that the sale is completed
	 * 
	 * @param saleDTO contains all information about the sale
	 */
	public void registerCompletedSale(SaleDTO saleDTO) {
		accountingSystem.registerCompletedSale(saleDTO);
		registerSoldItemsInInventory(saleDTO);
		printReceipt(saleDTO);
	}
	
	/**
	 * 
	 * Searches the customer register aftera a matching ID
	 * 
	 * @param customerId a 8 digit code
	 * @return returns membership information
	 */
	public Membership findCustomer(int customerId) {
		return customerRegister.searchCustomer(customerId);
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
		return inventory.findItem(itemId);
	}
	
	private void registerSoldItemsInInventory(SaleDTO saleDTO) {
		inventory.updateInventory(saleDTO);
	}
	private void printReceipt(SaleDTO saleDTO) {
		printingSystem.printReceipt(saleDTO);
	}
	
}
