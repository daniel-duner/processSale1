package se.kth.oop.daniel.duner.procesSale.integration;

import se.kth.oop.daniel.duner.procesSale.model.SaleDTO;

/**
 * Represents the system that handles the database that stores all sales (HARDCODED)
 * 
 * @author danielduner
 *
 */

public class AccountingSystemHandler {
	private SaleDTO[] saleRegister;
	
	/**
	 * Instantiates the accounting system
	 */
	public AccountingSystemHandler() {
		saleRegister = new SaleDTO[0];
	}

	/**
	 * register a completed sale in the register and saves the id of the latest sale
	 * 
	 * @param saleDTO holds the information of a completed sale
	 */
	public void registerCompletedSale(SaleDTO saleDTO) {
		updateSaleRegister(saleDTO);
	}

	private void updateSaleRegister(SaleDTO saleDTO) {	
		SaleDTO[] newSaleRegister = new SaleDTO[this.getNextSaleId()];

		for (int i = 0; i < this.getLatestSaleId(); i++) {
			newSaleRegister[i] = saleRegister[i];
		}
		newSaleRegister[this.getLatestSaleId()] = saleDTO;
		saleRegister = newSaleRegister.clone();
	}
/**
 * 
 * returns the ID of the last sale
 * 
 * @return returns latest sale ID
 */
	public int getLatestSaleId() {
		return saleRegister.length;
	}
	/**
	 * returns the ID of the nextSale
	 * @return
	 */
	private int getNextSaleId() {
		return saleRegister.length+1;
	}
}
