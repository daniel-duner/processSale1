package se.kth.oop.daniel.duner.procesSale.database;

import se.kth.oop.daniel.duner.procesSale.model.SaleDTO;

/**
 * Represents a database that stores all sales (HARDCODED)
 * 
 * @author danielduner
 *
 */

public class AccountingSystem {
	private SaleDTO[] saleRegister;
	private int latestSaleId = 0;
	private int nextSaleId = 1;
	
	/**
	 * Instantiates the accounting system
	 */
	public AccountingSystem() {
		saleRegister = new SaleDTO[0];
	}

	/**
	 * register a completed sale in the register and saves the id of the latest sale
	 * 
	 * @param saleDTO holds the information of a completed sale
	 */
	public void registerCompletedSale(SaleDTO saleDTO) {
		updateSaleRegister(saleDTO);
		latestSaleId++;
		nextSaleId++;
	}

	private void updateSaleRegister(SaleDTO saleDTO) {	
		SaleDTO[] newSaleRegister = new SaleDTO[nextSaleId];

		for (int i = 0; i < latestSaleId; i++) {
			newSaleRegister[i] = saleRegister[i];
		}
		newSaleRegister[latestSaleId] = saleDTO;
		saleRegister = newSaleRegister.clone();
	}
/**
 * 
 * returns the ID of the last sale
 * 
 * @return returns latest sale ID
 */
	public int getLatestSaleId() {
		return latestSaleId;
	}
}
