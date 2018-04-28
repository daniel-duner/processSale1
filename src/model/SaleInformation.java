package model;

import integration.Item;

public class SaleInformation {
	private Amount runningTotal;
	private Item item;
	private boolean itemValid;

	public SaleInformation(){
		runningTotal = null;
		item = null;
		itemValid = false;
	}

	public void updateSaleInformation(Goods goods, Item item) throws Exception {
		this.runningTotal = new Amount(goods.getPrice().getAmount());
		this.item = item;
		this.itemValid = item.getItemValid();
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
}
