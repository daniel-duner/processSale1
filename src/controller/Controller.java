package controller;

import integration.ExternalSystemHandler;
import integration.Membership;
import model.Amount;
import model.CashRegister;
import model.Customer;
import model.Sale;
import model.SaleInformationDTO;
import model.TotalCost;

/**
 * Takes inputs from the UI and delegates operations to the other classes
 * 
 * @author danielduner
 *
 */

public class Controller {
	private Sale sale;
	private ExternalSystemHandler externalSystemHandler;
	private CashRegister cashRegister;

	public Controller(ExternalSystemHandler externalSystemHandler, CashRegister cashRegister) {
		this.externalSystemHandler = externalSystemHandler;
		this.cashRegister = cashRegister;
	}

	public void startNewSale() throws Exception {
		sale = new Sale(externalSystemHandler.getLatestSaleId());
	}

	public SaleInformationDTO registerItem(int itemId) throws Exception {
		
		return sale.addItem(externalSystemHandler.findItem(itemId));
	}

	public TotalCost endRegistration() throws Exception {
		return sale.endRegistration();
	}

	public Amount registerPayment(Amount payment) throws Exception {
		Amount change = sale.registerPayment(payment, cashRegister);
		sale.endSale(externalSystemHandler);
		return change;
	}

	public TotalCost requestDiscount(Customer customer) throws Exception {
		Membership membership = externalSystemHandler.findCustomer(customer);
		sale.setDiscountEligibility(membership);
		return sale.getTotalCost();
	}

}
