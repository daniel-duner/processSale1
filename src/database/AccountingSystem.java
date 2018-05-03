package database;

import model.SaleDTO;

/**
 * Represents a database that stores all sales (HARDCODED)
 * 
 * @author danielduner
 *
 */

public class AccountingSystem {
	private SaleDTO[] saleRegister;
	private int latestSaleId = 100;
	
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
		latestSaleId = saleDTO.getSaleId();
		updateSaleRegister(saleDTO);
	}

	private void updateSaleRegister(SaleDTO saleDTO) {
		SaleDTO[] newSaleRegister = new SaleDTO[saleRegister.length + 1];
		int lastElement = newSaleRegister.length - 1;

		for (int i = 0; i < lastElement; i++) {
			newSaleRegister[i] = saleRegister[i];
		}
		newSaleRegister[lastElement] = saleDTO;
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
