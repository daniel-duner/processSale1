package model;

import integration.Amount;
import integration.Item;

/**
 * Handles and contains information about a sale that is needed during a sale
 * process
 * 
 * @author danielduner
 *
 */

public class SaleInformation {
	private Amount runningTotal;
	private Item item;
	private boolean itemValid;
	private int quantity;
	private int noOnList;

	/**
	 * Instantiates a saleInformation
	 */
	public SaleInformation() {
		runningTotal = null;
		item = null;
		itemValid = false;
		quantity = 0;
		noOnList = 0;
	}

	/**
	 * updates the sale information
	 * 
	 * @param goods represents the goods at a certain time
	 * @param item represents the item that most recently was added to the sale
	 * @throws Exception
	 */
	public void updateSaleInformation(Goods goods, Item item) throws Exception {
		this.updateInformation(goods, item);
		this.quantity = 1;
	}

	/**
	 * updates the sale information when more than one item is added to the sale
	 * 
	 * @param goods represents the goods at a certain time
	 * @param item represents the item that most recently was added to the sale
	 * @param quantity represents the quantity added of the item
	 * @throws Exception
	 */

	public void updateSaleInformation(Goods goods, Item item, int quantity) throws Exception {
		this.updateInformation(goods, item);
		this.quantity = quantity;
	}

	public int getNoOnList() {
		return noOnList;
	}

	public Amount getRunningTotal() {
		return runningTotal;
	}

	public boolean getItemValid() {
		return itemValid;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}

	private void updateInformation(Goods goods, Item item) throws Exception {
		runningTotal = new Amount(goods.getPrice().getAmount());
		this.item = item;
		itemValid = item.getItemValid();
		if (itemValid) {
			noOnList++;
		}
	}
}
