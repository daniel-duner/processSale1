package se.kth.ood.daniel.duner.procesSale.integration;

import se.kth.ood.daniel.duner.procesSale.model.SaleDTO;

/**
 * Represents the system that handles the database that stores all sales (HARDCODED)
 * 
 * @author danielduner
 *
 */

public class AccountingSystemHandler {
	private SaleDTO[] saleRegister;
	private int lastSaleId;
	private int nextSaleId;
	
	/**
	 * Instantiates the accounting system
	 */
	public AccountingSystemHandler() {
		saleRegister = new SaleDTO[0];
		lastSaleId = 0;
		nextSaleId = 1;
	}

	/**
	 * register a completed sale in the register and saves the id of the latest sale
	 * 
	 * @param saleDTO holds the information of a completed sale
	 */
	public void registerCompletedSale(SaleDTO saleDTO) {
		updateSaleRegister(saleDTO);
		lastSaleId++;
		nextSaleId++;
	}

	private void updateSaleRegister(SaleDTO saleDTO) {	
		SaleDTO[] newSaleRegister = new SaleDTO[nextSaleId];

		for (int i = 0; i < lastSaleId; i++) {
			newSaleRegister[i] = saleRegister[i];
		}
		newSaleRegister[lastSaleId] = saleDTO;
		saleRegister = newSaleRegister.clone();
	}
/**
 * 
 * returns the ID of the last sale
 * 
 * @return returns latest sale ID
 */
	public int getLastSaleId() {
		return lastSaleId;
	}
	/**
	 * returns the ID of the nextSale
	 * @return
	 */
	public int getNextSaleId() {
		return nextSaleId;
	}
}
