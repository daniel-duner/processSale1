package integration;

import database.AccountingSystem;
import database.CustomerRegister;
import database.Inventory;
import database.PrintingSystem;
import model.Customer;
import model.SaleDTO;
/**
 * Handles commands to the external systems that are connected to this system.
 * @author danielduner
 *
 */
public class ExternalSystemHandler {
	private AccountingSystem accountingSystem;
	private CustomerRegister customerRegister;
	private Inventory inventory;
	private PrintingSystem printingSystem;
	
	public ExternalSystemHandler(AccountingSystem accountingSystem,
			CustomerRegister customerRegister, Inventory inventory, PrintingSystem printingSystem){
		this.accountingSystem = accountingSystem;
		this.customerRegister = customerRegister;
		this.inventory = inventory;
		this.printingSystem = printingSystem;
	}
	public int getLatestSaleId() {
		return accountingSystem.getLatestSaleId();
	}
	public void registerCompletedSale(SaleDTO saleDTO) {
		accountingSystem.registerCompletedSale(saleDTO);
		registerSoldItemsInInventory(saleDTO);
		printReceipt(saleDTO);
	}
	public Membership findCustomer(int customerId) {
		return customerRegister.searchCustomer(customerId);
	}
	
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
