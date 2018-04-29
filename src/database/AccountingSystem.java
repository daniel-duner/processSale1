package database;

import model.SaleDTO;

public class AccountingSystem {
	private SaleDTO[] saleRegister;
	private int latestSaleId = 100;

	public AccountingSystem() {
		saleRegister = new SaleDTO[0];
	}
	public void registerCompletedSale(SaleDTO saleDTO){
		latestSaleId = saleDTO.getSaleId();
		updateSaleRegister(saleDTO);
	}
	
	public void updateSaleRegister(SaleDTO saleDTO) {
		SaleDTO[] newSaleRegister = new SaleDTO[saleRegister.length + 1];
		int lastElement = newSaleRegister.length - 1;

		for (int i = 0; i < lastElement; i++) {
			newSaleRegister[i] = saleRegister[i];
		}
		newSaleRegister[lastElement] = saleDTO;
		saleRegister = newSaleRegister.clone();
	}
	public int getLatestSaleId() {
		return latestSaleId;
	}
}
